package com.example.musicdb.controller;

import com.example.musicdb.model.Album;
import com.example.musicdb.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    AlbumService albumService;

    @GetMapping("/")
    public String index(Model model) {
        List<Album> albumList = albumService.fetchAll();
        model.addAttribute("albums", albumList);
        return "home/index";
    }

    @GetMapping("/create")
    public String create(){
        return "home/create";
    }

    @PostMapping("/createNew")
    public String createNew(@ModelAttribute Album album){
        albumService.addAlbum(album);
        return "redirect:/";
    }
}
