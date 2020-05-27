package com.JSG.JSGApplication.Interfaces;

import com.JSG.JSGApplication.Entity.Artist;

import java.util.Collection;

public interface ArtistDAOInterface {
    Collection<Artist> getAllArtists();

    Artist getArtistByID(int id);

    void deleteArtistByID(int id);

    void updateArtist(Artist artist);

    void addNewArtist(Artist artist);
}
