package com.isep.tictactoe.core;

import java.util.InputMismatchException;

public enum Symbol {
    NAUGHT("o"),
    CROSS("x");

    public final String symbol;

    Symbol(String symbol) {
        this.symbol = symbol;
    }

    public static Symbol getSymbol(int color){
        switch(color){
            case -1:
                return Symbol.NAUGHT;
            case 1:
                return Symbol.CROSS;
        }
        throw new InputMismatchException();
    }
}
