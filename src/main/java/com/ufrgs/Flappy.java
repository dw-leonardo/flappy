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
		EndDrawing();
	}

	public void inicializar() {
		janela = new Janela("Flappy Bird");
		SetTargetFPS(60);

        for(int i = 0; i < 3; i++) {
            ElementoGrafico fundo = new Cenario("src/main/resources/fundo.png", 1.5, 1180*i, 0, 1180, 800, 0.7);
            graficos.add(fundo);
        }

        passarinho = new Passarinho("src/main/resources/passarinho.png", 0.2, 200, 360, 112, 104); 
        graficos.add(passarinho);  

        for(int i = 0; i < 6; i++) {
            Cano cano =  new Cano(1, 1280 + i*400);
            graficos.add(cano);
            obstaculos.add(cano);
            cano.randomizarPos(); 
        } 

        while(!IsKeyPressed(KEY_SPACE)) renderizar();

		rodando = true;
        loop();
	}

}