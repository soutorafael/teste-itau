package com.teste.itau.adiantamento.adiantamento.exceptions;

public class BusinessException extends Exception {

    public BusinessException(Exception exception){
        super(exception);
    }

    public BusinessException(String message, BusinessException businessException){
        super(message, businessException);
    }

    public BusinessException(String message){
        super(message);
    }
}
