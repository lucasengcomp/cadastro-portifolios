package com.br.lucasengcomp.cadastroportifolio.service;

import com.br.lucasengcomp.cadastroportifolio.builders.ProjetoBuilder;
import com.br.lucasengcomp.cadastroportifolio.core.exceptions.services.ResourceNotFoundException;
import com.br.lucasengcomp.cadastroportifolio.core.mappers.ProjetoMapper;
import com.br.lucasengcomp.cadastroportifolio.domain.dtos.projeto.EntidadeProjetoDTO;
import com.br.lucasengcomp.cadastroportifolio.domain.entities.Projeto;
import com.br.lucasengcomp.cadastroportifolio.domain.repositories.PessoaRepository;
import com.br.lucasengcomp.cadastroportifolio.domain.repositories.ProjetoRepository;
import com.br.lucasengcomp.cadastroportifolio.domain.service.impl.ProjetoServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProjetoServiceImplTest {

    @InjectMocks
    private ProjetoServiceImpl service;

    @Mock
    private ProjetoRepository repository;

    @Mock
    private PessoaRepository pessoaRepository;

    @Spy
    private ProjetoMapper mapper = Mappers.getMapper(ProjetoMapper.class);

    @Test
    void buscarPorId_DeveRetornarProjetoDTOQuandoEncontrado() {
        Projeto projeto = ProjetoBuilder.criarProjeto();
        when(repository.findById(1L)).thenReturn(Optional.of(projeto));
        EntidadeProjetoDTO projetoDTO = service.buscarPorId(1L);
        assertEquals(1L, projetoDTO.getId());
    }

    @Test
    void buscarPorId_DeveLancarExcecaoQuandoProjetoNaoEncontrado() {
        when(repository.findById(100L)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> {
            service.buscarPorId(100L);
        });
    }
}
