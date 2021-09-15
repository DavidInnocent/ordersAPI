package com.innocent.OrderApplication.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ApplicationWideExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> genericHandler(Exception exception, WebRequest request) {
        return new ResponseEntity<>(new ExceptionDetail(new Date(), exception.getMessage(), request.getDescription(false)), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<?> dataNotFoundExceptionHandling(OrderNotFoundException exception, WebRequest request) {
        return new ResponseEntity<>(new ExceptionDetail(new Date(), exception.getMessage(), request.getDescription(false)), HttpStatus.NOT_FOUND);
    }

}
