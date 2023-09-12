package com.br.lucasengcomp.cadastroportifolio.entity;


import java.io.Serializable;


public class Membro implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long idProjeto;

    private Long idPessoa;

    private Projeto projeto;

    private Pessoa pessoa;
}
