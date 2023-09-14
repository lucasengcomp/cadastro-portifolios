package com.br.lucasengcomp.cadastroportifolio.controller;

import com.br.lucasengcomp.cadastroportifolio.domain.dtos.projeto.InserirProjetoDTO;
import com.br.lucasengcomp.cadastroportifolio.domain.entities.Pessoa;
import com.br.lucasengcomp.cadastroportifolio.domain.entities.enums.Risco;
import com.br.lucasengcomp.cadastroportifolio.domain.entities.enums.Status;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("dev")
class ProjetoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private Long idExistente;
    private Long idInexistente;

    @BeforeEach
    void setUp() {
        idExistente = 1L;
        idInexistente = 1000L;
    }

    @Test
    @DisplayName("Deve buscar um projeto por id e retornar status code 200")
    void buscarPorId_deveRetornarStatusCode200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/projetos/buscar/{id}", idExistente))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("Deve retornar status code 404 quando o projeto não for encontrado")
    void buscarPorId_deveRetornarStatusCode404QuandoIdForInexistente() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/projetos/buscar/{id}", idInexistente)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    @DisplayName("Deve cadastrar um novo projeto com gerente")
    void cadastrar_deveCadastrarUmProjetoComSucesso() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/projetos/cadastrar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(criaProjetoComGerente())))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    @DisplayName("Deve cadastrar um novo projeto com gerente")
    void cadastrar_deveCadastrarLancarExcecaoAoTentarCadastrarPessoaComumComoGerente() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/projetos/cadastrar")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(criaProjetoComPessoaComum())));
    }

    private InserirProjetoDTO criaProjetoComGerente() {
        return InserirProjetoDTO.builder()
                .nome("Novo Projeto")
                .dataInicio(LocalDateTime.now())
                .dataPrevisaoFim(LocalDateTime.now().plusMonths(6))
                .descricao("Descrição do Novo Projeto")
                .orcamento(BigDecimal.valueOf(100000))
                .statusId(Status.ANALISE_COMPROVADA.getValue())
                .risco(Risco.ALTO)
                .gerente(criaPessoaGerente())
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
