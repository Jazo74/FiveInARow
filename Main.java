package com.zoli.gomoku;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
    Game game = initBoard();
    game.play();
    }

    public static Game initBoard(){
        Scanner scan = new Scanner(System.in);
        int x;
        int y;
        int winningCondition;

        while (true) {
            System.out.print("Board size (row): ");
            x = scan.nextInt();
            if (x < 5){
                System.out.println("too small");
            } else {
                break;
            }
        }
        while (true) {
            System.out.print("Board size (column): ");
            y = scan.nextInt();
            if (y < 1){
                System.out.println("too small");
            } else {
                break;
            }
        }
        while (true) {
            System.out.print("Winning condition: ");
            winningCondition = scan.nextInt();
            if (winningCondition < 3){
                System.out.println("too small");
            } else {
                break;
            }
        }
        return new Game(x, y, winningCondition);
    }
}
