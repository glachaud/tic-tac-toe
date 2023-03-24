package com.isep.tictactoe.console;

import com.isep.tictactoe.core.Board;
import com.isep.tictactoe.core.Game;

public class Main {
    Game game;
    Display display;
    InputParser inputParser;

    public Main() {
        this.game = new Game();
        this.display = new Display();
        this.inputParser = new InputParser(System.in);
    }

    public int play() {
        while (!game.isGameOver()) {
            display.printText(display.textWithColor("Here is the current grid", Color.BLUE));
            display.printBoard(game.getBoard());
            display.printText(display.wrapText(
                    display.textWithColor(
                            String.format("It is player %d's turn. Which square do you want to fill?",
                                    game.getCurrentPlayer()), Color.RED
                    ), "=".repeat(80)
            ));
            int row = inputParser.getIntInRange(0, Board.BOARD_SIZE);
            int column = inputParser.getIntInRange(0, Board.BOARD_SIZE);
            while (!game.fillSquare(row, column)) {
                display.printText("The square is already taken. Choose another one!");
                row = inputParser.getIntInRange(0, Board.BOARD_SIZE);
                column = inputParser.getIntInRange(0, Board.BOARD_SIZE);
            }
        }
        int winner = ((game.getCurrentPlayer() + 1) % 2);
        display.printText(String.format("Player %d won the game!", winner));
        return winner;
    }

    public static void main(String[] args) {
        Main main = new Main();
        int winner = main.play();
    }
}
