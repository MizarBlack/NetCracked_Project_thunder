package com.NetCracked.project.gromov.thundersound.controllers;

import com.NetCracked.project.gromov.thundersound.entity.Track;
import com.NetCracked.project.gromov.thundersound.serviceInterface.TrackServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/track")
public class TrackController {

    private final TrackServiceInterface trackService;

    @Autowired
    public TrackController(TrackServiceInterface trackService) {
        this.trackService = trackService;
    }

    @GetMapping("")
    public List<Track> getTrack() {
        return trackService.findAll();
    }

    @GetMapping("/{id}")
    public Track getTrack(@PathVariable("id") int id) {
        return trackService.findById(id);
    }

    @PostMapping("")
    public void addTrack(@RequestBody Track track){
        trackService.saveTrack(track);
    }

    @PatchMapping("/update/{id}")
    public void updateTrack(@PathVariable(value = "id") int id, @RequestBody Track track) {
        trackService.updateTrack(id, track);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTrack(@PathVariable(value = "id") int id) {
        trackService.deleteById(id);
    }
}