package com.meecky.SCRAT.users.repository;

import com.meecky.SCRAT.users.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findByEmail(String email);
}
