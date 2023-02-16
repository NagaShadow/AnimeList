package com.example.animelist.Controleur;

import com.example.animelist.Class.Anime;
import com.example.animelist.FxmlLoader;
import com.example.animelist.HelloApplication;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AnimeControlleur implements Initializable {
    public VBox vboxContainer;
    public ImageView imageAnime;
    public Label titreAnime;
    public Anime ThisAnime;

    public static AnimeControlleur instance;

    public AnimeControlleur(){
        instance = this;
    }
    public static AnimeControlleur getInstance(){
        return instance;
    }

    public void setData(Anime anime){
        ThisAnime = anime;
        Image image = new Image(HelloApplication.class.getResource("images/") + anime.getLinkImage());
        System.out.println(image);
        imageAnime.setImage(image);
        titreAnime.setText(anime.getTitre());

        vboxContainer.setStyle("-fx-background-radius: 15;" +
                "-fx-border-radius: 15;");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        imageAnime.setFitWidth(180.00);
    }

    public void TestPagePersoAnime(){
        System.out.println("---------- Loading Personal Page ----------");
        FxmlLoader object = new FxmlLoader();
        MainControlleur monController =  MainControlleur.getInstance();
        monController.borderPane.setCenter(object.getPage("PagePersoAnime"));
        System.out.println("---------- Loading... ----------");
    }

    public Anime GetAnime(){
        return ThisAnime;
    }
}
