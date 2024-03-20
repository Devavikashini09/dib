package com.dib.exception;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Configuration
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFound.class)
    public ResponseEntity<Object> NotFound(NotFound e){
        String error="id not found";
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }




}
