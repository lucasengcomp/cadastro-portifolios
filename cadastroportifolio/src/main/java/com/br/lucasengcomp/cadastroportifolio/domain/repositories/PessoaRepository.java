package com.br.lucasengcomp.cadastroportifolio.domain.repositories;

import com.br.lucasengcomp.cadastroportifolio.domain.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
