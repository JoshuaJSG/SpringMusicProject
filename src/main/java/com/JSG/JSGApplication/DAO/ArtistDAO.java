package com.JSG.JSGApplication.DAO;

import com.JSG.JSGApplication.Entity.Artist;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@Repository
public class ArtistDAO {

    //HARD CODED DATABASE
    private static Map<Integer, Artist> artists;

    static {

        artists = new HashMap<Integer, Artist>(){
            {
                put(1, new Artist(1, "Joshua"));
                put(1, new Artist(1, "Jordan"));
                put(1, new Artist(1, "Smith"));
                put(1, new Artist(1, "Luisiana"));
            }
        };
    }



    public Collection<Artist> getAllArtists(){
        return artists.values();
    }


}
