package com.isep.tictactoe.core;

public class Board {
    private final int[][] board;
    public static final int BOARD_SIZE = 3;

    public Board() {
        this.board = new int[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                this.board[i][j] = 0;
            }
        }
    }

    public boolean fillSquare(int row, int column, int color) {
        if (board[row][column] != 0) {
            return false;
        } else {
            board[row][column] = color;
            return true;
        }
    }

    public boolean checkRow(int row) {
        int count, color;
        if (board[row][0] != 0) {
            color = board[row][0];
            count = 1;
        } else {
            return false;
        }
        for (int i = 1; i < BOARD_SIZE; i++) {
            if (board[row][i] == color) {
                count++;
            }
        }
        return count == BOARD_SIZE;
    }

    public boolean checkColumn(int column) {
        int count, color;
        if (board[0][column] != 0) {
            color = board[0][column];
            count = 1;
        } else {
            return false;
        }
        for (int i = 1; i < BOARD_SIZE; i++) {
            if (board[i][column] == color) {
                count++;
            }
        }
        return count == BOARD_SIZE;
    }

    public boolean checkDiagonal() {
        int count, color;
        if (board[0][0] != 0) {
            color = board[0][0];
            count = 1;
        } else {
            return false;
        }
        for (int i = 1; i < BOARD_SIZE; i++) {
            if (board[i][i] == color) {
                count++;
            }
        }
        return count == BOARD_SIZE;
    }

    public boolean checkAntiDiagonal() {
        int count, color;
        if (board[BOARD_SIZE - 1][0] != 0) {
            color = board[BOARD_SIZE - 1][0];
            count = 1;
        } else {
            return false;
        }
        for (int i = 1; i < BOARD_SIZE; i++) {
            if (board[BOARD_SIZE - i][i] == color) {
                count++;
            }
        }
        return count == BOARD_SIZE;
    }

    public int getSquare(int row, int column) {
        return board[row][column];
    }

    public void printBoard(){
        for (int i = 0; i < Board.BOARD_SIZE; i++) {
            for (int j = 0; j < Board.BOARD_SIZE; j++) {
                int squareColor = this.getSquare(i, j);
                if(squareColor == 0){
                    System.out.print("| ");
                } else {
                    System.out.printf("|%s", Symbol.getSymbol(squareColor).symbol);
                }
            }
            System.out.println("|");
        }
    }

    public static void main(String[] args) {
        Board board = new Board();
        board.fillSquare(0, 0, 1);
        board.fillSquare(0, 1, 1);
        board.fillSquare(0, 2, 1);
        System.out.printf("Is there a win? %b.%n", board.checkRow(0));
    }
}
