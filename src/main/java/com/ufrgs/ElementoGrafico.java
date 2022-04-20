package com.ufrgs;

import static com.raylib.Jaylib.*;

public class ElementoGrafico {

    //referente a coordenada do canto esquerdo superior de renderizacao do ElementoGrafico.
    protected Vector2 pos;
    /* Vetor coluna e referente a uma caixa de colisao do ElementoGrafico.
    col deve ter ambas coordenadas maior do que pos.
    O tamanho pratico do ElementoGrafico e col-pos. */
    protected Vector2 col;
    protected Texture textura;

    protected double escala;

    public ElementoGrafico(String caminho, double escala) {
        this.pos = new Vector2(0,0);
        this.col = new Vector2(10,10);
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
    
        /* A posicao da caixa de colisao deve ser col-pos(tamanho do ElementoGrafico) apos a coordenada
        do canto esquerdo superior do ElementoGrafico */
        col.x((float) (col.x() - pos.x() + x));
        col.y((float) (col.y() - pos.y() + y));

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
