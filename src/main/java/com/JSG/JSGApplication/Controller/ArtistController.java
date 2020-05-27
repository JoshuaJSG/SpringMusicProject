package com.JSG.JSGApplication.Controller;

import com.JSG.JSGApplication.Entity.Artist;
import com.JSG.JSGApplication.Service.ArtistService;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ArtistController {

    private ArtistService artistService;

    public Collection<Artist> getAllArtists(){
        return artistService.getAllArtists();
    }
}
