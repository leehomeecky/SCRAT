package com.meecky.SCRAT.users.dto;

import com.meecky.SCRAT.global.ResponseDto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserResponseDto implements ResponseDto {
    private Optional<UserResponseDataDto> data;
    private LocalDateTime timestamp = LocalDateTime.now();
    private Optional<String> message = Optional.empty();
    private String details;
    private int code;
}
