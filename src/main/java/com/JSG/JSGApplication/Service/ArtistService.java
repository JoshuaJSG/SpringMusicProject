package com.JSG.JSGApplication.Service;

import com.JSG.JSGApplication.DAO.ArtistDAO;
import com.JSG.JSGApplication.Entity.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class ArtistService {

    //SERVICE THAT USES HARDCODED DATABASE
    @Autowired
    private ArtistDAO artistDAO;

    public Collection<Artist> getAllArtists(){
        return artistDAO.getAllArtists();
    }



    public Artist getArtistByID(int id){
        return this.artistDAO.getArtistByID(id);
    }

    public void deleteArtistByID(int id){
        this.artistDAO.deleteArtistByID(id);
    }
}
