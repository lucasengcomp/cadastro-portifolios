package com.br.lucasengcomp.cadastroportifolio.domain.repositories;

import com.br.lucasengcomp.cadastroportifolio.domain.entities.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
}
