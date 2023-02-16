package com.example.animelist.Class;

import com.example.animelist.HelloApplication;
import java.net.URL;

public class Anime {
    String Titre, Status, Commentaire, Propriete, Tags;
    int NombreEpisodeSerie, NombreEpisodeVue, Score;
    String LinkImage, LinkBanner;

    public Anime(String titre, String status, String commentaire, String propriete, String tags, int nombreEpisodeSerie, int nombreEpisodeVue, int score, String LinkImage, String LinkBanner) {
        this.Titre = titre;
        this.Status = status;
        this.Commentaire = commentaire;
        this.Propriete = propriete;
        this.Tags = tags;
        this.NombreEpisodeSerie = nombreEpisodeSerie;
        this.NombreEpisodeVue = nombreEpisodeVue;
        this.Score = score;
        this.LinkImage = LinkImage;
        this.LinkBanner = LinkBanner;
    }

    public Anime(){

    }

    public String getTitre() {
        return Titre;
    }

    public String getStatus() {
        return Status;
    }

    public String getCommentaire() {
        return Commentaire;
    }

    public String getPropriete() {
        return Propriete;
    }

    public String getTags() {
        return Tags;
    }

    public int getNombreEpisodeSerie() {
        return NombreEpisodeSerie;
    }

    public int getNombreEpisodeVue() {
        return NombreEpisodeVue;
    }

    public int getScore() {
        return Score;
    }

    public void setTitre(String titre) {
        Titre = titre;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public void setCommentaire(String commentaire) {
        Commentaire = commentaire;
    }

    public void setPropriete(String propriete) {
        Propriete = propriete;
    }

    public void setTags(String tags) {
        Tags = tags;
    }

    public void setNombreEpisodeSerie(int nombreEpisodeSerie) {
        NombreEpisodeSerie = nombreEpisodeSerie;
    }

    public void setNombreEpisodeVue(int nombreEpisodeVue) {
        NombreEpisodeVue = nombreEpisodeVue;
    }

    public void setScore(int score) {
        Score = score;
    }

    public String getLinkImage() {
        return LinkImage;
    }

    public void setLinkImage(String linkImage) {
        LinkImage = linkImage;
    }

    public String toString(){
        return Titre;
    }

    public String getLinkBanner() {
        return LinkBanner;
    }

    public void setLinkBanner(String linkBanner) {
        LinkBanner = linkBanner;
    }
}
