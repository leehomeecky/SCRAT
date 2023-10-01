package com.meecky.SCRAT.global;

import java.time.LocalDateTime;

public interface ResponseDto {
    LocalDateTime getTimestamp();
//    String getMessage();
    String getDetails();
    int getCode();
}
