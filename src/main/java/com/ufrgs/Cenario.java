package com.ufrgs;

public class Cenario extends ElementoGrafico{

    private double vScroll;

    public Cenario(String caminho, double vScroll){
        super(caminho);
        this.vScroll = vScroll;
    }

    public void atualizar() {
        this.mover(getPosX() - 1, getPosY());
    }

}
