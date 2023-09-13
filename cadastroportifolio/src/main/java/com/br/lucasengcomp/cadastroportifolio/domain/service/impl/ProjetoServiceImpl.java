package com.br.lucasengcomp.cadastroportifolio.domain.service.impl;


import com.br.lucasengcomp.cadastroportifolio.core.exceptions.services.ConstraintViolationExceptionDatabase;
import com.br.lucasengcomp.cadastroportifolio.core.exceptions.services.ResourceNotFoundException;
import com.br.lucasengcomp.cadastroportifolio.core.mappers.ProjetoMapper;
import com.br.lucasengcomp.cadastroportifolio.domain.dtos.projeto.AtualizarProjetoDTO;
import com.br.lucasengcomp.cadastroportifolio.domain.dtos.projeto.EntidadeProjetoDTO;
import com.br.lucasengcomp.cadastroportifolio.domain.dtos.projeto.InserirProjetoDTO;
import com.br.lucasengcomp.cadastroportifolio.domain.entities.Projeto;
import com.br.lucasengcomp.cadastroportifolio.domain.repositories.PessoaRepository;
import com.br.lucasengcomp.cadastroportifolio.domain.repositories.ProjetoRepository;
import com.br.lucasengcomp.cadastroportifolio.domain.service.interfaces.ProjetoServiceIT;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.br.lucasengcomp.cadastroportifolio.core.utils.UtilsMensagemPadrao.*;

@Service
@AllArgsConstructor
public class ProjetoServiceImpl implements ProjetoServiceIT {

    private ProjetoRepository repository;

    private PessoaRepository pessoaRepository;

    private ProjetoMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public EntidadeProjetoDTO buscarPorId(Long id) {
        Projeto projetoEncontrado = buscaProjetoPorId(id);

        return mapper.toEntidadeDTO(projetoEncontrado);
    }

    @Override
    @Transactional
    public EntidadeProjetoDTO cadastrar(InserirProjetoDTO dto) {
        if (!isGerenteCadastrado(dto.getGerente().getId())) {
            throw new ConstraintViolationExceptionDatabase(EXCECAO_GERENTE_NAO_EXISTENTE);
        }
        Projeto projeto = repository.save(mapper.toEntidade(dto));

        return mapper.toEntidadeDTO(projeto);
    }

    @Override
    public EntidadeProjetoDTO atualizarPorId(Long id, AtualizarProjetoDTO dto) throws ResourceNotFoundException {

        Optional<Projeto> projetoEncontrado = repository.findById(id);

        if (!isGerenteCadastrado(dto.getGerente().getId())) {
            throw new ConstraintViolationExceptionDatabase(EXCECAO_GERENTE_NAO_EXISTENTE);
        }

        if (projetoEncontrado.isPresent()) {
            Projeto projeto = projetoEncontrado.get();
            mapper.toAtualizarDTOToEntity(dto, projeto);
            projeto = repository.save(projeto);

            return mapper.toEntidadeDTO(projeto);
        } else {
            throw new ResourceNotFoundException(RECURSO_NAO_ENCONTRADO);
        }
    }


    private Projeto buscaProjetoPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ID_NAO_ENCONTRADO + id));
    }


    private boolean isGerenteCadastrado(Long idGerente) {
        return pessoaRepository.findById(idGerente).isPresent();
    }
}
