package com.zoli.gomoku;
import java.util.Scanner;

public class Game {
    int[][] board;
    int howMany;
    String player1;
    String player2;
    Scanner scan = new Scanner(System.in);

    public Game(int x, int y, int winningCondition){
        board = new int[y][x];
        howMany = winningCondition;
        for (int[] row : board){
            for (int cell : row){
                cell = 0;
            }
        }
    }

    public void getPlayers(){
        while (true) {
            System.out.print("Name of the player 1: ");
            player1 = scan.nextLine();
            if (player1.length() == 0){
                System.out.println("too short name");
            } else {
                break;
            }
        }
        while (true) {
            System.out.print("Name of the player 2: ");
            player2 = scan.nextLine();
            if (player2.length() == 0){
                System.out.println("too short name");
            } else {
                break;
            }
        }
    }

    public int[] getMove(){
        int x;
        int y;
        while (true) {
            System.out.print("Row: ");
            x = scan.nextInt();
            if (x > board.length || x < 1){
                System.out.println("wrong parameter");
            } else {
                break;
            }
        }
        while (true) {
            System.out.print("Column: ");
            y = scan.nextInt();
            if (y > board[0].length || y < 1){
                System.out.println("wrong parameter");
            } else {
                break;
            }
        }
        return new int[]{x, y};
    }

    public boolean mark(int x, int y, int playerSign){
        if (board[y-1][x-1] == 0){
            board[y-1][x-1] = playerSign;
            return true;
        } else {
            return false;
        }
    }

    public boolean hasWon(int playerSign){
        for (int row = 0; row < board[0].length; row++){
            int count = 0;
            for (int column = 0; column < board.length; column++){
                if (board[column][row] == playerSign){
                    count ++;
                    if (count >= howMany){
                        return true;
                    }
                } else{
                    count = 0;
                }
            }
        }
        return false;
    }

    public boolean isFull(){
        for (int[] row : board){
            for (int cell : row){
                if (cell == 0){
                    return false;
                }
            }
        }
        return true;
    }

    public void printBoard(){
        String spacer = " ";
        //if (board.length > 9){
        //    spacer = " ";
        //}
        //System.out.println(board.length);
        //System.out.println(board[0].length);
        //int z = scan.nextInt();
        for (int y = 0; y < board[0].length; y++){
            System.out.print(y+1 + " ");
            for (int x = 0; x < board.length; x++){
                System.out.print(spacer + board[x][y]);
            }
            System.out.println("");
        }
    }

    public void printResult(String result, String name){
        if (result.equals("won")) {
            System.out.println(name + " won!");
        } else {
            System.out.println("It's a tie");
        }
    }

    public void play(){
        getPlayers();
        int round = 1;
        int[] moveCoords;
        while (!isFull() && !hasWon(1) && !hasWon(2)){
            printBoard();
            System.out.println(round + ". players move:" );
            while (true){
                moveCoords = getMove();
                if (mark(moveCoords[0], moveCoords[1], round)){
                    break;
                } else {
                    System.out.println("That place is occupied!");
                }
            }
            if (round == 1) {
                round = 2;
            } else {
                round = 1;
            }
        }
        if (hasWon(1)) {
            printResult("won", player1);
        } else if (hasWon(2)){
            printResult("won", player2);
        } else {
            printResult("tie", "nobody");
        }
    }
}
