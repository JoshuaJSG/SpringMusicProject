package com.JSG.JSGApplication.DAO;


import com.JSG.JSGApplication.Entity.Artist;
import com.JSG.JSGApplication.Interfaces.ArtistDAOInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository("mySQLConnection")
public class MySQLConnection implements ArtistDAOInterface {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    
    @Override
    public Collection<Artist> getAllArtists() {
        return null;
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
