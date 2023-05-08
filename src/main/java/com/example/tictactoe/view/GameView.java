package com.example.tictactoe.view;

import com.isep.tictactoe.core.Board;
import javafx.geometry.Insets;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;

public class GameView extends GridPane {
    static final int constraintWidth = 150;

    public GameView() {
        this.setPadding(new Insets(5, 0, 0, 5));
        this.setPrefWidth(constraintWidth * 3);
        this.setPrefHeight(constraintWidth * 3);
        for (int i = 0; i < Board.BOARD_SIZE; i++) {
            this.getColumnConstraints().add(new ColumnConstraints(constraintWidth));
            this.getRowConstraints().add(new RowConstraints(constraintWidth));
        }
        for (int i = 0; i < Board.BOARD_SIZE; i++) {
            for (int j = 0; j < Board.BOARD_SIZE; j++) {
                Pane pane = new Pane();
                this.add(pane, i, j);
            }
        }
        this.setMinHeight(this.getPrefHeight());
        this.setMinWidth(this.getPrefWidth());
        this.setGridLinesVisible(true);
    }
}
