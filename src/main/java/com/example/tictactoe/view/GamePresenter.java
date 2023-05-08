package com.example.tictactoe.view;

import com.example.tictactoe.HelloApplication;
import com.isep.tictactoe.core.Board;
import com.isep.tictactoe.core.Game;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

public class GamePresenter {

    HelloApplication application;
    GameView gameView;
    Game game;

    public GamePresenter(GameView gameView, Game game, HelloApplication application) {
        this.gameView = gameView;
        this.game = game;
        this.application = application;
        for (int i = 0; i < Board.BOARD_SIZE; i++) {
            for (int j = 0; j < Board.BOARD_SIZE; j++) {
                Pane pane = new Pane();
                pane.setOnMouseClicked(this::handleClick);
                gameView.add(pane, i, j);
            }
        }
    }

    public void handleClick(MouseEvent e) {
        System.out.println("I have been clicked!");
        System.out.printf("Coordinates of the click: %f x and %f y %n", e.getX(), e.getY());
        System.out.printf("I have been clicked by this pane: %s%n", e.getTarget());
        Pane pane = (Pane) e.getTarget();
        int row = GridPane.getRowIndex(pane);
        int col = GridPane.getColumnIndex(pane);
        if (game.isGameOver()) {
            System.out.println("The game is already finished!");
            return;
        }
        if (!game.fillSquare(row, col)) {
            System.out.println("Already taken. Move along");
            return;
        }
        Shape shape;
        if (game.getCurrentPlayer() % 2 == 0) {
            shape = new Circle(75, 75, 75);
            shape.setStroke(Color.ORANGERED);
            shape.setFill(null);
        } else {
            Line line1 = new Line(0, 0, 150, 150);
            Line line2 = new Line(150, 0, 0, 150);
            shape = Shape.union(line1, line2);
            shape.setStroke(Color.AQUA);
        }
        pane.getChildren().add(shape);
        game.getBoard().printBoard();

        if (game.isGameOver()) {
            Timeline timeline = new Timeline();
            timeline.getKeyFrames().add(new KeyFrame(Duration.millis(3000),
                    (f) -> {
                        int winner = ((game.getCurrentPlayer() + 1) % 2);
                        System.out.printf("Player %d has won!", winner);
                        application.declareWinner(winner);
                    }
            ));
            timeline.play();
        }
    }
}
