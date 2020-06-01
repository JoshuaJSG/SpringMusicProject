package com.JSG.JSGApplication.DAO;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


public class SongClass {

    List<String> songs = new ArrayList<>();

    public List<String> displaySongs(){
      addSongs();
      return songs;
    }



    private void addSongs(){
        songs.add("hello");
        songs.add("there");
    }
}
