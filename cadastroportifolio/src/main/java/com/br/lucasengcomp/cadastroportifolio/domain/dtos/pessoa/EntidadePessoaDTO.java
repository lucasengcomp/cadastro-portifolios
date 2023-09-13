package com.br.lucasengcomp.cadastroportifolio.domain.dtos.pessoa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntidadePessoaDTO {

    private Long id;

    private String nome;

    private Date dataNascimento;

    private String cpf;

    private boolean funcionario;
}
