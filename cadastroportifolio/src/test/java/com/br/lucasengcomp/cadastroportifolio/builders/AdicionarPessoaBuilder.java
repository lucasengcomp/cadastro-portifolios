package com.br.lucasengcomp.cadastroportifolio.builders;

import com.br.lucasengcomp.cadastroportifolio.domain.dtos.pessoa.InserirPessoaDTO;

import java.util.Date;

public class AdicionarPessoaBuilder {

    private AdicionarPessoaBuilder() {
    }

    public static InserirPessoaDTO inserirPessoa1() {
        return new InserirPessoaDTO(
                1L,
                "Lucas Galvao",
                new Date(1993, 3, 17),
                "999.888.777-55",
                true
        );
    }

    public static InserirPessoaDTO inserirPessoa2() {
        return new InserirPessoaDTO(
                2L,
                "Steve Jobs",
                new Date(1955, 2, 24),
                "999.888.777-55",
                true
        );
    }
}
