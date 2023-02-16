package com.example.animelist.Controleur;

import com.example.animelist.Class.Anime;
import com.example.animelist.FxmlLoader;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainControlleur implements Initializable {

    public BorderPane borderPane;
    public Button ButtonCatalogue;

    public static MainControlleur instance;

    public MainControlleur(){
        instance = this;
    }

    public static MainControlleur getInstance(){
        return instance;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try{
            FxmlLoader object = new FxmlLoader();
            Pane view = object.getPage("Catalogue");
            borderPane.setCenter(view);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void SelectedCatalogue(){
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("Catalogue");
        System.out.println(borderPane);
        borderPane.setCenter(view);
    }
}
