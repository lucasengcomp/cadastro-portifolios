package com.br.lucasengcomp.cadastroportifolio.domain.entities;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "membros")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Membro implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @ManyToOne
    @JoinColumn(name = "idprojeto",
            referencedColumnName = "id",
            updatable = false)
    private Projeto projeto;

    @ManyToOne
    @JoinColumn(name = "idpessoa",
            referencedColumnName = "id",
            updatable = false)
    private Pessoa pessoa;
}
