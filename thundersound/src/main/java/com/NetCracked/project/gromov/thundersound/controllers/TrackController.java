package com.NetCracked.project.gromov.thundersound.controllers;

import com.NetCracked.project.gromov.thundersound.entity.Track;
import com.NetCracked.project.gromov.thundersound.serviceInterface.TrackServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/track")
//@Procedure(MediaType.APPLICATION_JSON)
public class TrackController {

    private final TrackServiceInterface trackService;

    @Autowired
    public TrackController(TrackServiceInterface trackService) {
        this.trackService = trackService;
    }

    @GetMapping("")
    public ResponseEntity<List<Track>> getTracks(String name) {
        return trackService.findAll(name);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Track> getTrack(@PathVariable("id") UUID id) {
        return trackService.findById(id);
    }

    @GetMapping(value = "/{id}/download", produces = "audio/mpeg")
    public ResponseEntity<FileSystemResource> downloadTrack(@PathVariable("id") UUID id) throws FileNotFoundException, MalformedURLException {
        return trackService.downloadTrack(id);
    }

    @PostMapping("")
    public ResponseEntity<Track> addTrack(@RequestBody Track track){
        return trackService.saveTrack(track);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Track> updateTrack(@PathVariable(value = "id") UUID id, @RequestBody Track track) {
        return trackService.updateTrack(id, track);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteTrack(@PathVariable(value = "id") UUID id) {
        return trackService.deleteById(id);
    }
}