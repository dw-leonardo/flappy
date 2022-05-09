package com.ufrgs;

import java.util.Random;

public class Cano extends Cenario{
    
    private Cenario superior;
    private Cenario inferior;
    private boolean pontuavel; //define se pode fazer um ponto ao passar pelo cano

    public Cano(String caminho, double escala, double xInicial, double yInicial, double largura, double altura, double vScroll) {

        super(caminho, escala, xInicial, yInicial, largura, altura, vScroll);

        superior = new Cenario(caminho, escala, xInicial, yInicial, largura, altura, vScroll);

        inferior = new Cenario(caminho, escala, xInicial, yInicial + 1000, largura, altura, vScroll);

        pontuavel = true;
    }

    public void atualizar(){

        super.atualizar();

        superior.atualizar();
        inferior.atualizar(); 

        if(pos.x() > 1000) {
            //se o cano ainda tem que entrar na tela, ele deve ser pontuavel
            pontuavel = true;
        }
        if(superior.pos.x() <= -107) {
            randomizarPos();     
        }

    }

    public void randomizarPos() { 

        Random r = new Random();
        superior.mover(superior.getPosX(), r.nextInt(400) - 500);
        inferior.mover(inferior.getPosX(), superior.getPosY() + 800);  
        super.mover(superior.getPosX(), superior.getPosY());
    }

    @Override
    public void renderizar() {

        superior.renderizar();
        inferior.renderizar();

        //debug DrawText(String.format("%b", pontuavel), (int)inferior.getPosX(), (int)inferior.getPosY(), 20, BLACK);

    }

    public void descarregar() {

        super.descarregar();
        superior.descarregar();
        inferior.descarregar();
        
    }

    public double getAltura() {
        return superior.altura;
    }

    public double getLargura() {
        return superior.largura;
    }

    public boolean isPontuavel() {
        return pontuavel;
    }

    public void pontuar() {
        pontuavel = false;
    }

}
