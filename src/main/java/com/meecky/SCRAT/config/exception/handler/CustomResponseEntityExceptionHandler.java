package com.meecky.SCRAT.config.exception.handler;

import com.meecky.SCRAT.config.exception.*;
import com.meecky.SCRAT.config.exception.dto.ExceptionDetailsDto;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<? super ExceptionDetailsDto> handleAllException(Exception ex, WebRequest request) throws Exception {
        ExceptionDetailsDto exception = new ExceptionDetailsDto(LocalDateTime.now(), ex.getMessage(), request.getDescription(false), 1);
        return new ResponseEntity<ExceptionDetailsDto>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public final ResponseEntity<? super ExceptionDetailsDto> handleUnauthorizedException(Exception ex, WebRequest request) throws Exception {
        ExceptionDetailsDto exception = new ExceptionDetailsDto(LocalDateTime.now(), ex.getMessage(), request.getDescription(false), 1);
        return new ResponseEntity<ExceptionDetailsDto>(exception, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(ForbiddenException.class)
    public final ResponseEntity<? super ExceptionDetailsDto> handleForbiddenException(Exception ex, WebRequest request) throws Exception {
        ExceptionDetailsDto exception = new ExceptionDetailsDto(LocalDateTime.now(), ex.getMessage(), request.getDescription(false), 1);
        return new ResponseEntity<ExceptionDetailsDto>(exception, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<? super ExceptionDetailsDto> handleNotFoundException(Exception ex, WebRequest request) throws Exception {
        ExceptionDetailsDto exception = new ExceptionDetailsDto(LocalDateTime.now(), ex.getMessage(), request.getDescription(false), 1);
        return new ResponseEntity<ExceptionDetailsDto>(exception, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NotAcceptableException.class)
    public final ResponseEntity<? super ExceptionDetailsDto> handleNotAcceptableException(Exception ex, WebRequest request) throws Exception {
        ExceptionDetailsDto exception = new ExceptionDetailsDto(LocalDateTime.now(), ex.getMessage(), request.getDescription(false), 1);
        return new ResponseEntity<ExceptionDetailsDto>(exception, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(ConflictException.class)
    public final ResponseEntity<? super ExceptionDetailsDto> handleConflictException(Exception ex, WebRequest request) throws Exception {
        ExceptionDetailsDto exception = new ExceptionDetailsDto(LocalDateTime.now(), ex.getMessage(), request.getDescription(false), 1);
        return new ResponseEntity<ExceptionDetailsDto>(exception, HttpStatus.CONFLICT);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ExceptionDetailsDto exception = new ExceptionDetailsDto(LocalDateTime.now(), ex.getFieldError().getDefaultMessage(), request.getDescription(false), 1);
        return new ResponseEntity(exception, HttpStatus.BAD_REQUEST);
    }
}

