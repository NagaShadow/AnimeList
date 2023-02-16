package com.example.animelist.Controleur;

import com.example.animelist.Class.Anime;
import com.example.animelist.Class.LecteurXML;
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
            Class c = Class.forName("org.apache.xerces.parsers.SAXParser");
            XMLReader parser = (XMLReader) c.newInstance();
            LecteurXML MonLecteur = new LecteurXML();
            parser.setContentHandler(MonLecteur);
            parser.parse("src/main/resources/com/example/animelist/listeanimes.xml");
            MaListe = MonLecteur.retouneLaListe();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        try{
            for(Anime anime : MaListe){
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Anime.fxml"));
                VBox cardBox = fxmlLoader.load();
                AnimeControlleur animeControlleur = fxmlLoader.getController();
                animeControlleur.setData(anime);

                if(column == 6){
                    column = 0;
                    row++;
                }

                // SERT A TRANSFORMER UN ANIME EN FICHIER .XML

//                try {
//
//                    DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
//
//                    DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
//
//                    Document document = documentBuilder.newDocument();
//                    Element root = document.createElement("anime");
//                    document.appendChild(root);
//
//                    Element series_title = document.createElement("series_title");
//                    series_title.appendChild(document.createTextNode(anime.getTitre()));
//                    root.appendChild(series_title);
//
//                    Element series_episodes = document.createElement("series_episodes");
//                    series_episodes.appendChild(document.createTextNode(String.valueOf(anime.getNombreEpisodeSerie())));
//                    root.appendChild(series_episodes);
//
//                    Element my_watched_episodes = document.createElement("my_watched_episodes");
//                    my_watched_episodes.appendChild(document.createTextNode(String.valueOf(anime.getNombreEpisodeVue())));
//                    root.appendChild(my_watched_episodes);
//
//                    Element my_score = document.createElement("my_score");
//                    my_score.appendChild(document.createTextNode(String.valueOf(anime.getScore())));
//                    root.appendChild(my_score);
//
//                    Element my_status = document.createElement("my_status");
//                    my_status.appendChild(document.createTextNode(anime.getStatus()));
//                    root.appendChild(my_status);
//
//                    Element my_comments = document.createElement("my_comments");
//                    my_comments.appendChild(document.createTextNode(anime.getCommentaire()));
//                    root.appendChild(my_comments);
//
//                    Element my_priority = document.createElement("my_priority");
//                    my_priority.appendChild(document.createTextNode(anime.getPropriete()));
//                    root.appendChild(my_priority);
//
//                    Element my_tags = document.createElement("my_tags");
//                    my_tags.appendChild(document.createTextNode(anime.getTags()));
//                    root.appendChild(my_tags);
//
//                    Element image = document.createElement("image");
//                    image.appendChild(document.createTextNode(anime.getLinkImage()));
//                    root.appendChild(image);
//
//                    Element banner = document.createElement("banner");
//                    banner.appendChild(document.createTextNode(anime.getLinkBanner()));
//                    root.appendChild(banner);
//
//                    // create the xml file
//                    //transform the DOM Object to an XML File
//                    TransformerFactory transformerFactory = TransformerFactory.newInstance();
//                    Transformer transformer = transformerFactory.newTransformer();
//                    DOMSource domSource = new DOMSource(document);
//
//                    String autre1 = anime.getTitre().replace('/', ' ');
//                    String Modif1 = autre1.replace(' ', '-');
//                    String autre2 = Modif1.replace(':', ' ');
//                    String NomFull = autre2.replace(' ', '-');
//                    StreamResult streamResult = new StreamResult(new File(xmlFilePath + "/" +  NomFull + ".xml"));
//
//                    transformer.transform(domSource, streamResult);
//
//                    System.out.println("Done creating XML File");
//
//                } catch (ParserConfigurationException pce) {
//                    pce.printStackTrace();
//                } catch (TransformerException tfe) {
//                    tfe.printStackTrace();
//                }

                AnimeContainer.add(cardBox, column++, row);
                GridPane.setMargin(cardBox, new Insets(12));
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
