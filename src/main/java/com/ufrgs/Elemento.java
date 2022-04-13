package com.ufrgs;

import static com.raylib.Raylib.Texture;
import static com.raylib.Jaylib.*;

public class Elemento {

    private Vector2 pos;
    private Texture textura;

    public Elemento(String caminho) {
        this.pos = new Vector2(0,0);
        this.textura = LoadTexture(caminho);
    }

    public void descarregar() {
        UnloadTexture(this.textura);
    }   

    public void renderizar(double escala){
        DrawTextureEx(this.textura, this.pos, 0, (float) escala, WHITE);
    }

    public void mover(double x, double y) {
        pos.x((float)x);
        pos.y((float)y);
    }

    public double getPosX() {
        return pos.x();
    }

    public double getPosY() {
        return pos.y();
    }
}
