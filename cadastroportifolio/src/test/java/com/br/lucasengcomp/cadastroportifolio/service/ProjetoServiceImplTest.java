package com.br.lucasengcomp.cadastroportifolio.service;

import com.br.lucasengcomp.cadastroportifolio.core.exceptions.services.ConstraintViolationExceptionDatabase;
import com.br.lucasengcomp.cadastroportifolio.core.exceptions.services.ResourceNotFoundException;
import com.br.lucasengcomp.cadastroportifolio.core.mappers.ProjetoMapper;
import com.br.lucasengcomp.cadastroportifolio.domain.dtos.projeto.AtualizarProjetoDTO;
import com.br.lucasengcomp.cadastroportifolio.domain.dtos.projeto.InserirProjetoDTO;
import com.br.lucasengcomp.cadastroportifolio.domain.entities.Pessoa;
import com.br.lucasengcomp.cadastroportifolio.domain.entities.Projeto;
import com.br.lucasengcomp.cadastroportifolio.domain.entities.enums.Risco;
import com.br.lucasengcomp.cadastroportifolio.domain.entities.enums.Status;
import com.br.lucasengcomp.cadastroportifolio.domain.repositories.PessoaRepository;
import com.br.lucasengcomp.cadastroportifolio.domain.repositories.ProjetoRepository;
import com.br.lucasengcomp.cadastroportifolio.domain.service.impl.ProjetoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static com.br.lucasengcomp.cadastroportifolio.core.utils.UtilsMensagemPadrao.EXCECAO_GERENTE_NAO_EXISTENTE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

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

    private Long idExistente;
    private Long idInexistente;

    @BeforeEach
    void setUp() {
        idExistente = 1L;
        idInexistente = 1000L;
    }

    @Test
    @DisplayName("Deve lançar uma exceção quando id não existir")
    void buscarPorId_deveLancarExcecaoQuandoProjetoNaoEncontrado() {
        when(repository.findById(idInexistente)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> {
            service.buscarPorId(idInexistente);
        });
    }

    @Test
    @DisplayName("Deve cadastrar com sucesso e verififcar alguns campos retornados")
    void cadastrar_deveLancarExcessaoAoTentarCadastrarProjetoComDadosInvalidos() {
        InserirProjetoDTO inserirProjetoDTO = criaProjetoComPessoaComum();
        Projeto entidade = mapper.toEntidade(inserirProjetoDTO);

        assertThrows(ConstraintViolationExceptionDatabase.class, () -> {
            service.cadastrar(mapper.toInserir(entidade));
        });
    }

    @Test
    @DisplayName("Deve verificar a mensagem retornada ao tentar executar um cadastro inválido")
    void cadastrar_deveRetornarMensagemConformeExcessaoAoTentarCadastrarProjetoInvalido() {
        AtualizarProjetoDTO atualizarProjetoDTO = atualizaProjetoComGerente();
        Projeto atualizarDTOToEntity = mapper.toAtualizarDTOToEntity(atualizarProjetoDTO);

        ConstraintViolationExceptionDatabase excecao = assertThrows(ConstraintViolationExceptionDatabase.class, () -> {
            service.cadastrar(mapper.toInserir(atualizarDTOToEntity));
        });
        assertEquals(EXCECAO_GERENTE_NAO_EXISTENTE, excecao.getMessage());
    }

    @Test
    @DisplayName("Deve lançar exceção ao tentar deletar um projeto inexistente")
    void deletarPorId_deveLancarExcecaoAoDeletarProjetoInexistente() {
        when(repository.findById(idExistente)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> {
            service.deletarPorId(idExistente);
        });
        verify(repository, never()).delete(any());
    }

    private AtualizarProjetoDTO atualizaProjetoComGerente() {
        return AtualizarProjetoDTO.builder()
                .nome("Novo Projeto")
                .dataInicio(LocalDateTime.now())
                .dataPrevisaoFim(LocalDateTime.now().plusMonths(6))
                .descricao("Descrição do Novo Projeto")
                .orcamento(BigDecimal.valueOf(100000))
                .gerente(criaPessoaGerente())
                .status(Status.INICIADO)
                .build();
    }

    private InserirProjetoDTO criaProjetoComPessoaComum() {
        return InserirProjetoDTO.builder()
                .nome("Novo Projeto")
                .dataInicio(LocalDateTime.now())
                .dataPrevisaoFim(LocalDateTime.now().plusMonths(6))
                .descricao("Descrição do Novo Projeto")
                .orcamento(BigDecimal.valueOf(100000))
                .statusId(Status.ANALISE_COMPROVADA.getValue())
                .risco(Risco.ALTO)
                .gerente(criaPessoaComum())
                .build();
    }

    private static Pessoa criaPessoaGerente() {
        return new Pessoa(
                1L,
                "Bill Gates",
                LocalDateTime.of(1970, 1, 1, 0, 0),
                "123.456.789-01",
                true);
    }

    private static Pessoa criaPessoaComum() {
        return new Pessoa(
                2L,
                "Albus Dumbledore",
                LocalDateTime.of(1817, 1, 1, 0, 0),
                "555.444.789-01",
                false);
    }
}
