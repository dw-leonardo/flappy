package com.ufrgs;

import java.util.ArrayList;

public class Main {
    public static void main(String args[]) {
        ArrayList<Score> pontuacoes = new ArrayList<>();
        Flappy jogo = new Flappy();
        pontuacoes = (ArrayList<Score>) ManipuladorSerializaveis.desserializa("pontuacoes.poo");
        pontuacoes.add(jogo.inicializar());
        pontuacoes.sort(new OrdenadorScores());
        if(pontuacoes.size()>10) {
            pontuacoes.remove(10);
        }
       
        ManipuladorSerializaveis.serializa("pontuacoes.poo", pontuacoes); 
    }
}