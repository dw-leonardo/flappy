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
    private Cenario fundo1;
    private Cenario fundo2;
    private Cenario fundo3;

    private Cano tronco;

    private ArrayList<ElementoGrafico> graficos;

    public Flappy() {
        graficos = new ArrayList<ElementoGrafico>();
    }

	private void rodar() {
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
        
        for(ElementoGrafico i : graficos){
            i.atualizar();
        }

	}
	
	private void renderizar() {
		BeginDrawing();
            ClearBackground(BLUE);
            fundo1.renderizar();
            fundo2.renderizar();
            fundo3.renderizar();
            passarinho.renderizar();
            tronco.renderizar();
		EndDrawing();
	}

	public void inicializar() {
		janela = new Janela("Flappy Bird");
		SetTargetFPS(60);
        
        passarinho = new Passarinho("src/main/resources/passarinho.png", 0.2);
        graficos.add(passarinho);

        fundo1 = new Cenario("src/main/resources/fundo.png", 1.5, 0, 0, 1180, 800, 0.7);
        graficos.add(fundo1);

        fundo2 = new Cenario("src/main/resources/fundo.png", 1.5, 1180, 0, 1180, 800, 0.7);
        graficos.add(fundo2);

        fundo3 = new Cenario("src/main/resources/fundo.png", 1.5, 2360, 0, 1180, 800, 0.7);
        graficos.add(fundo3);

        tronco = new Cano(1);
        graficos.add(tronco);

		rodando = true;
        rodar();
	}

}