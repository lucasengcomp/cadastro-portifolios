package com.br.lucasengcomp.cadastroportifolio.core.mappers;


import com.br.lucasengcomp.cadastroportifolio.domain.dtos.projeto.EntidadeProjetoDTO;
import com.br.lucasengcomp.cadastroportifolio.domain.dtos.projeto.InserirProjetoDTO;
import com.br.lucasengcomp.cadastroportifolio.domain.entities.Projeto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjetoMapper {

    InserirProjetoDTO toInserir(Projeto dto);

    Projeto toEntidade(InserirProjetoDTO dto);
    EntidadeProjetoDTO entidadeToDTO(Projeto entidade);
}
