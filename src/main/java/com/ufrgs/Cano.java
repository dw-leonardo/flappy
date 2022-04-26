package com.ufrgs;

import java.util.Random;

public class Cano extends Cenario{
    
    private Cenario superior;
    private Cenario inferior;

    public Cano(String caminho, double escala, double xInicial, double yInicial, double largura, double altura, double vScroll) {

        super(caminho, escala, xInicial, yInicial, largura, altura, vScroll);

        superior = new Cenario(caminho, escala, xInicial, yInicial, largura, altura, vScroll);

        inferior = new Cenario(caminho, escala, xInicial, yInicial + 500, largura, altura, vScroll);

    }

    public void atualizar(){

        //superior.mover(superior.getPosX() - 1.3, superior.getPosY());
        //inferior.mover(inferior.getPosX() - 1.3, inferior.getPosY());

        super.atualizar();

        superior.atualizar();
        inferior.atualizar(); 

        if(superior.pos.x() <= -107) {
            randomizarPos();     
        }

    }

    public void randomizarPos() { 

        Random r = new Random();
        superior.mover(superior.getPosX(), r.nextInt(500)-250);
        inferior.mover(inferior.getPosX(), superior.getPosY()+470);  

    }

    /*
    public void mover(double x, double y) {

        pos.x((float) x);
        pos.y((float) y);

        superior.pos.x((float) x);
        superior.pos.y((float) y);

        inferior.pos.x((float) x);
        inferior.pos.y((float) y + 470);
        
    }
    */

    @Override
    public void renderizar() {

        superior.renderizar();
        inferior.renderizar();

    }

    public void descarregar() {

        super.descarregar();
        superior.descarregar();
        inferior.descarregar();
        
    }

}
