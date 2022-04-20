package com.ufrgs;

import static com.raylib.Raylib.*;
import static com.raylib.Jaylib.*;

public class Cenario extends ElementoGrafico{

    private double vScroll;

    public Cenario(String caminho, double escala, double vScroll){
        super(caminho, escala);
        this.vScroll = vScroll;
    }

    public void atualizar() {
        mover(getPosX() - vScroll, getPosY());
        if(pos.x() <= -1180) {
            mover(2360, getPosY());
        }
    }

}
