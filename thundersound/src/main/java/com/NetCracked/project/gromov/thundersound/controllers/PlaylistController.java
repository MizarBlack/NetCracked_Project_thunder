package com.NetCracked.project.gromov.thundersound.controllers;

import com.NetCracked.project.gromov.thundersound.entity.Playlist;
import com.NetCracked.project.gromov.thundersound.serviceInterface.PlaylistServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
    public ResponseEntity<List<Playlist>> getPlaylists(@RequestParam(required = false) String name) {
        return playlistService.findAll(name);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Playlist> getPlaylist(@PathVariable("id") int id) {
        return playlistService.findById(id);
    }

    @PostMapping("")
    public ResponseEntity<Playlist> addPlaylist(@RequestBody Playlist playlist){
        return playlistService.savePlaylist(playlist);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Playlist> updatePlaylist(@PathVariable(value = "id") int id, @RequestBody Playlist playlist) {
        return playlistService.updatePlaylist(id, playlist);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deletePlaylist(@PathVariable(value = "id") int id) {
        return playlistService.deleteById(id);
    }
}