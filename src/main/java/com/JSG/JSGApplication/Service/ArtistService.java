package com.JSG.JSGApplication.Service;

import com.JSG.JSGApplication.DAO.ArtistDAO;
import com.JSG.JSGApplication.Entity.Artist;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class ArtistService {

    //SERVICE THAT USES HARDCODED DATABASE
    private ArtistDAO artistDAO;

    public Collection<Artist> getAllArtists(){
        return artistDAO.getAllArtists();
    }
}
