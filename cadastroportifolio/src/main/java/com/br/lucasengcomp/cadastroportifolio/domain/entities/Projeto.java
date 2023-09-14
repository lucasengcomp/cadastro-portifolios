package com.br.lucasengcomp.cadastroportifolio.domain.entities;

import com.br.lucasengcomp.cadastroportifolio.domain.entities.enums.Risco;
import com.br.lucasengcomp.cadastroportifolio.domain.entities.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Projeto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(length = 200, nullable = false)
    private String nome;

    @Column(name = "data_inicio")
    private Date dataInicio;

    @Column(name = "data_previsao_fim")
    private Date dataPrevisaoFim;

    @Column(name = "data_fim")
    private Date dataFim;

    @Column(length = 5000)
    private String descricao;

    @Column(length = 45)
    @Enumerated(EnumType.ORDINAL)
    private Status status;

    private BigDecimal orcamento;

    @Column(length = 45)
    private Risco risco;

    @ManyToOne
    @JoinColumn(name = "idgerente",
            referencedColumnName = "id",
            nullable = false)
    private Pessoa gerente;

    @OneToMany(orphanRemoval = true, mappedBy = "projeto", fetch = FetchType.EAGER)
    private List<Membro> membros;
}
