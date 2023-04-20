package com.teste.itau.adiantamento.adiantamento.exceptions;

import org.springframework.http.HttpStatus;

public class PagamentoException extends RuntimeException {

    public PagamentoException(String message){
        super(message);
    }
}
