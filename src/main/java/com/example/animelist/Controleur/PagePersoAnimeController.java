package com.example.animelist.Controleur;

import com.example.animelist.Class.Anime;
import com.example.animelist.FxmlLoader;
import com.example.animelist.HelloApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class PagePersoAnimeController implements Initializable {
    public ImageView BannerImage;
    public ImageView ImageAnime;
    public Label TitreAnime;
    public Label Commentaire;
    public ChoiceBox comboBoxAvancement;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        FxmlLoader object = new FxmlLoader();
        AnimeControlleur AnimeController =  AnimeControlleur.getInstance();
        Anime monAnime = AnimeController.ThisAnime;

        Image imageAnime = new Image(HelloApplication.class.getResource("images/") + monAnime.getLinkImage());
        Image bannerImage = new Image(HelloApplication.class.getResource("images/") + monAnime.getLinkBanner());
        String titreanime = monAnime.getTitre();
        ImageAnime.setImage(imageAnime);
        BannerImage.setImage(bannerImage);
        TitreAnime.setText(titreanime);

        String monCommentaire = monAnime.getCommentaire().replace(',', '\n');
        ObservableList<String> lesAvancements = FXCollections.observableArrayList();
        lesAvancements.add("Completed");
        lesAvancements.add("En cours...");
        comboBoxAvancement.setItems(lesAvancements);

        if(comboBoxAvancement.getSelectionModel().isSelected(1)){
            comboBoxAvancement.setStyle("-fx-text-fill: green;");
        }

        Commentaire.setText(monCommentaire);

    }

}
