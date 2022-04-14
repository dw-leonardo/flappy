package com.ufrgs;

import static com.raylib.Raylib.*;
import static com.raylib.Jaylib.*;

public class Passarinho extends ElementoGrafico{

    private double vVertical;
    private double angulo;
    
    public Passarinho(String caminho) {
        super(caminho);
        vVertical = 0;
        angulo = 0;
        mover(200, getPosY());
    }

    public void atualizar() {
        //esse bloco controla a gravidade
        vVertical = vVertical + 0.1;
        mover(getPosX(), getPosY() + vVertical);
        angulo = angulo + 0.2;

        if(IsKeyPressed(KEY_SPACE)) {
            mover(getPosX(), getPosY() - 10);
            vVertical = -5;
            angulo = -20;
        }
    }

    public void renderizar(double escala) {
        DrawTextureEx(this.textura, this.pos, (float) angulo, (float) escala, WHITE);
    }
}
