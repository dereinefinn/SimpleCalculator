package de.finn.simplecalculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("simplecalculator.fxml"));
        primaryStage.setTitle("Simple Calculator");
        primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("images/icon.png")));
        primaryStage.setScene(new Scene(root, 350, 535));
        primaryStage.show();
        primaryStage.setOnCloseRequest(event -> System.exit(0));

    }

    public static void main(String[] args) {
        launch(args);
    }

    public enum Operators {

        PLUS,
        MINUS,
        MULTIPLY,
        DIVIDE

    }
}
