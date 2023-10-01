package com.meecky.SCRAT.users.repository;

import com.meecky.SCRAT.users.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findByEmailIgnoreCase(String email);
}
