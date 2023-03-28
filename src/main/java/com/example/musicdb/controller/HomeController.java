package com.example.musicdb.controller;

import com.example.musicdb.model.Album;
import com.example.musicdb.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String create() {
        return "home/create";
    }

    @PostMapping("/createNew")
    public String createNew(@ModelAttribute Album album) {
        albumService.addAlbum(album);
        return "redirect:/";
    }

    @GetMapping("/viewOne/{id}")
    public String viewOne(@PathVariable("id") int id, Model model) {
        model.addAttribute("album", albumService.findAlbumById(id));
        return "home/viewOne";
    }

    @GetMapping("/deleteOne/{id}")
    public String deleteOne(@PathVariable("id") int id, Model model) {
        boolean deleted = albumService.deleteAlbum(id);
        if (deleted) {
            return "redirect:/";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/updateOne/{id}")
    public String updateOne(@PathVariable("id") int id, Model model) {
        model.addAttribute("album", albumService.findAlbumById(id));
        return "home/updateOne";
    }

    @PostMapping("/updateAlbum")
    public String updateAlbum(@ModelAttribute Album album) {
        albumService.updateAlbum(album.getId(), album);
        return "redirect:/";
    }
}
