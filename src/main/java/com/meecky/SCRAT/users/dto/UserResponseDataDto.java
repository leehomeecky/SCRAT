package com.meecky.SCRAT.users.dto;

import com.meecky.SCRAT.users.enums.SubCycle;

import java.util.Optional;

public record UserResponseDataDto(
        Long id,
        String firstName,
        String lastName,
        String email,
        SubCycle subscriptionCycle,
        Optional<String> token

) {
}

