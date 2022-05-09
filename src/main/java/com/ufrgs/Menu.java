package com.ufrgs;

import static com.raylib.Jaylib.*;

import java.util.ArrayList;

public class Menu {

    private final Color COR_FUNDO = new Color(252, 41, 35, 255);
    private final Color COR_TEXTO = new Color(20, 74, 250, 255);
    private final Color COR_BOTAO = new Color(250, 196, 20, 255);
    private final Color COR_BOTAO2 = new Color(240, 195, 50, 255);

    private ArrayList<Score> pontuacoes;
    private Janela janela;

    public Menu() {

    }

    public void abrir() {
        boolean escolhendo = true;
        janela = new Janela("Flappy Pecker");
        SetTargetFPS(120);

        while(escolhendo) {
            
            BeginDrawing();

                ClearBackground(RED);
                DrawText("Flappy Pecker", 300, 100, 100, BLUE);

                DrawRectangle(400, 300, 400, 50, COR_BOTAO);
                DrawText("Jogar", 550, 310, 35, BLUE);

                DrawRectangle(400, 400, 400, 50, COR_BOTAO);
                DrawText("Pontuacoes", 500, 410, 35, BLUE);

                DrawRectangle(400, 500, 400, 50, COR_BOTAO);
                DrawText("Sair", 560, 510, 35, BLUE);

            EndDrawing();

            if(IsMouseButtonPressed(MOUSE_LEFT_BUTTON)) {
                if((400 < GetMouseX()) && (GetMouseX() < 800)) {
                    if((300 < GetMouseY()) && (GetMouseY() < 350)) {
                        jogar();
                        return;
                    }
                    if(400 < GetMouseY() && GetMouseY() < 450) {
                        pontuacoes();
                    }
                    if(500 < GetMouseY() && GetMouseY() < 550) {
                        janela.deveFechar();
                    }
                }
            }
        }
    }

    public void jogar() {
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
                if(GetCharPressed()!=0) {
                    nomejogador = nomejogador + (char)GetCharPressed();
                    System.out.println("hello");
                }
                if(IsKeyPressed(KEY_ENTER) && GetCharPressed() == 0)
                {
                    digitando = false;
                }

            EndDrawing();
        }



        pontuacoes = (ArrayList<Score>) ManipuladorSerializaveis.desserializa("src/main/pontuacoes/pontuacoes.poo");
        pontuacoes.add(new Score("zuqui", scorejogador));
        pontuacoes.sort(new OrdenadorScores());

        if(pontuacoes.size()>10) {
            pontuacoes.remove(10);
        }

        ManipuladorSerializaveis.serializa("src/main/pontuacoes/pontuacoes.poo", pontuacoes); 
    }

    public void pontuacoes() {
        boolean escolhendo = true;
        ArrayList<Score> pontuacoes = (ArrayList<Score>)ManipuladorSerializaveis.desserializa("src/main/pontuacoes/pontuacoes.poo");

        while(escolhendo) {
            BeginDrawing();
                ClearBackground(RED);
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

                if(IsKeyPressed(KEY_ENTER))
                {
                    escolhendo = false;
                }
            EndDrawing();
        }
    }

}