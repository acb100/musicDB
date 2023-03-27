package com.example.musicdb.repository;

import com.example.musicdb.model.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AlbumRepo {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Album> fetchAll() {
        String sql = "SELECT * FROM album";
        RowMapper<Album> rowMapper = new BeanPropertyRowMapper<>(Album.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

    public void addAlbum(Album a) {
        String sql = "INSERT INTO album (id, artist_name, album_title, song_name, release_year) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, a.getId(), a.getArtistName(), a.getAlbumTitle(), a.getSongName(), a.getReleaseYear());
    }

    public Album findAlbumById(int id) {
        return null;
    }

    public Boolean deleteAlbum(int id) {
        return null;
    }

    public void updateAlbum(int id, Album a) {

    }
}
