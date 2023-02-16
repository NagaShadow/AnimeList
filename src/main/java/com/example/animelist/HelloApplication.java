package com.example.animelist;

import com.example.animelist.Controleur.CatalogueControlleur;
import com.example.animelist.Controleur.MainControlleur;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MainPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1400, 800);
        URL image = HelloApplication.class.getResource("images/Logo.png");
        stage.getIcons().add(new Image(String.valueOf(image)));
        stage.initStyle(StageStyle.DECORATED);
        stage.setTitle("AnimeList");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}