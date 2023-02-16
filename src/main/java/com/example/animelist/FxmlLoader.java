package com.example.animelist;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.net.URL;

public class FxmlLoader {
    private Pane view;

    public Pane getPage(String fileName){
        try {
            URL fileUrl = HelloApplication.class.getResource(fileName + ".fxml");
            if(fileUrl == null){
                throw new java.io.FileNotFoundException("FXML file not found");
            }

            view = new FXMLLoader().load(fileUrl);
        }
        catch (Exception e){
            System.out.println("No page " + fileName + " please Check FxmlLoader.");
        }
        return view;
    }
}
