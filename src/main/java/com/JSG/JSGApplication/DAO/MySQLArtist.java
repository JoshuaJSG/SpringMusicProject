package com.JSG.JSGApplication.DAO;

import com.JSG.JSGApplication.Entity.Artist;
import com.JSG.JSGApplication.Interfaces.ArtistDAOInterface;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("sqlDB")
public class MySQLArtist implements ArtistDAOInterface {


    @Override
    public Collection<Artist> getAllArtists() {
        return new ArrayList<Artist>(){
            {
                add(new Artist(1,"New Testing name"));
            }
        };
    }

    @Override
    public Artist getArtistByID(int id) {
        return null;
    }

    @Override
    public void deleteArtistByID(int id) {

    }

    @Override
    public void updateArtist(Artist artist) {

    }

    @Override
    public void addNewArtist(Artist artist) {

    }
}
