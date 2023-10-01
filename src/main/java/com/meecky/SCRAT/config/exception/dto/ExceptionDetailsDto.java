package com.meecky.SCRAT.config.exception.dto;

import com.meecky.SCRAT.global.ResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@ToString
public class ExceptionDetailsDto implements ResponseDto {
    private LocalDateTime timestamp;
    private String message;
    private String details;
    private int code;
}
