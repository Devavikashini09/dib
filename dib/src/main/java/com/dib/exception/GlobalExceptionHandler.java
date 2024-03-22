package com.dib.exception;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Configuration
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundUser.class)
    public ResponseEntity<Object> NotFoundUser(NotFoundUser e){
        String error="User not found with given id";
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NotFoundCustomer.class)
    public ResponseEntity<Object> NotFoundCustomer(NotFoundUser e){
        String error="Customer not found with given id";
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }



    @ExceptionHandler(DuplicateNameFound.class)
    public ResponseEntity<Object> handleDuplicateName(DuplicateNameFound e) {
         String errorMessage = "username already exist";
           return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);

}
}
