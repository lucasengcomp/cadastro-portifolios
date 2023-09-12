package com.br.lucasengcomp.cadastroportifolio.entity.enums;

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

    Status(int posicao, String descricao) {
        this.posicao = posicao;
        this.descricao = descricao;
    }
}
