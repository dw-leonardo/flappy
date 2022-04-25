package com.ufrgs;

import static com.raylib.Jaylib.*;

public class Cenario extends ElementoGrafico{

    private double vScroll;

    public Cenario(String caminho, double escala, double xInicial, double yInicial, double largura, double altura, double vScroll) {

        super(caminho, escala, xInicial, yInicial, largura, altura);
        this.vScroll = vScroll;

    }

    public void atualizar() {
        mover(getPosX() - vScroll, getPosY());
        if(pos.x() <= -largura) {
            mover(2360, getPosY());
        }
    }

}
