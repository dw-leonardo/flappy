package com.ufrgs;

import static com.raylib.Jaylib.*;

import java.util.ArrayList;

public class Menu {

    private final Color FUNDO = new Color(252, 41, 35, 255);
    private final Color TEXTO = new Color(20, 74, 250, 255);
    private final Color BOTAO = new Color(250, 196, 20, 255);
    private final Color BOTAO2 = new Color(240, 195, 50, 255);

    public Menu() {

    }

    public void abrir() {
        boolean escolhendo = true;
        while(escolhendo) {
            BeginDrawing();

                ClearBackground(RED);
                DrawText("Flappy Pecker", 300, 100, 100, BLUE);

                DrawRectangle(400, 300, 400, 50, BOTAO);
                DrawText("Jogar", 550, 310, 35, BLUE);

                DrawRectangle(400, 400, 400, 50, BOTAO);
                DrawText("Pontuacoes", 500, 410, 35, BLUE);

            EndDrawing();

            if(IsMouseButtonPressed(MOUSE_LEFT_BUTTON)) {
                if((400 < GetMouseX()) && (GetMouseX() < 800)) {
                    if((300 < GetMouseY()) && (GetMouseY() < 350)) {
                        escolhendo = false;
                        return;
                    }
                }
                if(400 < GetMouseX() && GetMouseX() < 800) {
                    if(400 < GetMouseY() && GetMouseY() < 450) {
                        pontuacoes();
                    }
                }
            }
        }
    }

    public void pontuacoes() {
        boolean escolhendo = true;
        ArrayList<Score> pontuacoes = (ArrayList<Score>)ManipuladorSerializaveis.desserializa("pontuacoes.poo");

        while(escolhendo) {
            BeginDrawing();
                ClearBackground(RED);
                DrawText("Ranking", 180, 40, 50, TEXTO);
                int i;
                for (i = 0; i < 5; i++) {
                    DrawRectangle(180, 120+(i*80), 900, 40, BOTAO); //darkgray é 80,80,80,255
                    DrawRectangle(180, 160+(i*80), 900, 40, BOTAO2);
                }

                for (i = 0; i < pontuacoes.size(); i++) {
                    DrawText(pontuacoes.get(i).getNome(), 200, 125 + 40*i , 30, TEXTO);
                    DrawText(String.format("%d", pontuacoes.get(i).getPontos()), 1000, 125+40*i, 30, TEXTO);
                }

                if(IsKeyPressed(KEY_ENTER))
                {
                    escolhendo = false;
                }
            EndDrawing();
        }
    }

}