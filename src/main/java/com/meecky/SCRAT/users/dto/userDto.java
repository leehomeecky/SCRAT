package com.meecky.SCRAT.users.dto;

import com.meecky.SCRAT.users.enums.SubCycle;

public record userDto(Long id,
                      String firstName,
                      String lastName,
                      String email,
                      SubCycle subscriptionCycle

) {
}
