package com.br.lucasengcomp.cadastroportifolio.domain.entities.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {

    ANALISE_REALIZADA(1, "Análise realizada"),
    ANALISE_COMPROVADA(2, "Análise comprovada"),
    CANCELADO(3, "Cancelado"),
    EM_ANALISE(4, "Em análise"),
    EM_ANDAMENTO(5, "Em andamento"),
    ENCERRADO(6, "Encerrado"),
    INICIADO(7, "Iniciado"),
    PLANEJADO(8, "Planejado");

    private final int posicao;
    private final String descricao;
}
