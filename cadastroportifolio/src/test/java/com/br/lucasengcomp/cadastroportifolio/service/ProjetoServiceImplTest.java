package com.br.lucasengcomp.cadastroportifolio.service;

import com.br.lucasengcomp.cadastroportifolio.builders.ProjetoBuilder;
import com.br.lucasengcomp.cadastroportifolio.core.exceptions.services.ConstraintViolationExceptionDatabase;
import com.br.lucasengcomp.cadastroportifolio.core.exceptions.services.ResourceNotFoundException;
import com.br.lucasengcomp.cadastroportifolio.core.mappers.ProjetoMapper;
import com.br.lucasengcomp.cadastroportifolio.domain.dtos.projeto.AtualizarProjetoDTO;
import com.br.lucasengcomp.cadastroportifolio.domain.dtos.projeto.EntidadeProjetoDTO;
import com.br.lucasengcomp.cadastroportifolio.domain.entities.Projeto;
import com.br.lucasengcomp.cadastroportifolio.domain.repositories.PessoaRepository;
import com.br.lucasengcomp.cadastroportifolio.domain.repositories.ProjetoRepository;
import com.br.lucasengcomp.cadastroportifolio.domain.service.impl.ProjetoServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.br.lucasengcomp.cadastroportifolio.core.utils.UtilsMensagemPadrao.EXCECAO_GERENTE_NAO_EXISTENTE;
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
    @DisplayName("Deve buscar por id existente e retornar status code OK")
    void buscarPorId_deveRetornarEntidadeProjetoDTOQuandoEncontrado() {
        Projeto projeto = ProjetoBuilder.criarProjeto1();
        when(repository.findById(1L)).thenReturn(Optional.of(projeto));
        EntidadeProjetoDTO projetoDTO = service.buscarPorId(1L);
        assertEquals(1L, projetoDTO.getId());
    }

    @Test
    void buscarPorId_deveLancarExcecaoQuandoProjetoNaoEncontrado() {
        when(repository.findById(100L)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> {
            service.buscarPorId(100L);
        });
    }

    @Test
    @DisplayName("Deve cadastrar com sucesso retornar status code CREATED e verififcar alguns campos retornados")
    void cadastrar_deveCadastrarComSucesso() {
        Projeto projeto = ProjetoBuilder.criarProjeto1();
        Mockito.when(repository.save(ArgumentMatchers.any())).thenReturn(projeto);
        repository.save(projeto);
        assertEquals(1L, projeto.getId());
        assertEquals("MacOS", projeto.getNome());
        assertEquals("MacOS", projeto.getNome());
        assertEquals("Sistema operacional fluido e compatível", projeto.getDescricao());
    }

    @Test
    @DisplayName("Deve cadastrar com sucesso retornar status code CREATED e verififcar alguns campos retornados")
    void cadastrar_deveLancarExcessaoAoTentarCadastrarProjetoComDadosInvalidos() {
        assertThrows(ConstraintViolationExceptionDatabase.class, () -> {
            service.cadastrar(mapper.toInserir(ProjetoBuilder.criarProjeto2()));
        });
    }

    @Test
    @DisplayName("Deve verificar a mensagem retornada ao tentar executar um cadastro inválido")
    void cadastrar_deveRetornarMensagemConformeExcessaoAoTentarCadastrarProjetoInvalido() {
        ConstraintViolationExceptionDatabase excecao = assertThrows(ConstraintViolationExceptionDatabase.class, () -> {
            service.cadastrar(mapper.toInserir(ProjetoBuilder.criarProjeto2()));
        });
        assertEquals(EXCECAO_GERENTE_NAO_EXISTENTE, excecao.getMessage());
    }

    @Test
    @DisplayName("Deve lançar excessão ao tentar atualizar o projeto com informações do DTO inválidas")
    void atualizarPorId_deveLancarExcecaoConstraintViolationExceptionDatabase() {
        AtualizarProjetoDTO dto = ProjetoBuilder.criarAtualizarDTOInvalido();
        ConstraintViolationExceptionDatabase excecao = assertThrows(ConstraintViolationExceptionDatabase.class, () -> {
            service.atualizarPorId(1L, dto);
        });
        assertEquals(EXCECAO_GERENTE_NAO_EXISTENTE, excecao.getMessage());
    }
}
