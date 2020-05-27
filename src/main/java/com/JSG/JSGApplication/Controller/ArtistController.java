package com.JSG.JSGApplication.Controller;

import com.JSG.JSGApplication.Entity.Artist;
import com.JSG.JSGApplication.Service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/artists")
public class ArtistController {

    @Autowired
    private ArtistService artistService;


    @RequestMapping(method = RequestMethod.GET)
    public Collection<Artist> getAllArtists(){
        return artistService.getAllArtists();
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Artist getArtistByID(@PathVariable("id") int id){
        return this.artistService.getArtistByID(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Collection<Artist> deleteArtistByID(@PathVariable("id") int id){
        this.artistService.deleteArtistByID(id);
        return this.artistService.getAllArtists();
    }
}
