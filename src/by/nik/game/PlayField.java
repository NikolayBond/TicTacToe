package by.nik.game;

public class PlayField {

    private final char SYMBOL_X = 'x';
    private final char SYMBOL_O = 'o';
    private final char SYMBOL_FREE = '.';
    private final char [][] playField;

    public PlayField() {
        playField = new char[3][3];
    }


    public boolean isRowOutOfRange(int row) {
        if (row >= 1 && row <= 3){
            return false;
        } else {
            show();
            System.out.println("Invalid value ROW. Try again.");
            return true;
        }
    }


    public boolean isColOutOfRange(int col) {
        if (col >= 1 && col <= 3){
            return false;
        } else {
            show();
            System.out.println("Invalid value COL. Try again.");
            return true;
        }
    }


    public boolean isStepValid(int row, int col) {
        return playField[row - 1][col - 1] == SYMBOL_FREE;
    }


    public boolean commitStep(int row, int col, boolean isSymbolX) {
        if (isStepValid(row, col)){
            playField[row-1][col-1] = isSymbolX ? SYMBOL_X : SYMBOL_O;
            return false;
        } else {
            show();
            System.out.println("This cell is already marked. Try again.");
            return true;
        }
    }

    public void init(){
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                playField[row][col] = SYMBOL_FREE;
            }
        }
    }

    public void show(){
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(playField[row][col] + " ");
            }
            System.out.println();
        }
    }

    boolean isFull() {
        for (int row = 0; row < 3; row++){
            for (int col = 0; col < 3; col++){
                if (playField[row][col] == SYMBOL_FREE){
                    return false;
                }
            }
        }
        System.out.println("A DRAW");
        return true;
    }

    boolean isWin(boolean isSymbolX) {
        char SYMBOL =  isSymbolX ? SYMBOL_X : SYMBOL_O;
        if (
            (playField[0][0] == SYMBOL && playField[1][1] == SYMBOL && playField[2][2] == SYMBOL) ||
            (playField[2][0] == SYMBOL && playField[1][1] == SYMBOL && playField[0][2] == SYMBOL)
        ){
            System.out.println("Player '" + SYMBOL +"'  WIN !");
            return true;
        }
        for (int i = 0; i < 3; i++)
            if (
                    (playField[i][0] == SYMBOL && playField[i][1] == SYMBOL && playField[i][2] == SYMBOL) ||
                            (playField[0][i] == SYMBOL && playField[1][i] == SYMBOL && playField[2][i] == SYMBOL)
            ){
                System.out.println("Player '" + SYMBOL +"'  WIN !");
                return true;
            }
        return false;
    }
}
