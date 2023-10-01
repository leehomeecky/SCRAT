package com.meecky.SCRAT.auth.service;

import com.meecky.SCRAT.auth.interfaces.AuthServiceInterface;
import com.meecky.SCRAT.config.auth.TokenService;
import com.meecky.SCRAT.config.exception.ConflictException;
import com.meecky.SCRAT.config.exception.NotAcceptableException;
import com.meecky.SCRAT.config.exception.NotFoundException;
import com.meecky.SCRAT.users.dto.UserDataDto;
import com.meecky.SCRAT.users.dto.UserLoginDto;
import com.meecky.SCRAT.users.dto.UserResponseDataDto;
import com.meecky.SCRAT.users.model.UserModel;
import com.meecky.SCRAT.users.repository.UserRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
@Slf4j
@Service
@Transactional
public class AuthService implements AuthServiceInterface {
    private UserRepo userRepo;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private TokenService tokenService;

    @Override
    public UserResponseDataDto registerUser(UserDataDto user)  {
        String encodedPass = passwordEncoder.encode(user.getPassword());
        try{
        UserModel userModel = new UserModel();
        userModel.setFirstName(user.getFirstName());
        userModel.setLastName(user.getLastName());
        userModel.setEmail(user.getEmail());
        userModel.setPassword(encodedPass);

            UserModel newUser = userRepo.save(userModel);
            return (new UserResponseDataDto(newUser.getId(),
                    newUser.getFirstName(),
                    newUser.getLastName(),
                    newUser.getEmail(),
                    newUser.getSubscriptionCycle(),
                    Optional.empty()));
        }
        catch (Exception e) {
            log.error(e.getMessage());
            throw new ConflictException("email already exist");

        }

    }

    @Override
    public UserResponseDataDto loginUser(UserLoginDto loginDetails) {
        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDetails.email(), loginDetails.password())
            );
            String token = tokenService.generateJwt(auth);

            log.info(token);

            UserModel userModel = userRepo.findByEmailIgnoreCase(loginDetails.email()).get();

            return new UserResponseDataDto(
                                    userModel.getId(),
                                    userModel.getFirstName(),
                                    userModel.getLastName(),
                                    userModel.getEmail(),
                                    userModel.getSubscriptionCycle(),
                                    Optional.of(token)
                            );
        }
        catch (AuthenticationException e){
            log.error(e.getMessage(), e);
            throw new NotFoundException("user credentials not found");
        }
        catch (IllegalArgumentException e) {
            log.error(e.getMessage(), e);
            throw new NotAcceptableException(e.getMessage());
        }
    }
}
