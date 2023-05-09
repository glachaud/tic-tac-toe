package com.example.tictactoe;

import com.example.tictactoe.view.GamePresenter;
import com.example.tictactoe.view.GameView;
import com.isep.tictactoe.core.Game;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {

    Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        VBox root = new VBox();
        GameView gameView = new GameView();
        Game game = new Game();
        GamePresenter gamePresenter = new GamePresenter(gameView, game, this);
        System.out.println("A new game has been started");
        root.getChildren().add(gameView);
        Scene scene = new Scene(root, 600, 600);
        this.stage.setTitle("Hello!");
        this.stage.setScene(scene);
        this.stage.show();
    }

    public void declareWinner(int player) {
        VBox root = new VBox();
        Label label = new Label(String.format("Player %d has won the game! Congratulations!", player));
        label.getStyleClass().add("label");
        root.getStyleClass().add("vbox");
        root.getStylesheets().add(
            Objects.requireNonNull(
                getClass().getResource("style.css"))
                .toExternalForm()
        );
        root.getChildren().add(label);
        Scene scene = new Scene(root, 600, 600);
        this.stage.setTitle("End!");
        this.stage.setScene(scene);
        this.stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}