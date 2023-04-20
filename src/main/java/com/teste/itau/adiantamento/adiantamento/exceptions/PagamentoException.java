package com.teste.itau.adiantamento.adiantamento.exceptions;

public class PagamentoException extends BusinessException {

    public PagamentoException(Exception exception) {
        super(exception);
    }

    public PagamentoException(String message, PagamentoException businessException) {
        super(message, businessException);
    }

    public PagamentoException(String message) {
        super(message);
    }
}
