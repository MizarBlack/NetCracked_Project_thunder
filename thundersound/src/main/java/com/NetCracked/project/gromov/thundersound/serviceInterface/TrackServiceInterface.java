package com.NetCracked.project.gromov.thundersound.serviceInterface;

import com.NetCracked.project.gromov.thundersound.entity.Track;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

public interface TrackServiceInterface {

    ResponseEntity<Track> saveTrack(Track track);

    ResponseEntity<List<Track>> findAll(String name);

    ResponseEntity<Track> findById(UUID Id);

    ResponseEntity<HttpStatus> deleteById(UUID id);

    ResponseEntity<Track> updateTrack(UUID id, Track track);

    ResponseEntity<FileSystemResource> downloadTrack(UUID id);

    public void init();

    public void save(MultipartFile file);

    public Resource load(String filename);

    public void deleteAll();

    public Stream<Path> loadAll();

    public ResponseEntity<Track> saveFileTrack(Track track);

}
