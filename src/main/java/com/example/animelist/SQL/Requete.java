package com.example.animelist.SQL;

import com.example.animelist.Class.Anime;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Requete {
    //Requete permettant de retourner l'ensemble des clients
    public static ObservableList<Anime> getLesAnimes()
    {
        Connection conn;
        Statement stmt1;
        Anime monAnime;
        ObservableList<Anime> lesAnimes = FXCollections.observableArrayList();
        try
        {
            // On prévoit 2 connexions à la base
            stmt1 = GestionBdd.connexionBdd(GestionBdd.TYPE_MYSQL, "myanimelist","localhost", "root","");

            // Liste des clients qui "ont un plan de formation"
            String req = "select * from mylistmodif";
            ResultSet rs = GestionBdd.envoiRequeteLMD(stmt1,req);
            while (rs.next())
            {
                monAnime = new Anime(rs.getString("titre"), rs.getString("status"), rs.getString("commentaire"), rs.getString("propriete"), rs.getString("tags"), rs.getInt("nombreEpisodeSerie"), rs.getInt("nombreEpisodeVue"), rs.getInt("score"), rs.getString("LinkImage"), rs.getString("LinkBanner"));
                lesAnimes.add(monAnime);
            }
        }
        catch (SQLException se)
        {
            System.out.println("Erreur SQL requete getLesClients : " + se.getMessage());
        }
        return lesAnimes;
    }
}
