package com.meecky.SCRAT.users.dto;

import com.meecky.SCRAT.users.enums.SubCycle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDataDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
