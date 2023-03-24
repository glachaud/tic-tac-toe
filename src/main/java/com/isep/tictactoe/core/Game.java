package com.isep.tictactoe.core;

import java.util.LinkedList;
import java.util.List;

public class Game {
    private final Board board;
    private final List<Player> players;
    private int currentPlayer;

    public Game() {
        this.board = new Board();
        this.players = new LinkedList<>();
        this.players.add(new Player(-1, Symbol.NAUGHT));
        this.players.add(new Player(1, Symbol.CROSS));
        this.currentPlayer = 0;
    }

    public boolean fillSquare(int row, int column){
        if (board.fillSquare(row, column, players.get(currentPlayer).color)){
            currentPlayer = (currentPlayer + 1) % 2;
            return true;
        }
        return false;
    }

    public Board getBoard() {
        return board;
    }

    public boolean isGameOver(){
        boolean gameFinished = false;
        for(int i = 0; i < Board.BOARD_SIZE; i++){
            if(board.checkRow(i) || board.checkColumn(i)){
                gameFinished = true;
            }
        }
        if (board.checkDiagonal() || board.checkAntiDiagonal()) {
            gameFinished = true;
        }
        return gameFinished;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }
}
