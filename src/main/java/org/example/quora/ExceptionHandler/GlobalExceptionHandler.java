package org.example.quora.ExceptionHandler;

import org.example.quora.ApiResponses.LoginApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<LoginApiResponse> handleUserAlreadyExists(UserAlreadyExistsException ex) {
        LoginApiResponse response = LoginApiResponse.builder()
                .message(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.CONFLICT.value()) // 409
                .build();

        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    // Optional: catch-all for other exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<LoginApiResponse> handleGeneralException(Exception ex) {
        LoginApiResponse response = LoginApiResponse.builder()
                .message("Internal server error: " + ex.getMessage())
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .build();

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
