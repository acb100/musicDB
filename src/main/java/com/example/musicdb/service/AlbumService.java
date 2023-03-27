package com.example.musicdb.service;

import com.example.musicdb.model.Album;
import com.example.musicdb.repository.AlbumRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {
    @Autowired
    AlbumRepo albumRepo;
    public List<Album> fetchAll(){
        return albumRepo.fetchAll();
    }

    public void addAlbum(Album a){
        albumRepo.addAlbum(a);
    }

    public Album findAlbumById(int id){
        return albumRepo.findAlbumById(id);
    }

    public Boolean deleteAlbum(int id){
        return albumRepo.deleteAlbum(id);
    }

    public void updateAlbum(int id, Album a){
        albumRepo.updateAlbum(id, a);
    }
}
