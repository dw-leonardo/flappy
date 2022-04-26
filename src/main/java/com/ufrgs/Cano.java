package com.ufrgs;

import java.util.Random;

public class Cano extends ElementoGrafico{
    
    private Cenario superior;
    private Cenario inferior;

    public Cano(int semente, double xInicial) {

        super();

        superior = new Cenario("src/main/resources/tronco.png", 0.3, xInicial, 0, 107, 289, 1.3);

        inferior = new Cenario("src/main/resources/tronco.png", 0.3 , xInicial, 500, 107, 289, 1.3);

    }

    public void atualizar(){

        //superior.mover(superior.getPosX() - 1.3, superior.getPosY());
        //inferior.mover(inferior.getPosX() - 1.3, inferior.getPosY());

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

    public void mover(double x, double y) {

        pos.x((float) x);
        pos.y((float) y);

        superior.pos.x((float) x);
        superior.pos.y((float) y);

        inferior.pos.x((float) x);
        inferior.pos.y((float) y + 470);
        
    }

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
