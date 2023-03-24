package com.isep.tictactoe.console;

import com.isep.tictactoe.core.Board;
import com.isep.tictactoe.core.Symbol;

public class Display {

    public Display() {
    }

    public void printText(String text) {
        System.out.println(text);
    }

    public void printTextWithColor(String text, Color color){
        System.out.println(color.color + text + Color.BACK.color);
    }

    public String textWithColor(String text, Color color){
        StringBuilder sb = new StringBuilder();
        sb.append(color.color).append(text).append(Color.BACK.color);
        return sb.toString();
    }

    public String wrapText(String text, String wrapper) {
        StringBuilder sb = new StringBuilder();
        sb.append(wrapper).append("\n");
        sb.append(text).append("\n");
        sb.append(wrapper).append("\n");
        return sb.toString();
    }
    public void printTextWithWrapper(String text, String wrapper){
        printText(wrapper);
        printText(text);
        printText(wrapper);
    }

    public static void main(String[] args) {
        Display display = new Display();
        display.printTextWithColor("Hello", Color.BLUE);
        display.printTextWithWrapper("Choose your players", "=".repeat(80));
    }

    public void printBoard(Board board){
        for (int i = 0; i < Board.BOARD_SIZE; i++) {
            for (int j = 0; j < Board.BOARD_SIZE; j++) {
                int squareColor = board.getSquare(i, j);
                if(squareColor == 0){
                    System.out.print("| ");
                } else {
                    System.out.printf("|%s", Symbol.getSymbol(squareColor).symbol);
                }
            }
            System.out.println("|");
        }
    }

}
