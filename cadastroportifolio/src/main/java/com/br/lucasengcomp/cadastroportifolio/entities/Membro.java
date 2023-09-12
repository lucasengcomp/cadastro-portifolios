package com.br.lucasengcomp.cadastroportifolio.entities;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "membros")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Membro implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idprojeto")
    @EqualsAndHashCode.Include
    private Long idProjeto;

    @Column(name = "idpessoa", nullable = false)
    @EqualsAndHashCode.Include
    private Long idPessoa;

    @ManyToOne
    @JoinColumn(name = "idprojeto",
            referencedColumnName = "id",
            insertable = false,
            updatable = false)
    private Projeto projeto;

    @ManyToOne
    @JoinColumn(name = "idpessoa",
            referencedColumnName = "id",
            insertable = false,
            updatable = false)
    private Pessoa pessoa;
}
