package com.isep.tictactoe.console;

import java.io.InputStream;
import java.util.Scanner;

public class InputParser {
    Scanner sc;

    public InputParser(InputStream is) {
        this.sc = new Scanner(is);
    }

    public int getInt(){
        while(!sc.hasNextInt()){
            sc.nextLine();  // flushes line
        }
        return sc.nextInt();
    }

    public int getIntInRange(int low, int high){
        int val = getInt();
        while(val < low || val > high){
            val = getInt();
        }
        return val;
    }

    public void closeScanner(){
        sc.close();
    }
}
