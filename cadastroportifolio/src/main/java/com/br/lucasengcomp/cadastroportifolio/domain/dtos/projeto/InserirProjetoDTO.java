package com.br.lucasengcomp.cadastroportifolio.domain.dtos.projeto;

import com.br.lucasengcomp.cadastroportifolio.domain.entities.Pessoa;
import com.br.lucasengcomp.cadastroportifolio.domain.entities.enums.Risco;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InserirProjetoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nome;

    private LocalDateTime dataInicio;

    private LocalDateTime dataPrevisaoFim;

    private LocalDateTime dataFim;

    private String descricao;

    private BigDecimal orcamento;

    @JsonProperty("status")
    private int statusId;

    private Risco risco;

    private Pessoa gerente;
}
