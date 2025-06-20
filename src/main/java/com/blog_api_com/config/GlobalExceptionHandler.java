package com.blog_api_com.config;

import com.blog_api_com.exception.ResourceNotFoundException;
import com.blog_api_com.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> responseNotFoundExHandler(ResourceNotFoundException ex){
        String message = ex.getMessage();
        ApiResponse apiResponse = new ApiResponse(message, false);
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> methodArgsNotValidExHandler(MethodArgumentNotValidException ex){
        Map<String, String> response = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error)-> {
            String fieldName = ((FieldError)error).getField();
            String message = error.getDefaultMessage();
            response.put(fieldName, message);
        });
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
