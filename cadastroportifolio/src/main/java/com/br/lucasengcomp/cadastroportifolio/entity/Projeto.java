package com.br.lucasengcomp.cadastroportifolio.entity;

import com.br.lucasengcomp.cadastroportifolio.entity.enums.Risco;
import com.br.lucasengcomp.cadastroportifolio.entity.enums.Status;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


public class Projeto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String nome;

    private Date dataInicio;

    private Date dataPrevisaoFim;

    private Date dataFim;

    private String descricao;

    private Status status;

    private BigDecimal orcamento;

    private Risco risco;

    private Pessoa gerente;
}
