package com.meecky.SCRAT.auth.service;

import com.meecky.SCRAT.auth.interfaces.AuthServiceInterface;
import com.meecky.SCRAT.config.exception.NotAcceptableException;
import com.meecky.SCRAT.users.dto.UserDataDto;
import com.meecky.SCRAT.users.dto.UserResponseDataDto;
import com.meecky.SCRAT.users.enums.Roles;
import com.meecky.SCRAT.users.model.UserModel;
import com.meecky.SCRAT.users.repository.UserRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@NoArgsConstructor
@Service
@Transactional
public class AuthService implements AuthServiceInterface {
    private UserRepo userRepo;
    private Roles roles;
    private PasswordEncoder passwordEncoder;

    @Override
    public UserResponseDataDto registerUser(UserDataDto user) throws NotAcceptableException {
        String encodedPass = passwordEncoder.encode(user.getPassword());

        UserModel userModel = new UserModel();
        userModel.setFirstName(user.getFirstName());
        userModel.setLastName(user.getLastName());
        userModel.setEmail(user.getEmail());
        userModel.setPassword(encodedPass);

        userRepo.save(userModel);
        return (new UserResponseDataDto(userModel.getId(),
                userModel.getFirstName(),
                userModel.getLastName(),
                userModel.getEmail(),
                userModel.getSubscriptionCycle()));
    }
}
