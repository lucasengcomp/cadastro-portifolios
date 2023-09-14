package com.br.lucasengcomp.cadastroportifolio.domain.entities.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum Status {

    ANALISE_REALIZADA(1),
    ANALISE_COMPROVADA(2),
    CANCELADO(3),
    EM_ANALISE(4),
    EM_ANDAMENTO(5),
    ENCERRADO(6),
    INICIADO(7),
    PLANEJADO(8);

    private final int value;

    public boolean isAtivo() {
        return Arrays.asList(INICIADO.getValue(), EM_ANDAMENTO.getValue(), ENCERRADO.getValue()).contains(this.value);
    }

    public static Status getByValue(int value) {
        return Arrays.stream(Status.values()).filter(status -> status.getValue() == value).findFirst().orElse(ANALISE_REALIZADA);
    }
}
