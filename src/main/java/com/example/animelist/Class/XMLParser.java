package com.example.animelist.Class;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XMLParser {
    private static final String FILENAME = "src/main/resources/com/example/animelist/test.xml";
    static ObservableList<Anime> LaListe = FXCollections.observableArrayList();

    public ObservableList<Anime> start(){
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {

            // optional, but recommended
            // process XML securely, avoid attacks like XML External Entities (XXE)
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

            // parse XML file
            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc = db.parse(new File(FILENAME));

            doc.getDocumentElement().normalize();

            System.out.println("Root Element :" + doc.getDocumentElement().getNodeName());
            System.out.println("------");

            NodeList list = doc.getElementsByTagName("anime");

            for (int temp = 0; temp < list.getLength(); temp++) {

                Anime MonAnime = new Anime();
                LaListe.add(MonAnime);

                Node node = list.item(temp);

                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Element element = (Element) node;

                    // get text
                    String series_title = element.getElementsByTagName("series_title").item(0).getTextContent();
                    String series_episodes = element.getElementsByTagName("series_episodes").item(0).getTextContent();
                    String my_watched_episodes = element.getElementsByTagName("my_watched_episodes").item(0).getTextContent();
                    String my_score = element.getElementsByTagName("my_score").item(0).getTextContent();
                    String my_status = element.getElementsByTagName("my_status").item(0).getTextContent();
                    String my_comments = element.getElementsByTagName("my_comments").item(0).getTextContent();
                    String my_priority = element.getElementsByTagName("my_priority").item(0).getTextContent();
                    String my_tags = element.getElementsByTagName("my_tags").item(0).getTextContent();
                    String image = element.getElementsByTagName("image").item(0).getTextContent();

                    System.out.println("Current Element :" + node.getNodeName());
                    System.out.println("Staff Id : " + series_title);

                    MonAnime.setTitre(series_title);
                    MonAnime.setNombreEpisodeSerie(Integer.parseInt(series_episodes));
                    MonAnime.setNombreEpisodeVue(Integer.parseInt(my_watched_episodes));
                    MonAnime.setScore(Integer.parseInt(my_score));
                    MonAnime.setStatus(my_status);
                    MonAnime.setCommentaire(my_comments);
                    MonAnime.setPropriete(my_priority);
                    MonAnime.setTags(my_tags);
                    MonAnime.setLinkImage(image);

                }
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return LaListe;
    }
}
