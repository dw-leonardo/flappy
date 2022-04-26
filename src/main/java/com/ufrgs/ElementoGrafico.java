package com.ufrgs;

import static com.raylib.Jaylib.*;

public class ElementoGrafico {

    //referente a coordenada do canto esquerdo superior de renderizacao do ElementoGrafico.
    protected Vector2 pos;
    protected double largura;
    protected double altura;
    protected double escala; //escala de renderização

    protected Texture textura;

    public ElementoGrafico() {

        this.pos = new Vector2(0, 0);
        this.largura = 0;
        this.altura = 0;
        this.escala = 0;
        this.textura = null;

    }

    public ElementoGrafico(String caminho, double escala) {

        this.pos = new Vector2(0, 0);
        this.largura = 0;
        this.altura = 0;
        this.escala = escala;
        this.textura = LoadTexture(caminho);

    }

    public ElementoGrafico(String caminho, double escala, double xInicial, double yInicial) {

        this.pos = new Vector2((float) xInicial, (float) yInicial);
        this.largura = 0;
        this.altura = 0;
        this.escala = escala;
        this.textura = LoadTexture(caminho);

    }

    public ElementoGrafico(String caminho, double escala, double xInicial, double yInicial, double largura, double altura) {

        this.pos = new Vector2((float) xInicial, (float) yInicial);
        this.largura = largura;
        this.altura = altura;
        this.escala = escala;
        this.textura = LoadTexture(caminho);

    }


    public void descarregar() {
        
        if(this.textura != null) UnloadTexture(this.textura);

    }   

    public void atualizar() throws PerdeuException{

    }

    public void renderizar(){

        DrawTextureEx(this.textura, this.pos, 0, (float) escala, WHITE);

    }

    public void mover(double x, double y) {

        pos.x((float) x);
        pos.y((float) y);
        
    }

    public double getPosX() {
        return pos.x();
    }

    public double getPosY() {
        return pos.y();
    }
}
