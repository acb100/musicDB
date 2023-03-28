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
    JdbcTemplate template;

    public List<Album> fetchAll() {
        String sql = "SELECT * FROM album";
        RowMapper<Album> rowMapper = new BeanPropertyRowMapper<>(Album.class);
        return template.query(sql, rowMapper);
    }

    public void addAlbum(Album a) {
        String sql = "INSERT INTO album (id, artist_name, album_title, song_name, release_year) VALUES (?, ?, ?, ?, ?)";
        template.update(sql, a.getId(), a.getArtistName(), a.getAlbumTitle(), a.getSongName(), a.getReleaseYear());
    }

    public Album findAlbumById(int id) {
        String sql = "SELECT * FROM album WHERE id = ?";
        RowMapper<Album> rowMapper = new BeanPropertyRowMapper<>(Album.class);
        Album a = template.queryForObject(sql, rowMapper, id);
        return a;
    }

    public Boolean deleteAlbum(int id) {
        String sql = "DELETE FROM album WHERE id = ?";
        return template.update(sql, id) > 0;
    }

    public void updateAlbum(int id, Album a) {
        String sql = "UPDATE album SET artist_name = ?, album_title = ?, song_name = ?, release_year = ? WHERE ID = ?";
        template.update(sql, a.getArtistName(), a.getAlbumTitle(), a.getSongName(), a.getReleaseYear());
    }
}
