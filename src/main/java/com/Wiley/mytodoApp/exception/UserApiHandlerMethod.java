package com.Wiley.mytodoApp.exception;


import com.Wiley.mytodoApp.dto.UserErrorResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class UserApiHandlerMethod {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<UserErrorResponseDto> handleUserNotFoundException (UserNotFoundException exception,
    HttpServletRequest request){
        HttpStatus status=HttpStatus.NOT_FOUND;
        UserErrorResponseDto errorResponseDto=new UserErrorResponseDto(
                LocalDateTime.now(),
                status.value(),
                status.getReasonPhrase(),
                exception.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(status).body(errorResponseDto);


    }

    @ExceptionHandler
    public ProblemDetail allExceptionHandler(Exception exception){
        HttpStatus status=HttpStatus.INTERNAL_SERVER_ERROR;
        ProblemDetail problemDetail=ProblemDetail.forStatusAndDetail(status, exception.getMessage());
        problemDetail.setProperty("Message",exception.getClass().getSimpleName());
        return problemDetail;
    }

}
