package com.br.lucasengcomp.cadastroportifolio.core.exceptions.services;

public class ConstraintViolationException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ConstraintViolationException(String mensagem) {
        super(mensagem);
    }
}
