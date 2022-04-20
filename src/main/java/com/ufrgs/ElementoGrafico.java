package com.ufrgs;

import static com.raylib.Jaylib.*;

public class ElementoGrafico {

    //referente a coordenada do canto esquerdo superior de renderizacao do ElementoGrafico.
    protected Vector2 pos;
    protected double largura;
    protected double altura;
    protected Texture textura;

    protected double escala;

    public ElementoGrafico(String caminho, double escala) {

        this.pos = new Vector2(0, 0);
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

        UnloadTexture(this.textura);

    }   

    public void atualizar() {

    }

    public void renderizar(){

        DrawTextureEx(this.textura, this.pos, 0, (float) escala, WHITE);

    }

    public void mover(double x, double y) {

        pos.x((float) x);
        pos.y((float) y);
        
    }

    public boolean testaColisao(Cano c) {
        
        if(this.testaColisao(c)||this.testaColisao(c)) {
            return true;
        } else {
            return false;
        }

    }

    public double getPosX() {
        return pos.x();
    }

    public double getPosY() {
        return pos.y();
    }
}
