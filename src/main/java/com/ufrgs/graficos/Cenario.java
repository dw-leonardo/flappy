package com.ufrgs.graficos;

public class Cenario extends ElementoGrafico{

    protected double vScroll;

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

    public double getvScroll() {
        return vScroll;
    }

}
