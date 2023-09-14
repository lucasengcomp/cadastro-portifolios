package com.br.lucasengcomp.cadastroportifolio;


import com.br.lucasengcomp.cadastroportifolio.domain.entities.enums.Status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("dev")
class ProjetoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private Long idExistente;

    @BeforeEach
    void setUp() {
        idExistente = 1L;
    }

    @Test
    @DisplayName("Deve buscar um projeto por id e retornar status code 200")
    void buscarPorId_deveRetornarStatusCode200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/projetos/buscar/{id}", idExistente))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("Deve buscar um projeto por id e retornar status code 200 e campos correspondentes")
    void buscarPorId_deveRetornarComDadosPreenchidos() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/projetos/buscar/{id}", idExistente))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.nome").value("Projeto Google Chrome"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.dataInicio").value("2022-01-15T03:00:00.000+00:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.descricao").value("Desenvolvimento do Navegador Google Chrome"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.orcamento").value(5000000.00))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("ENCERRADO"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.risco").value("MEDIO"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.gerente.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.gerente.nome").value("Brian May"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.gerente.dataNascimento").value("1947-07-19T03:00:00.000+00:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.gerente.cpf").value("987.654.321-00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.gerente.funcionario").value(true));
    }
}
