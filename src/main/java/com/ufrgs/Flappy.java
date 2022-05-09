package com.ufrgs;

import java.util.ArrayList;

import static com.raylib.Raylib.*;
import static com.raylib.Jaylib.*;

public class Flappy{

	private boolean rodando = false;
	//boolean que define se o jogo esta rodando

	private Janela janela;
    //janela na qual o jogo roda

    private Passarinho passarinho;

    private ArrayList<ElementoGrafico> graficos;
    private ArrayList<Cano> obstaculos;

    private int pontos;

    public Flappy() {
        graficos = new ArrayList<ElementoGrafico>();
        obstaculos = new ArrayList<Cano>();
    }

	private void loop() {
		while(rodando) {
			//loop principal do jogo

			atualizar();
			renderizar();
            
			if(janela.deveFechar() == true) {
				rodando = false;
			}

		}

        fechar();
	}

    private void fechar() {

        for(ElementoGrafico i : graficos){
            i.descarregar();
        }

    }

	private void atualizar() {

        try {
            for(ElementoGrafico i : graficos){
            i.atualizar();
            }
            for(Cano i : obstaculos) {
                passarinho.testaColisao(i);
                if((i.getPosX()+i.getLargura()<passarinho.getPosX()) && i.isPontuavel()) {
                    pontos++;
                    i.pontuar();
                }
            }
        } catch (PerdeuException e) {
            System.out.println("Você Perdeu!");
            rodando = false;
        }
        

	}
	
	private void renderizar() {
		BeginDrawing();
            ClearBackground(BLUE);
            for(ElementoGrafico i : graficos){
                i.renderizar();
                }
            if(!rodando) {
                DrawText("Pressione 'ESPACO' para jogar", 380, janela.getAltura()/2, 30, BLACK);
            }
            //debug
            for(ElementoGrafico c : graficos) {
                DrawRectangleLines((int)c.getPosX(), (int)c.getPosY(), (int)c.getLargura(), (int)c.getAltura(), BLUE);
            }
            for(ElementoGrafico c : obstaculos) {
                DrawRectangleLines((int)c.getPosX(), (int)(c.getPosY()+c.getAltura()+220), (int)c.getLargura(), (int)c.getAltura(), BLUE);
            }
            DrawText(String.format("%d",pontos) , janela.getLargura()/2-50, 50, 50, BLACK);
		EndDrawing();
	}

	public Score inicializar() {
		janela = new Janela("Flappy Bird");
		SetTargetFPS(120);

        for(int i = 0; i < 3; i++) {
            ElementoGrafico fundo = new Cenario("src/main/resources/fundo.png", 1.5, 1180*i, 0, 1180, 800, 0.7);
            graficos.add(fundo);
        }

        passarinho = new Passarinho("src/main/resources/passarinho.png", 0.2, 200, 360, 80, 85); 
        graficos.add(passarinho);  

        for(int i = 0; i < 6; i++) {
            Cano cano =  new Cano("src/main/resources/tronco.png", 0.3, (i*400) + 1280, -500, 90, 580, 1.3);
            graficos.add(cano);
            obstaculos.add(cano);
            cano.randomizarPos(); 
        }
        renderizar();

        Menu menu = new Menu();
        menu.abrir();

        while(!IsKeyPressed(KEY_SPACE)) renderizar();

		rodando = true;
        loop();

        return new Score("zuqui", pontos);
	}

}