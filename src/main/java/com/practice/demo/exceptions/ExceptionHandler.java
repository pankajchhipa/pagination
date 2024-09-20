package com.practice.demo.exceptions;


import com.practice.demo.model.ExceptionCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;

@RestControllerAdvice

public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(HotelNotFoundException.class)
    public ResponseEntity<ExceptionCode> userNotFoundException(Exception e){

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                        .body(new ExceptionCode("501", e.getMessage(), Arrays.toString(e.getStackTrace())));
    }
}
