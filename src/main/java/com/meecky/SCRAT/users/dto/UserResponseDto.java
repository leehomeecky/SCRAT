package com.meecky.SCRAT.users.dto;

import com.meecky.SCRAT.global.ResponseDto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserResponseDto implements ResponseDto {
    private Optional<UserResponseDataDto> data;
    private LocalDateTime timestamp;
    private Optional<String> message;
    private String details;
    private int code;
}
