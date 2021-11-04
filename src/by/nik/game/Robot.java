package by.nik.game;

import java.util.Random;

public class Robot implements Players{
    private boolean isSymbolX = false;

    @Override
    public void doStep(PlayField playField){
        int row = 0 , col = 0;
        Random random = new Random();
        do {
            row = 1 + random.nextInt(3);
            col = 1 + random.nextInt(3);
        } while  (playField.commitStep(row, col, isSymbolX));

        System.out.println("ROBOT 'O' -> row = "+ row + ", col = " + col);
        playField.show();
    }
}
