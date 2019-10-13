package com.citi.yinpeng.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity fixException(RuntimeException e) {
        e.printStackTrace();
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
