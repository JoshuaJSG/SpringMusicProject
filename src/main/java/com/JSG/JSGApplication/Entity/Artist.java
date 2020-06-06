package com.JSG.JSGApplication.Entity;

import com.JSG.JSGApplication.Controller.FetchDataController;

import java.util.ArrayList;
import java.util.List;

public class Artist {

private FetchDataController fetchDataController;
    private int ID;
    private String name;
    private String songs;

    public Artist(int ID, String name, String songs) {
        this.ID = ID;
        this.name = name;
//        this.songs = new ArrayList<String>(songs);
        this.songs = songs;
    }


    public Artist(){

    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getSongs() {
        return songs;
    }

    public void setSongs(String songs) {
        this.songs = songs;
    }
}
