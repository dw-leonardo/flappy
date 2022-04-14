package com.ufrgs;

import static com.raylib.Raylib.*;

public class Passarinho extends ElementoGrafico{

    public double vVertical;
    
    public Passarinho(String caminho) {
        super(caminho);
        vVertical = 0;
        mover(200, getPosY());
    }

    public void atualizar() {
        //esse bloco controla a gravidade
        vVertical = vVertical + 0.1;
        mover(getPosX(), getPosY() + vVertical);

        if(IsKeyPressed(KEY_SPACE)) {
            vVertical = -5;
        }
    }
}
