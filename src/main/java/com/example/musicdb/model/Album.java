package com.example.musicdb.model;


public class Album {
    private int id;
    private String artistName;
    private String albumTitle;
    private String songName;
    private int releaseYear;

    public Album() {

    }

    public Album(int id, String artistName, String albumTitle, String songName, int releaseYear) {
        this.id = id;
        this.artistName = artistName;
        this.albumTitle = albumTitle;
        this.songName = songName;
        this.releaseYear = releaseYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
}
