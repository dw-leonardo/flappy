package com.ufrgs.graficos;

import static com.raylib.Jaylib.WHITE;
import static com.raylib.Raylib.DrawTextureEx;
import static com.raylib.Raylib.IsKeyPressed;
import static com.raylib.Raylib.KEY_SPACE;

import com.raylib.Jaylib.Vector2;
import com.ufrgs.jogo.PerdeuException;

public class Passarinho extends ElementoGrafico{

    private double vVertical;
    private double angulo;
    
    public Passarinho(String caminho, double escala, double xInicial, double yInicial, double largura, double altura) {
        super(caminho, escala, xInicial, yInicial, largura, altura);
        vVertical = 0;
        angulo = 0;
    }

    public void atualizar() throws PerdeuException{
        //esse bloco controla a gravidade

        if((pos.y() <= 0) || ((pos.y() + altura) >= 720)) throw new PerdeuException();

        vVertical = vVertical + 0.1;
        mover(getPosX(), getPosY() + vVertical);
        angulo = angulo + 0.25;

        if(IsKeyPressed(KEY_SPACE)) {
            mover(getPosX(), getPosY() - 10);
            vVertical = -3;
            angulo = -20;
        }
    }

    @Override
    public void renderizar() {

        DrawTextureEx(this.textura, new Vector2(pos.x()-10,pos.y()), (float) angulo, (float) escala, WHITE);

    }

    public boolean testaColisao(Cano c) throws PerdeuException{
        if((pos.x() < c.getPosX()) && (largura+pos.x() > c.getPosX())) {
            if((pos.y() < c.getPosY()+c.getAltura()) || (pos.y() > c.getPosY()+c.getAltura()+220)) {
                System.out.println("colidiu" + pos.y());
                throw new PerdeuException();
            }
        }
        if((pos.x() > c.getPosX()) && (pos.x() < (c.getPosX() + c.getLargura()))) {
            if((pos.y() < (c.getPosY()+c.getAltura())) || ((pos.y() + altura) > c.getPosY()+c.getAltura()+220)) {
                System.out.println("colidiu" + pos.y());
                throw new PerdeuException();
            }
        }
        
        return false;
    }
}
