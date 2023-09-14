package com.br.lucasengcomp.cadastroportifolio.domain.service.interfaces;

import com.br.lucasengcomp.cadastroportifolio.domain.dtos.projeto.AtualizarProjetoDTO;
import com.br.lucasengcomp.cadastroportifolio.domain.dtos.projeto.EntidadeProjetoDTO;
import com.br.lucasengcomp.cadastroportifolio.domain.dtos.projeto.InserirProjetoDTO;

public interface ProjetoServiceIT {

    EntidadeProjetoDTO buscarPorId(Long id);

    EntidadeProjetoDTO cadastrar(InserirProjetoDTO dto);

    EntidadeProjetoDTO atualizarPorId(Long id, AtualizarProjetoDTO dto);

    void deletarPorId(Long id);
}
