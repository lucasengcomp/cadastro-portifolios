package com.br.lucasengcomp.cadastroportifolio.entity;

import java.io.Serializable;
import java.util.Date;


public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String nome;

    private Date dataNascimento;

    private String cpf;

    private boolean funcionario;
}
