package com.teste.itau.adiantamento.adiantamento.exceptions;

public class ParcelaException extends BusinessException {

    public ParcelaException(Exception exception) {
        super(exception);
    }

    public ParcelaException(String message, ParcelaException parcelaException) {
        super(message, parcelaException);
    }

    public ParcelaException(String message) {
        super(message);
    }
}
