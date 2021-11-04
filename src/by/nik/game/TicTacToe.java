package by.nik.game;

public class TicTacToe {

    Players player2;

    private void startGame(){
        Players player1 = new Human(true);
        if (ChooseGameType.isRobot()){
            this.player2 = new Robot();
        } else {
            this.player2 = new Human(false);
        }

        PlayField playField = new PlayField();
        playField.init();
        playField.show();

        do {
            player1.doStep(playField);
            if ( playField.isWin(true) || playField.isFull() ){
                break;
            };

            player2.doStep(playField);
            if ( playField.isWin(false) || playField.isFull() ){
                break;
            };

        } while (true);
        System.out.println("The game is over");
    }

    public static void main(String... args){
        new TicTacToe().startGame();
    }
}
