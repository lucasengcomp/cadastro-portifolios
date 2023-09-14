package com.br.lucasengcomp.cadastroportifolio.builders;

import com.br.lucasengcomp.cadastroportifolio.domain.entities.Membro;

import java.util.Arrays;
import java.util.List;

public class MembrosBuilder {

    private MembrosBuilder() {
    }

    public static Membro inserirMembro1() {
        return new Membro(
                ProjetoBuilder.criarProjeto1(),
                PessoaBuilder.inserirPessoa1()
        );
    }

    public static Membro inserirMembro2() {
        return new Membro(
                ProjetoBuilder.criarProjeto1(),
                PessoaBuilder.inserirPessoa2()
        );
    }

    public static List<Membro> membros() {
        return Arrays.asList(inserirMembro1(), inserirMembro2());
    }
}
