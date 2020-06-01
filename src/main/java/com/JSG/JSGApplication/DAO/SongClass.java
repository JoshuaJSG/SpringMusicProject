package com.JSG.JSGApplication.DAO;

import java.util.ArrayList;
import java.util.List;

public class SongClass {

    List<String> songs = new ArrayList<>();

    public List<String> add(String song){
        songs.add(song);
        return songs;
    }

}
