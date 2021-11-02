package com.NetCracked.project.gromov.thundersound.controllers;

import com.NetCracked.project.gromov.thundersound.entity.Album;
import com.NetCracked.project.gromov.thundersound.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class AlbumController {

    @Autowired
    private AlbumRepository albumRepository;

    public AlbumController(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @GetMapping("/album/")
    public Iterable<Album> getAlbums() {
        return albumRepository.findAll();
    }

    @GetMapping("/album/{id}")
    public Album getAlbum(@PathVariable("id") UUID id) {
        return albumRepository.findById(id).get();
    }

    @PostMapping("/album")
    public Album addAlbum(@RequestBody Album album){
        return albumRepository.save(album);
    }

    @PutMapping("/album/{id}")
    public ResponseEntity<Album> updateAlbum(@PathVariable(value = "id") UUID id,
    @RequestBody Album albumDetails ) throws FileNotFoundException {
        Album album = albumRepository.findById(id)
                .orElseThrow(() -> new FileNotFoundException("Album not found for this id :: " + id));
        album.setDescription(albumDetails.getDescription());
        album.setId(albumDetails.getId());
        album.setName(albumDetails.getName());
        album.setRealise_data(albumDetails.getRealise_data());
        final Album updatedAlbum = albumRepository.save(album);
        return ResponseEntity.ok(updatedAlbum);
    }

    @DeleteMapping("/album/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") UUID id)
            throws FileNotFoundException {
        Album album = albumRepository.findById(id)
                .orElseThrow(() -> new FileNotFoundException("Employee not found for this id :: " + id));

        albumRepository.delete(album);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
