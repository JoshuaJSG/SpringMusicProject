package com.JSG.JSGApplication.DAO;


import com.JSG.JSGApplication.Entity.Artist;
import com.JSG.JSGApplication.Interfaces.ArtistDAOInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;


@Repository("mysql")
public class MySQLConnection implements ArtistDAOInterface {
//RowMapper to loop and retrieve specified results in artists.

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static class ArtistRollMapper implements RowMapper<Artist>{

        @Override
        public Artist mapRow(ResultSet resultSet, int i) throws SQLException {
            Artist artist = new Artist();
            artist.setID(resultSet.getInt("id"));
            artist.setName(resultSet.getString("name"));
            return artist;
        }
    }

    @Override
    public Collection<Artist> getAllArtists() {
        final String sqlQuery = "SELECT id, name FROM artists";
        List<Artist> artists = jdbcTemplate.query(sqlQuery, new ArtistRollMapper());
        return artists;
    }

    @Override
    public Artist getArtistByID(int id) {
        final String sqlQuery = "SELECT id, name FROM artists WHERE id = ?";
        //queryForObject as we want one field back.
        Artist artist = jdbcTemplate.queryForObject(sqlQuery, new ArtistRollMapper(), id);
        return artist;
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