package com.br.lucasengcomp.cadastroportifolio.core.mappers;


import com.br.lucasengcomp.cadastroportifolio.domain.dtos.projeto.AtualizarProjetoDTO;
import com.br.lucasengcomp.cadastroportifolio.domain.dtos.projeto.EntidadeProjetoDTO;
import com.br.lucasengcomp.cadastroportifolio.domain.dtos.projeto.InserirProjetoDTO;
import com.br.lucasengcomp.cadastroportifolio.domain.entities.Projeto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProjetoMapper {

    InserirProjetoDTO toInserir(Projeto dto);

    Projeto toEntidade(InserirProjetoDTO dto);

    EntidadeProjetoDTO toEntidadeDTO(Projeto entidade);

    void toAtualizarDTOToEntity(AtualizarProjetoDTO dto, @MappingTarget Projeto projeto);
}
