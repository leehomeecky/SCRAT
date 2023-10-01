package com.meecky.SCRAT.auth.controller;

import com.meecky.SCRAT.auth.service.AuthService;
import com.meecky.SCRAT.users.dto.UserDataDto;
import com.meecky.SCRAT.users.dto.UserLoginDto;
import com.meecky.SCRAT.users.dto.UserResponseDataDto;
import com.meecky.SCRAT.users.dto.UserResponseDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

    private AuthService authService;
    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> registerUser(@RequestBody UserDataDto user){
        UserResponseDataDto regUser = authService.registerUser(user);
        UserResponseDto resp = new UserResponseDto();
        resp.setData(Optional.of(regUser));
        resp.setCode(0);
        resp.setDetails("Operation successful");
        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponseDto> login(@RequestBody UserLoginDto loginDetails){
        UserResponseDataDto user = authService.loginUser(loginDetails);
        UserResponseDto resp = new UserResponseDto();
        resp.setData(Optional.of(user));
        resp.setCode(0);
        resp.setDetails("Operation successful");
        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }
}
