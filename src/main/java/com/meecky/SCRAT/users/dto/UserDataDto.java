package com.meecky.SCRAT.users.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDataDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
