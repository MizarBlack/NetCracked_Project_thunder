package com.NetCracked.project.gromov.thundersound.serviceInterface;

import com.NetCracked.project.gromov.thundersound.entity.Track;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TrackServiceInterface {

    ResponseEntity<Track> saveTrack(Track track);

    ResponseEntity<List<Track>> findAll(String name);

    ResponseEntity<Track> findById(int Id);

    ResponseEntity<HttpStatus> deleteById(int id);

    ResponseEntity<Track> updateTrack(int id, Track track);

    ResponseEntity<FileSystemResource> downloadTrack(int id);
}
