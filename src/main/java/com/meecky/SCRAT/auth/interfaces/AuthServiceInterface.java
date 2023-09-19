package com.meecky.SCRAT.auth.interfaces;

import com.meecky.SCRAT.users.dto.UserDataDto;
import com.meecky.SCRAT.users.dto.UserResponseDataDto;

public interface AuthServiceInterface {
    UserResponseDataDto registerUser(UserDataDto user);
}
