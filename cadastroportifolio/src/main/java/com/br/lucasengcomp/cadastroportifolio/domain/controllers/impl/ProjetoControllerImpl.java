package com.br.lucasengcomp.cadastroportifolio.domain.controllers.impl;

import com.br.lucasengcomp.cadastroportifolio.domain.controllers.interfaces.ProjetoControllerIT;
import com.br.lucasengcomp.cadastroportifolio.domain.dtos.projeto.EntidadeProjetoDTO;
import com.br.lucasengcomp.cadastroportifolio.domain.service.interfaces.ProjetoServiceIT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjetoControllerImpl implements ProjetoControllerIT {

    @Autowired
    private ProjetoServiceIT service;

    @Override
    public ResponseEntity<EntidadeProjetoDTO> buscarPorId(Long id) {
        EntidadeProjetoDTO projeto = service.buscarPorId(id);
        return ResponseEntity.ok().body(projeto);
    }
}
