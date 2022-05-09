package com.ufrgs;

import java.util.Comparator;

public class OrdenadorScores implements Comparator<Score> {
    public int compare(Score score1, Score score2) {
        //ordem inversa
        return Integer.compare(score2.getPontos(), score1.getPontos());
    }
}
