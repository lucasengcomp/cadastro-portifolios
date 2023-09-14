package com.br.lucasengcomp.cadastroportifolio.core.mappers;


import com.br.lucasengcomp.cadastroportifolio.domain.dtos.projeto.AtualizarProjetoDTO;
import com.br.lucasengcomp.cadastroportifolio.domain.dtos.projeto.EntidadeProjetoDTO;
import com.br.lucasengcomp.cadastroportifolio.domain.dtos.projeto.InserirProjetoDTO;
import com.br.lucasengcomp.cadastroportifolio.domain.entities.Projeto;
import com.br.lucasengcomp.cadastroportifolio.domain.entities.enums.Status;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface ProjetoMapper {

    InserirProjetoDTO toInserir(Projeto dto);


    @Mapping(source = "statusId", target = "status", qualifiedByName = "toStatus")
    Projeto toEntidade(InserirProjetoDTO dto);

    EntidadeProjetoDTO toEntidadeDTO(Projeto entidade);

    void toAtualizarDTOToEntity(AtualizarProjetoDTO dto, @MappingTarget Projeto projeto);


    @Named("toStatus")
    default Status toStatus(int statusId) {
        return Status.getByValue(statusId);
    }
}
