package by.nik.game;

import java.util.Scanner;

public class Human implements Players{
    private boolean isSymbolX;


    public Human(boolean isSymbolX) {
        this.isSymbolX = isSymbolX;
    }


    @Override
    public void doStep(PlayField playField) {

        int row = 0 , col = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            do {
                System.out.println("PLAYER " + (isSymbolX ? "'X'" : "'O'") + " -> Enter ROW (valid values are '1', '2', '3'):");
                try
                {
                    row = Integer.parseInt(scanner.nextLine().trim());
                }
                catch (NumberFormatException nfe)
                {
                    row = 0;
                }
            } while (playField.isRowOutOfRange(row));


            do {
                System.out.println("PLAYER " + (isSymbolX ? "'X'" : "'O'") + " -> Enter COL (valid values are '1', '2', '3'):");
                try
                {
                    col = Integer.parseInt(scanner.nextLine().trim());
                }
                catch (NumberFormatException nfe)
                {
                    col = 0;
                }
            } while (playField.isColOutOfRange(col));

        } while (playField.commitStep(row, col, isSymbolX));

        playField.show();
    }

}
