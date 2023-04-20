package com.teste.itau.adiantamento.adiantamento.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.lang.module.ResolutionException;

@ControllerAdvice
public class BusinessException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PagamentoException.class)
    public ResponseEntity<PagamentoException> pagamentoException(PagamentoException pagamentoException){
       return ResponseEntity.
                status(HttpStatus.INTERNAL_SERVER_ERROR).
                body(new PagamentoException(pagamentoException.getMessage()));
    }

    @ExceptionHandler(ParcelaException.class)
    public ResponseEntity<PagamentoException> pagamentoException(ParcelaException parcelaException){
        return ResponseEntity.
                status(HttpStatus.INTERNAL_SERVER_ERROR).
                body(new PagamentoException(parcelaException.getMessage()));
    }

}
