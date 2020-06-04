package com.JSG.JSGApplication.DAO;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


public class SongClass {

    private String songs;
    public String displaySongs(){
      addSongs();
      return songs;
    }



    private void addSongs(){
        songs+="hello"+"there";
    }
}
