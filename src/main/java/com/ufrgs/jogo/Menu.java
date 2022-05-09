package com.ufrgs.jogo;

import static com.raylib.Jaylib.*;

import java.util.ArrayList;

import com.ufrgs.serializacao.ManipuladorSerializaveis;
import com.ufrgs.serializacao.OrdenadorScores;
import com.ufrgs.serializacao.Score;


public class Menu {

    private final Color COR_FUNDO = new Color(136, 35, 31, 255);
    private final Color COR_TEXTO = new Color(19, 66, 150, 255);
    private final Color COR_BOTAO = new Color(210, 166, 47, 255);
    private final Color COR_BOTAO2 = new Color(255, 166, 80, 255);

    private ArrayList<Score> pontuacoes;
    private Janela janela;

    public void abrir() {
        janela = new Janela("Flappy Pecker");
        SetTargetFPS(120);

        boolean deveFechar = false;
        while(!deveFechar) {
            
            BeginDrawing();

                ClearBackground(COR_FUNDO);
                DrawText("Flappy Pecker", 300, 100, 100, COR_TEXTO);

                DrawRectangle(400, 300, 400, 50, COR_BOTAO);
                DrawText("Jogar", 550, 310, 35, COR_TEXTO);

                DrawRectangle(400, 400, 400, 50, COR_BOTAO);
                DrawText("Pontuacoes", 500, 410, 35, COR_TEXTO);

                DrawRectangle(400, 500, 400, 50, COR_BOTAO);
                DrawText("Sair", 560, 510, 35, COR_TEXTO);

            EndDrawing();

            if(IsMouseButtonPressed(MOUSE_LEFT_BUTTON)) {
                if((400 < GetMouseX()) && (GetMouseX() < 800)) {
                    if((300 < GetMouseY()) && (GetMouseY() < 350)) {
                        jogar();
                    }
                    if(400 < GetMouseY() && GetMouseY() < 450) {
                        pontuacoes();
                    }
                    if(500 < GetMouseY() && GetMouseY() < 550) {
                        deveFechar = true;
                        janela.fechar();
                    }
                }
            }
        }
    }

    private void jogar() {
        Flappy jogo = new Flappy();
        int scorejogador = jogo.inicializar();
        boolean digitando = true;
        String nomejogador = new String();
        while(digitando) {
            BeginDrawing();
                ClearBackground(RED);
                DrawText("Perdeu!", 500, 200, 50, COR_TEXTO);
                DrawText("Seu score: " + scorejogador, 450, 300, 50, COR_TEXTO);
                DrawText("Digite seu nome: " + nomejogador, 300, 400, 50, COR_TEXTO);
                char c = (char)GetCharPressed();
                if(c!=0) {
                    nomejogador = nomejogador + c;
                }
                if(IsKeyPressed(KEY_ENTER) && GetCharPressed() == 0)
                {
                    digitando = false;
                }

            EndDrawing();
        }

        //esse bloco le, adiciona, ordena e imprime
        pontuacoes = (ArrayList<Score>) ManipuladorSerializaveis.desserializa("src/main/pontuacoes/pontuacoes.poo");
        pontuacoes.add(new Score(nomejogador, scorejogador));
        pontuacoes.sort(new OrdenadorScores());

        if(pontuacoes.size()>10) {
            pontuacoes.remove(10);
        }

        ManipuladorSerializaveis.serializa("src/main/pontuacoes/pontuacoes.poo", pontuacoes); 
    }

    private void pontuacoes() {
        boolean devesair = false;
        ArrayList<Score> pontuacoes = (ArrayList<Score>)ManipuladorSerializaveis.desserializa("src/main/pontuacoes/pontuacoes.poo");

        while(!devesair) {
            BeginDrawing();
                ClearBackground(COR_FUNDO);
                DrawText("Ranking", 180, 40, 50, COR_TEXTO);
                int i;
                for (i = 0; i < 5; i++) {
                    DrawRectangle(180, 120+(i*80), 900, 40, COR_BOTAO); //darkgray é 80,80,80,255
                    DrawRectangle(180, 160+(i*80), 900, 40, COR_BOTAO2);
                }

                for (i = 0; i < pontuacoes.size(); i++) {
                    DrawText(pontuacoes.get(i).getNome(), 200, 125 + 40*i , 30, COR_TEXTO);
                    DrawText(String.format("%d", pontuacoes.get(i).getPontos()), 1000, 125+40*i, 30, COR_TEXTO);
                }
                
                DrawText("Pressione <-- para voltar", 180, 600, 25, COR_TEXTO);
                
                if(IsKeyPressed(KEY_BACKSPACE)) {
                    devesair = true;
                }
            EndDrawing();
        }
    }

}