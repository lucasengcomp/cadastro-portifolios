package com.br.lucasengcomp.cadastroportifolio.builders;

import com.br.lucasengcomp.cadastroportifolio.domain.entities.Projeto;
import com.br.lucasengcomp.cadastroportifolio.domain.entities.enums.Risco;
import com.br.lucasengcomp.cadastroportifolio.domain.entities.enums.Status;

import java.math.BigDecimal;
import java.util.Date;

public class ProjetoBuilder {

    private ProjetoBuilder() {
    }

    public static Projeto criarProjeto() {
        return new Projeto(
                1L,
                "MacOS",
                new Date(1984, 1, 1),
                new Date(2070, 12, 31),
                new Date(2045, 1, 1),
                "Sistema operacional fluido e compatível",
                Status.INICIADO,
                new BigDecimal(10000000.00),
                Risco.BAIXO,
                PessoaBuilder.inserirPessoa2(),
                null
        );
    }
}
