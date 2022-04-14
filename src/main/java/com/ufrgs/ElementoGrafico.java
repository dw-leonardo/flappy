package com.ufrgs;

//import static com.raylib.Raylib.Texture;
import static com.raylib.Jaylib.*;

public class ElementoGrafico {

    protected Vector2 pos;
    protected Vector2 col;
    protected Texture textura;

    public ElementoGrafico(String caminho) {
        this.pos = new Vector2(0,0);
        this.textura = LoadTexture(caminho);
    }

    public void descarregar() {
        UnloadTexture(this.textura);
    }   

    public void atualizar() {

    }

    public void renderizar(double escala){
        DrawTextureEx(this.textura, this.pos, 0, (float) escala, WHITE);
    }


    public void mover(double x, double y) {
        pos.x((float) x);
        pos.y((float) y);
    }

    public boolean testaColisao(ElementoGrafico e) {
        if((pos.x() < e.getPosX()) && (pos.y() < e.getPosY())) {
            if(col.x() > e.getPosX() && col.y() > e.getPosY()) {
                return true;
            }
        }

        return false;
    }

    public double getPosX() {
        return pos.x();
    }

    public double getPosY() {
        return pos.y();
    }
}
