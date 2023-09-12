package com.br.lucasengcomp.cadastroportifolio.entity.enums;

public enum Risco {

    ALTO(1, "Alto"),
    MEDIO(2, "Medio"),
    BAIXO(3, "Baixo");

    private final int posicao;
    private final String descricao;

    Risco(int posicao, String descricao) {
        this.posicao = posicao;
        this.descricao = descricao;
    }
}
