package com.vietle.angularecommercebackend.exception;

import com.vietle.angularecommercebackend.domain.Status;
import com.vietle.angularecommercebackend.util.EcommerceUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class EcommerceControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EcommerceException.class)
    public ResponseEntity<Object> handleEcommerceException(EcommerceException ex, WebRequest request) {
        Status status = Status.builder().statusCd(ex.getStatusCd()).message(ex.getMessage()).timestamp(EcommerceUtil.getTimestamp()).build();
        int statusCd = ex.getStatusCd();
        return new ResponseEntity<>(status, HttpStatus.resolve(statusCd));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Status> handleGenericException(Exception ex, WebRequest request) {
        Status status = Status.builder().statusCd(500).message(ex.getMessage()).timestamp(EcommerceUtil.getTimestamp()).build();
        return new ResponseEntity<>(status, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
