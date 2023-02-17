package com.example.animelist.Class;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class LecteurXML extends DefaultHandler {

    ObservableList<Anime> LaListe = FXCollections.observableArrayList();
    Myanimelist MaListe;
    Anime MonAnime;
    String baliseCourante;

    @Override
    public void startElement(String uri, String localname, String qname, Attributes atrbts) throws SAXException {
        if(qname.equals("myanimelist")) MaListe = new Myanimelist();
        if (qname.equals("anime")) {
            MonAnime = new Anime();
        }
        baliseCourante = qname;
    }

    @Override
    public void endElement(String string, String string1, String qname) throws SAXException {
        if (qname.equals("anime")) {
            LaListe.add(MonAnime);
        }
        //monChallenge.setLeChallenge(LesCourses);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String donnees = new String(ch, start, length);
        if (!Character.isISOControl(ch[start])) {
            if (baliseCourante.equals("series_title")) {
                MonAnime.setTitre(donnees);
            } else {
                if (baliseCourante.equals("series_episodes")) {
                    MonAnime.setNombreEpisodeSerie(Integer.parseInt(donnees));
                } else {
                    if (baliseCourante.equals("my_watched_episodes")) {
                        MonAnime.setNombreEpisodeVue(Integer.parseInt(donnees));
                    } else {
                        if (baliseCourante.equals("my_score")) {
                            MonAnime.setScore(Integer.parseInt(donnees));
                        } else {
                            if (baliseCourante.equals("my_status")) {
                                MonAnime.setStatus(donnees);
                            } else {
                                if (baliseCourante.equals("my_comments")) {
                                    MonAnime.setCommentaire(donnees);
                                } else {
                                    if (baliseCourante.equals("my_priority")) {
                                        MonAnime.setPropriete(donnees);
                                    } else {
                                        if (baliseCourante.equals("my_tags")) {
                                            MonAnime.setTags(donnees);
                                        } else {
                                            if (baliseCourante.equals("image")) {
                                                MonAnime.setLinkImage(donnees);
                                            } else {
                                                if (baliseCourante.equals("banner")) {
                                                    MonAnime.setLinkBanner(donnees);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public ObservableList<Anime> retouneLaListe(){
        return LaListe;
    }

}
