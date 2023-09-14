package com.br.lucasengcomp.cadastroportifolio.domain.dtos.pessoa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtualizarPessoaDTO {

    private String nome;

    private LocalDateTime dataNascimento;

    private String cpf;

    private boolean funcionario;
}
