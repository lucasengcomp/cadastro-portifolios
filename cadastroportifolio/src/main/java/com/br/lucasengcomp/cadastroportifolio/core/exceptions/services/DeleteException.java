package com.br.lucasengcomp.cadastroportifolio.core.exceptions.services;

public class DeleteException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public DeleteException(String mensagem) {
        super(mensagem);
    }
}
