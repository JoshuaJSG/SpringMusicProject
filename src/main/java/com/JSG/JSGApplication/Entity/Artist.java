package com.JSG.JSGApplication.Entity;

public class Artist {

    private int ID;
    private String name;


    public Artist(int ID, String name) {
        this.ID = ID;
        this.name = name;
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
}
