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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Repository("mysql")
public class MySQLConnection implements ArtistDAOInterface {
//RowMapper to loop and retrieve specified results in artists.

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private Artist artist;

    private static class ArtistRollMapper implements RowMapper<Artist>{

        @Override
        public Artist mapRow(ResultSet resultSet, int i) throws SQLException {
            List<String> results = new ArrayList<>();
            Artist artist = new Artist();
            artist.setID(resultSet.getInt("id"));
            artist.setName(resultSet.getString("name"));
            artist.setSongs(resultSet.getString("songs"));

            //trying to get the items in the array for each row and set to an artist for their songs.
            // See mySQL for table
//                while (resultSet.next()){
//                    int set = resultSet.getInt(i);
//                    results.add(resultSet.getString("songs"));
//                }
//            artist.setSongs(results);
            return artist;
        }
    }

    @Override
    public Collection<Artist> getAllArtists() {
        final String sqlQuery = "SELECT id, name, songs FROM artists";
        List<Artist> artists = jdbcTemplate.query(sqlQuery, new ArtistRollMapper());
        return artists;
    }

    @Override
    public Artist getArtistByID(int id) {
        final String sqlQuery = "SELECT id, name, songs FROM artists WHERE id = ?";
        //queryForObject as we want one field back.
        Artist artist = jdbcTemplate.queryForObject(sqlQuery, new ArtistRollMapper(), id);
        return artist;
    }

    @Override
    public void deleteArtistByID(int id) {
        final String sqlQuery = "DELETE FROM artists WHERE id = ?";
        jdbcTemplate.update(sqlQuery, id);
    }

    @Override
    public void updateArtist(Artist artist) {
        final String sqlQuery = "UPDATE artists SET name = ? WHERE id = ?";
        final String name = artist.getName();
        final int id = artist.getID();
        jdbcTemplate.update(sqlQuery, new Object[] {name, id});
    }

    @Override
    public void addNewArtist(Artist artist) {
        final String sqlQuery = "INSERT INTO artists (name, songs) VALUES (?,?)";
        final String name = artist.getName();
        final String songs = artist.getSongs();
        jdbcTemplate.update(sqlQuery, new Object[]{name, songs});
//        final List<String> songs = artist.getSongs();
//        final Object[] songFields = new Object[]{artist.getSongs()};
//        for (int i = 0; i <songFields.length ; i++) {
//            jdbcTemplate.update(sqlQuery, new Object[] {name, songFields[i].toString()});
//        }
    }
}
