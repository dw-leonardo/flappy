package com.ufrgs.serializacao;

import java.io.*;
import java.util.ArrayList;

public class ManipuladorSerializaveis {
    public static void serializa(String nomeArquivo, Object objeto) {
        try {
            FileOutputStream fos = new FileOutputStream(new File(nomeArquivo));
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(objeto);
            oos.close();
            fos.close();
        } catch (IOException e) {
            System.out.println("Erro ao abrir arquivo"+ e.getMessage());
        } 
        
    }

    public static Object desserializa(String nomeArquivo) {
        try {
            FileInputStream fis = new FileInputStream(new File(nomeArquivo));
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();
            ois.close();
            fis.close();

            return obj;
        } catch (IOException e) {
            System.out.println("Erro ao abrir arquivo");
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e){
            System.out.println("Classe não encontrada");
        }
        
        return new ArrayList<Score>();
    }
}
