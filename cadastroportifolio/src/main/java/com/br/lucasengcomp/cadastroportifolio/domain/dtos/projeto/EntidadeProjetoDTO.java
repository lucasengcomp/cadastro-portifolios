package com.br.lucasengcomp.cadastroportifolio.domain.dtos.projeto;

import com.br.lucasengcomp.cadastroportifolio.domain.entities.Pessoa;
import com.br.lucasengcomp.cadastroportifolio.domain.entities.enums.Risco;
import com.br.lucasengcomp.cadastroportifolio.domain.entities.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class EntidadeProjetoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String nome;

    private Date dataInicio;

    private Date dataPrevisaoFim;

    private Date dataFim;

    private String descricao;

    private BigDecimal orcamento;

    private Status status;

    private Risco risco;

    private Pessoa gerente;
}