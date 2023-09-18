package com.meecky.SCRAT.auth.service;

import com.meecky.SCRAT.users.enums.Roles;
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
public class authService {
    private UserRepo userRepo;
    private Roles roles;
    private PasswordEncoder passwordEncoder;
}
