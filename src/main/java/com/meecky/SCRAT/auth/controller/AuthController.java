package com.meecky.SCRAT.auth.controller;

import com.meecky.SCRAT.auth.service.AuthService;
import com.meecky.SCRAT.users.dto.UserDataDto;
import com.meecky.SCRAT.users.dto.UserResponseDataDto;
import com.meecky.SCRAT.users.dto.UserResponseDto;
import com.meecky.SCRAT.users.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> registerUser(@RequestBody UserDataDto user){
        UserResponseDataDto regUser = new AuthService().registerUser(user);
        UserResponseDto resp = new UserResponseDto();
        resp.setData(Optional.of(regUser));
        resp.setCode(0);
        resp.setDetails("Operation successful");
        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }
}
