package com.br.lucasengcomp.cadastroportifolio.entity;

import com.br.lucasengcomp.cadastroportifolio.entity.enums.Risco;
import com.br.lucasengcomp.cadastroportifolio.entity.enums.Status;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Projeto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
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
    private Status status;

    private BigDecimal orcamento;

    @Column(length = 45)
    private Risco risco;

    @ManyToOne
    @JoinColumn(name = "idgerente", referencedColumnName = "id", nullable = false)
    private Pessoa gerente;

}
