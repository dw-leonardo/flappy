package com.ufrgs;

import static com.raylib.Jaylib.*;

public class Janela {
    
    private static final int largura = 1280;
    private static final int altura = 720;

    public Janela(String nome) {
        InitWindow(largura, altura, nome);
        //cria a janela
        //SetWindowPosition((GetScreenWidth() - largura) / 2, (GetScreenHeight() - altura) / 2);
    }

    public boolean deveFechar() {
        if(WindowShouldClose()){
            CloseWindow();
            return true;
        } else {
            return false;
        }
    }

    public void fechar() {
        CloseWindow();
    }

    public int getLargura() {
        return largura;
    }

    public int getAltura() {
        return altura;
    }
}
