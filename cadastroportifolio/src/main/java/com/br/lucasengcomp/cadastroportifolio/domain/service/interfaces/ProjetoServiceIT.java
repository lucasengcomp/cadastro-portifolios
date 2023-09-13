package com.br.lucasengcomp.cadastroportifolio.domain.service.interfaces;

import com.br.lucasengcomp.cadastroportifolio.domain.dtos.projeto.EntidadeProjetoDTO;

public interface ProjetoServiceIT {

    EntidadeProjetoDTO buscarPorId(Long id);
}
