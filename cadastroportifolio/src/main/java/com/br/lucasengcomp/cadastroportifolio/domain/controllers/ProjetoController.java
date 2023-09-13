package com.br.lucasengcomp.cadastroportifolio.domain.controllers;

import com.br.lucasengcomp.cadastroportifolio.domain.dtos.projeto.EntidadeProjetoDTO;
import com.br.lucasengcomp.cadastroportifolio.domain.dtos.projeto.InserirProjetoDTO;
import com.br.lucasengcomp.cadastroportifolio.domain.service.interfaces.ProjetoServiceIT;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@AllArgsConstructor
@RequestMapping("/projetos")
public class ProjetoController {

    private ProjetoServiceIT service;

    @GetMapping("/{id}")
    public ResponseEntity<EntidadeProjetoDTO> buscarPorId(@PathVariable Long id) {
        EntidadeProjetoDTO projeto = service.buscarPorId(id);
        return ResponseEntity.ok().body(projeto);
    }

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
}
