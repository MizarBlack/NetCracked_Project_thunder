package com.NetCracked.project.gromov.thundersound.serviceInterface;

import com.NetCracked.project.gromov.thundersound.entity.Track;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface TrackServiceInterface {

    ResponseEntity<Track> saveTrack(Track track);

    ResponseEntity<List<Track>> findAll(String name);

    ResponseEntity<Track> findById(UUID Id);

    ResponseEntity<HttpStatus> deleteById(UUID id);

    ResponseEntity<Track> updateTrack(UUID id, Track track);

    ResponseEntity<FileSystemResource> downloadTrack(UUID id);
}
