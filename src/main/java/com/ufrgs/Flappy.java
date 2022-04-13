package com.ufrgs;

import static com.raylib.Raylib.*;

import static com.raylib.Jaylib.*;

public class Flappy{

	private boolean rodando = false;
	//boolean que define se o jogo esta rodando

	private Janela janela;
    //janela na qual o jogo roda

    private Sprite passarinho;
    private Sprite fundo1;
    private Sprite fundo2;

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
        if(fundo1.getPosX() <= -1200){
            fundo1.mover(fundo2.getPosX()+1180,0);
        } else {
            fundo1.mover(fundo1.getPosX()-1, fundo1.getPosY());
        }

        if(fundo2.getPosX() <= -1200){
            fundo2.mover(fundo1.getPosX()+1180,0);
        } else {
            fundo2.mover(fundo2.getPosX()-1, fundo2.getPosY());
        }


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
        
        
        //ChangeDirectory("C:/Users/Leonardo/Documents/Code/flappy/src/main/java/com/ufrgs/resources");
        passarinho = new Sprite("src/main/resources/passarinho.png");
        fundo1 = new Sprite("src/main/resources/fundo.png");
        fundo2 = new Sprite("src/main/resources/fundo.png");
        
        fundo2.mover(1180, 0);
		rodando = true;
        rodar();
	}

}