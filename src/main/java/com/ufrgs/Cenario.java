package com.ufrgs;

import static com.raylib.Raylib.*;
import static com.raylib.Jaylib.*;

public class Cenario extends ElementoGrafico{

    private double vScroll;

    public Cenario(String caminho, double vScroll){
        super(caminho);
        this.vScroll = vScroll;
    }

    public void atualizar() {
        mover(getPosX() - 1, 0);
        if(pos.x() < -1200) {
            mover(1180, 0);
        }
    }

}
