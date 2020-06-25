package com.JSG.JSGApplication.Controller;

import com.JSG.JSGApplication.Entity.Artist;
import com.JSG.JSGApplication.Service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/artists")
@CrossOrigin("*")
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


    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateArtist(@RequestBody Artist artist){
        this.artistService.updateArtist(artist);
    }


    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addNewArtist(@RequestBody Artist artist){
        this.artistService.addNewArtist(artist);
    }



}
