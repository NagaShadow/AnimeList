package com.example.animelist.Controleur;

import com.example.animelist.Class.Anime;
import com.example.animelist.Class.LecteurXML;
import com.example.animelist.Class.XMLParser;
import com.example.animelist.HelloApplication;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.XMLReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class CatalogueControlleur implements Initializable {

    public GridPane AnimeContainer;
    public ScrollPane Scrollpane;
    public Button buttonOption;
    public TextField SearchBox;
    public Label labelSearch;

    ObservableList<Anime> MaListe;
    int column = 0;
    int row = 1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try{
            XMLParser monParse = new XMLParser();
            MaListe = monParse.start();
            for(Anime anime : MaListe){
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Anime.fxml"));
                VBox cardBox = fxmlLoader.load();
                AnimeControlleur animeControlleur = fxmlLoader.getController();
                animeControlleur.setData(anime);

                if(column == 6){
                    column = 0;
                    row++;
                }
                AnimeContainer.add(cardBox, column++, row);
                GridPane.setMargin(cardBox, new Insets(12));
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
