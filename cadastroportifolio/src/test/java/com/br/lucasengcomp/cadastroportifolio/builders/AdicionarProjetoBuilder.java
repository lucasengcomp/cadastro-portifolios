package com.br.lucasengcomp.cadastroportifolio.builders;

import com.br.lucasengcomp.cadastroportifolio.domain.dtos.projeto.InserirProjetoDTO;
import com.br.lucasengcomp.cadastroportifolio.domain.entities.enums.Risco;
import com.br.lucasengcomp.cadastroportifolio.domain.entities.enums.Status;

import java.math.BigDecimal;
import java.util.Date;

public class AdicionarProjetoBuilder {

    private AdicionarProjetoBuilder() {
    }

    public static InserirProjetoDTO inserirProjeto1() {
        return new InserirProjetoDTO(
                "MacOS",
                new Date(1984, 1, 1),
                new Date(2070, 12, 31),
                new Date(2045, 1, 1),
                "Sistema operacional fluido e compatível",
                BigDecimal.valueOf(1000.00),
                Status.EM_ANDAMENTO.getValue(),
                Risco.BAIXO,
                PessoaBuilder.inserirPessoa2()
        );
    }
}
