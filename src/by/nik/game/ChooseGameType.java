package by.nik.game;

import java.util.Scanner;

public class ChooseGameType {
    public static boolean isRobot(){
        String choose;
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Enter '1' to play with robot, '2' to play together with another player:");

            choose = scanner.nextLine();

            if (choose.equals("1")){
                return true;
            }
            if (choose.equals("2")){
                return false;
            }
            System.out.print("Invalid value. Try again. ");
        }
    }
}
