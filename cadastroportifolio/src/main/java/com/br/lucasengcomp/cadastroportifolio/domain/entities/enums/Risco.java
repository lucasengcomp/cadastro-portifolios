package com.br.lucasengcomp.cadastroportifolio.domain.entities.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Risco {

    ALTO(1, "Alto"),
    MEDIO(2, "Médio"),
    BAIXO(3, "Baixo");

    private final int posicao;
    private final String descricao;

}
