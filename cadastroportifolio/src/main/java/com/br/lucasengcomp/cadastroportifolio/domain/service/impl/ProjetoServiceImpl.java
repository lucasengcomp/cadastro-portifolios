package com.br.lucasengcomp.cadastroportifolio.domain.service.impl;


import com.br.lucasengcomp.cadastroportifolio.domain.entities.Projeto;
import com.br.lucasengcomp.cadastroportifolio.domain.dtos.projeto.EntidadeProjetoDTO;
import com.br.lucasengcomp.cadastroportifolio.domain.repositories.ProjetoRepository;
import com.br.lucasengcomp.cadastroportifolio.domain.service.interfaces.ProjetoServiceIT;
import com.br.lucasengcomp.cadastroportifolio.core.mappers.ProjetoMapper;
import com.br.lucasengcomp.cadastroportifolio.core.exceptions.services.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.br.lucasengcomp.cadastroportifolio.core.utils.UtilsMensagemPadrao.RECURSO_NAO_ENCONTRADO;

@Service
public class ProjetoServiceImpl implements ProjetoServiceIT {

    @Autowired
    private ProjetoRepository repository;

    @Autowired
    private ProjetoMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public EntidadeProjetoDTO buscarPorId(Long id) {
        Optional<Projeto> projetoEncontrado = repository.findById(id);
        Projeto projeto = projetoEncontrado.orElseThrow(() -> new ResourceNotFoundException(RECURSO_NAO_ENCONTRADO));
        return mapper.entidadeToDTO(projeto);
    }
}
