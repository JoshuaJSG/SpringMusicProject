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
                put(2, new Artist(2, "Jordan"));
                put(3, new Artist(3, "Smith"));
                put(4, new Artist(4, "Luisiana"));
            }
        };
    }



    public Collection<Artist> getAllArtists(){
        return artists.values();
    }

    public Artist getArtistByID(int id){
        return this.artists.get(id);
    }

    public void deleteArtistByID(int id){
        this.artists.remove(id);

    }


}
