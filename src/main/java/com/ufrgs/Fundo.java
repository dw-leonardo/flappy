package com.ufrgs;

public class Fundo extends ElementoGrafico{

    private double vScroll;

    public Fundo(String caminho, double vScroll){
        super(caminho);
    }

    public void atualizar() {
        mover(getPosX() - vScroll, getPosY());
    }

}
