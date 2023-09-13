package com.br.lucasengcomp.cadastroportifolio.core.exceptions.services;

public class ConstraintViolationExceptionDatabase extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ConstraintViolationExceptionDatabase(String mensagem) {
        super(mensagem);
    }
}
