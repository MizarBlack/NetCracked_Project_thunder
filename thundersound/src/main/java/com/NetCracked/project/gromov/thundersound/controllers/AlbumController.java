package com.NetCracked.project.gromov.thundersound.controllers;

import com.NetCracked.project.gromov.thundersound.entity.Album;
import com.NetCracked.project.gromov.thundersound.serviceInterface.AlbumServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/album")
public class AlbumController {

    private final AlbumServiceInterface albumService;

    @Autowired
    public AlbumController(AlbumServiceInterface albumService) {
        this.albumService = albumService;
    }

    @GetMapping("")
    public ResponseEntity<List<Album>> getAlbums(@RequestParam(required = false) String name) {
        return albumService.findAll(name);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Album> getAlbum(@PathVariable("id") int id) {
        return albumService.findById(id);
    }

    @PostMapping("")
    public ResponseEntity<Album> addAlbum(@RequestBody Album album){
        return albumService.saveAlbum(album);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Album> updateAlbum(@PathVariable(value = "id") int id, @RequestBody Album album) {
        return albumService.updateAlbum(id, album);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteAlbum(@PathVariable(value = "id") int id) {
        return albumService.deleteById(id);
    }
}