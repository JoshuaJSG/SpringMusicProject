package com.JSG.JSGApplication.DAO;

import com.JSG.JSGApplication.Entity.Artist;
import com.JSG.JSGApplication.Interfaces.ArtistDAOInterface;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@Repository
@Qualifier("tempData")
public class ArtistDAO implements ArtistDAOInterface {

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



    @Override
    public Collection<Artist> getAllArtists(){
        return artists.values();
    }

    @Override
    public Artist getArtistByID(int id){
        return this.artists.get(id);
    }

    @Override
    public void deleteArtistByID(int id){
        this.artists.remove(id);
    }

    @Override
    public void updateArtist(Artist artist){
        Artist newArtist = artists.get(artist.getID());
        newArtist.setName(artist.getName());
        artists.put(artist.getID(), newArtist);
    }


    @Override
    public void addNewArtist(Artist artist){
        this.artists.put(artist.getID(), artist);
    }

}
