package com.br.lucasengcomp.cadastroportifolio.core.mappers;

import com.br.lucasengcomp.cadastroportifolio.domain.dtos.pessoa.EntidadePessoaDTO;
import com.br.lucasengcomp.cadastroportifolio.domain.dtos.pessoa.InserirPessoaDTO;
import com.br.lucasengcomp.cadastroportifolio.domain.entities.Pessoa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PessoaMapper {

    Pessoa toEntidade(InserirPessoaDTO pessoa);

    EntidadePessoaDTO toInserir(Pessoa pessoa);
}
