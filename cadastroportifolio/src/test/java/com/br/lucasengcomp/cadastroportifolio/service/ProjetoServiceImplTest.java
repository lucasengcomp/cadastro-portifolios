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
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static com.br.lucasengcomp.cadastroportifolio.core.utils.UtilsMensagemPadrao.EXCECAO_GERENTE_NAO_EXISTENTE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
//@ActiveProfiles("dev")
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
    @DisplayName("Deve lançar uma exceção quando id não exisitir")
    void buscarPorId_deveLancarExcecaoQuandoProjetoNaoEncontrado() {
        when(repository.findById(100L)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> {
            service.buscarPorId(100L);
        });
    }

    @Test
    @DisplayName("Deve cadastrar com sucesso e verififcar alguns campos retornados")
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

    @Test
    @DisplayName("Deve lançar exceção ao tentar deletar um projeto inexistente")
    void deletarPorId_deveLancarExcecaoAoDeletarProjetoInexistente() {
        Long idProjeto = 1000L;
        when(repository.findById(idProjeto)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            service.deletarPorId(idProjeto);
        });

        verify(repository, never()).delete(any());
    }
}
