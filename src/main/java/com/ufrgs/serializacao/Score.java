package com.ufrgs.serializacao;

import java.io.Serializable;

public class Score implements Serializable{
    private String nome;
    private int pontos;

    public Score(String nome, int pontos) {
        this.nome = nome;
        this.pontos = pontos;
    }

    public String getNome() {
        return nome;
    }

    public int getPontos() {
        return pontos;
    }
}