package com.example.animelist.Class;

import javafx.collections.ObservableList;

public class Myanimelist {
    ObservableList<Anime> LaListeAnimes;

    public Myanimelist(ObservableList<Anime> laListeAnimes) {
        LaListeAnimes = laListeAnimes;
    }

    public Myanimelist(){

    }

    public ObservableList<Anime> getLaListeAnimes() {
        return LaListeAnimes;
    }

    public void setLaListeAnimes(ObservableList<Anime> laListeAnimes) {
        LaListeAnimes = laListeAnimes;
    }
}
