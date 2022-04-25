package com.ufrgs;

import java.util.Random;

public class Cano extends ElementoGrafico{
    
    private Cenario superior;
    private Cenario inferior;

    public Cano(int semente, double xInicial) {

        super();

        superior = new Cenario("src/main/resources/tronco.png", 0.3, xInicial, 0, 107, 289, 1.3);

        inferior = new Cenario("src/main/resources/tronco.png", 0.3, xInicial, 470, 107, 289, 1.3);

    }

    public void atualizar(){

        superior.mover(superior.getPosX() - 1.3, superior.getPosY());
        inferior.mover(inferior.getPosX() - 1.3, inferior.getPosY());
        if(superior.pos.x() <= -107) {
            Random r = new Random();
            superior.mover(2360, r.nextInt(500)-250);
            inferior.mover(2370, superior.getPosY()+470);     
        }

        //superior.atualizar();
        //inferior.atualizar();   

    }

    public void mover(double x, double y) {

        pos.x((float) x);
        pos.y((float) y);

        superior.pos.x((float) x);
        superior.pos.y((float) y);

        inferior.pos.x((float) x);
        inferior.pos.y((float) y + 470);
        
    }

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
