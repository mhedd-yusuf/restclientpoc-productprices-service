package com.example.restclientpocproductpricesservice.exception;

import com.example.restclientpocproductpricesservice.common.api.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    ResponseEntity<ApiResponse<String>> notFound(NotFoundException ex) {
        return ResponseEntity.status(404).body(ApiResponse.<String>builder().data(ex.getMessage()).build());
    }
}
