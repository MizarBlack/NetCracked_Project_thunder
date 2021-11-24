package com.NetCracked.project.gromov.thundersound.controllers;

import com.NetCracked.project.gromov.thundersound.entity.Playlist;
import com.NetCracked.project.gromov.thundersound.serviceInterface.PlaylistServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/playlist")
public class PlaylistController {

    private final PlaylistServiceInterface playlistService;

    @Autowired
    public PlaylistController(PlaylistServiceInterface playlistService) {
        this.playlistService = playlistService;
    }

    @GetMapping("")
    public ResponseEntity<List<Playlist>> getAllPlaylist() {
        List<Playlist> playlists = playlistService.findAll();
        return new ResponseEntity<>(playlists, HttpStatus.OK);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Playlist> getPlaylist(@PathVariable("id") int id) {
//        ResponseEntity<Playlist> playlist = playlistService.findById(id);
//        return new ResponseEntity<>(playlist, HttpStatus.OK);
//    }

    @PostMapping("")
    public void addPlaylist(@RequestBody Playlist playlist){
        playlistService.savePlaylist(playlist);
    }

    @PatchMapping("/update/{id}")
    public void updateAlbum(@PathVariable(value = "id") int id, @RequestBody Playlist playlist) {
        playlistService.updatePlaylist(id, playlist);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePlaylist(@PathVariable(value = "id") int id) {
        playlistService.deleteById(id);
    }
}