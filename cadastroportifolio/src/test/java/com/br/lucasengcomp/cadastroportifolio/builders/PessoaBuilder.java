package com.br.lucasengcomp.cadastroportifolio.builders;

import com.br.lucasengcomp.cadastroportifolio.domain.entities.Pessoa;

import java.util.Date;

public class PessoaBuilder {

    private PessoaBuilder() {
    }

    public static Pessoa inserirPessoa1() {
        return new Pessoa(
                1L,
                "Lucas Galvao",
                new Date(1993, 3, 17),
                "999.888.777-55",
                true
        );
    }

    public static Pessoa inserirPessoa2() {
        return new Pessoa(
                null,
                "Steve Jobs",
                new Date(1955, 2, 24),
                "999.888.777-55",
                true
        );
    }
}
