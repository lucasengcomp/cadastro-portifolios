package com.br.lucasengcomp.cadastroportifolio.domain.controllers.interfaces;

import com.br.lucasengcomp.cadastroportifolio.domain.dtos.projeto.EntidadeProjetoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/projetos")
public interface ProjetoControllerIT {

    @GetMapping("/{id}")
    ResponseEntity<EntidadeProjetoDTO> buscarPorId(@PathVariable Long id);
}
