package com.meecky.SCRAT.config.exception.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@ToString
public class ExceptionDetailsDto {
    private LocalDateTime timestamp;
    private String message;
    private String details;
    private int code;
}
