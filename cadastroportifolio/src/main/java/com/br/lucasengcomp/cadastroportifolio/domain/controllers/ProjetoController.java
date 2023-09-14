package com.br.lucasengcomp.cadastroportifolio.domain.controllers;

import com.br.lucasengcomp.cadastroportifolio.domain.dtos.projeto.AtualizarProjetoDTO;
import com.br.lucasengcomp.cadastroportifolio.domain.dtos.projeto.EntidadeProjetoDTO;
import com.br.lucasengcomp.cadastroportifolio.domain.dtos.projeto.InserirProjetoDTO;
import com.br.lucasengcomp.cadastroportifolio.domain.service.interfaces.ProjetoServiceIT;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


@RestController
@AllArgsConstructor
@RequestMapping("/projetos")
@Api(value = "Endpoints para manipulação de Projetos")
public class ProjetoController {

    private ProjetoServiceIT service;

    @ApiOperation(value = "Busca um Projeto por ID passado na requisição")
    @GetMapping("/buscar/{id}")
    public ResponseEntity<EntidadeProjetoDTO> buscarPorId(@PathVariable Long id) {
        EntidadeProjetoDTO projeto = service.buscarPorId(id);
        return ResponseEntity.ok().body(projeto);
    }

    @ApiOperation(value = "Faz a inserção de um novo Projeto e mostra-o no corpo da resposta")
    @PostMapping("/cadastrar")
    public ResponseEntity<EntidadeProjetoDTO> cadastrar(@RequestBody InserirProjetoDTO dto) {
        EntidadeProjetoDTO dtos = service.cadastrar(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dtos.getId())
                .toUri();
        return ResponseEntity.created(uri).body(dtos);
    }

    @ApiOperation(value = "Faz a atualização de um Projeto por um ID passado e mostra no corpo da requisição")
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<EntidadeProjetoDTO> atualizarPorId(@PathVariable Long id,
                                                             @RequestBody AtualizarProjetoDTO dto) {
        EntidadeProjetoDTO registroAtualizado = service.atualizarPorId(id, dto);
        return ResponseEntity.ok().body(registroAtualizado);
    }

    @ApiOperation(value = "Deleta um registro por ID passado no corpo da requisição")
    @DeleteMapping(value = "/deletar/{id}")
    public ResponseEntity<Void> deletePorId(@PathVariable Long id) {
        service.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
