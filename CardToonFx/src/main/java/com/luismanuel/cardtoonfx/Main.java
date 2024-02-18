package com.luismanuel.cardtoonfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try {
            //Establecemos la escena principal
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("baseCardtoon.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1000, 700);

            //Establecemos el titulo de la escena
            stage.setTitle("CardtoonFX");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}