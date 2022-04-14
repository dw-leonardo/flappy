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
        passarinho.descarregar();
        fundo1.descarregar();
        fundo2.descarregar();

    }

	private void atualizar() {

        passarinho.atualizar();
        fundo1.atualizar();
        fundo2.atualizar();

	}
	
	private void renderizar() {
		BeginDrawing();
            ClearBackground(YELLOW);
            fundo1.renderizar(1.5);
            fundo2.renderizar(1.5);
            passarinho.renderizar(0.2);
		EndDrawing();
	}

	public void inicializar() {
		janela = new Janela("Flappy Bird");
		SetTargetFPS(60);
        
        passarinho = new Passarinho("src/main/resources/passarinho.png");
        graficos.add(passarinho);

        fundo1 = new Cenario("src/main/resources/fundo.png", 1);
        graficos.add(fundo1);

        fundo2 = new Cenario("src/main/resources/fundo.png", 1);
        graficos.add(fundo2);

        fundo2.mover(1180, 0);
		rodando = true;
        rodar();
	}

}