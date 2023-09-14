package com.br.lucasengcomp.cadastroportifolio.builders;

import com.br.lucasengcomp.cadastroportifolio.domain.dtos.projeto.AtualizarProjetoDTO;
import com.br.lucasengcomp.cadastroportifolio.domain.entities.Projeto;
import com.br.lucasengcomp.cadastroportifolio.domain.entities.enums.Risco;
import com.br.lucasengcomp.cadastroportifolio.domain.entities.enums.Status;

import java.math.BigDecimal;
import java.util.Date;

import static com.br.lucasengcomp.cadastroportifolio.builders.PessoaBuilder.inserirPessoa2;

public class ProjetoBuilder {

    private ProjetoBuilder() {
    }

    public static Projeto criarProjeto1() {
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
                inserirPessoa2(),
                MembrosBuilder.membros()
        );
    }

    public static Projeto criarProjeto2() {
        return new Projeto(
                2L,
                "Projeto Office",
                new Date(2002, 1, 1),
                new Date(2055, 12, 31),
                new Date(2050, 1, 1),
                "Pacote office essencial para uso diário em escritórios.",
                Status.ANALISE_REALIZADA,
                new BigDecimal(10000000.00),
                Risco.MEDIO,
                inserirPessoa2(),
                null
        );
    }

    public static AtualizarProjetoDTO criarAtualizarDTOInvalido() {
        return new AtualizarProjetoDTO(
                "MacOS",
                new Date(1984, 1, 1),
                new Date(2070, 12, 31),
                new Date(2045, 1, 1),
                "Um Novo Sistema operacional mais fluido eficaz!",
                new BigDecimal(10000000.00),
                Status.ANALISE_COMPROVADA,
                PessoaBuilder.inserirPessoa2()
        );
    }

    public static AtualizarProjetoDTO criarAtualizarDTOValido() {
        return new AtualizarProjetoDTO(
                "MacOS",
                new Date(1984, 1, 1),
                new Date(2070, 12, 31),
                new Date(2045, 1, 1),
                "Um Novo Sistema operacional mais fluido eficaz!",
                new BigDecimal(10000000.00),
                Status.EM_ANALISE,
                PessoaBuilder.inserirPessoa1()
        );
    }
}
