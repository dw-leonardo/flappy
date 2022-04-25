package com.ufrgs;

public class Cano extends ElementoGrafico{
    
    private Cenario superior;
    private Cenario inferior;

    public Cano(int semente) {
        super("src/main/resources/troncoinf.png", 1.5);
        superior = new Cenario("src/main/resources/tronco.png", 0.3, 1.5, 1280, 107, 289);
        inferior = new Cenario("src/main/resources/tronco.png", 0.3, 1.5, 1280, 107, 289);
        superior.mover(1280, 0);
        inferior.mover(1280, 470);
    }

    public void atualizar(){
        superior.atualizar();
        inferior.atualizar();
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
