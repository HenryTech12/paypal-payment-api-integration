package com.payment.api.exceptionhandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.paypal.core.rest.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ControllerAdvice
public class PaymentExceptionHandler {

    @ExceptionHandler(PayPalRESTException.class)
    public ResponseEntity<String> handlePaymentException(PayPalRESTException e) {
        return  new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

     @ExceptionHandler(Exception.class)
     public ResponseEntity<String> handleExceptions(Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
     }
}
