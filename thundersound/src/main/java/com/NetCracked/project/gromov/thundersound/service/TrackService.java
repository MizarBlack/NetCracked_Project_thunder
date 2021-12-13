package com.NetCracked.project.gromov.thundersound.service;

import com.NetCracked.project.gromov.thundersound.entity.Track;
import com.NetCracked.project.gromov.thundersound.repository.TrackRepository;
import com.NetCracked.project.gromov.thundersound.serviceInterface.TrackServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;


@Service
public class TrackService implements TrackServiceInterface {

    private final TrackRepository trackRepository;

    @Autowired
    public TrackService(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public ResponseEntity<Track> saveTrack(@RequestParam Track track) {
        try {
            Track newTrack = trackRepository
                    .save(new Track(track.getName(), track.getText(), track.getFile_name(), track.getData_load(), track.getDuration(), track.getGenre_id()));
            return new ResponseEntity<>(newTrack, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<Track>> findAll(String name) {
        try {
            List<Track> tracks = new ArrayList<Track>();

            if (name == null)
                trackRepository.findAll().forEach(tracks::add);
            else
                trackRepository.findAllByNameContaining(name).forEach(tracks::add);

            if (tracks.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(tracks, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Track> findById(UUID Id){
        Optional<Track> track = trackRepository.findById(Id);

        if (track.isPresent()) {
            return new ResponseEntity<>(track.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<HttpStatus> deleteById(UUID id) {
        try {
            trackRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Track> updateTrack(UUID id, Track track) {
        Optional<Track> trackBD = trackRepository.findById(id);

        if (trackBD.isPresent()) {
            Track _track = trackBD.get();
            _track.setName(track.getName());
            _track.setDuration(track.getDuration());
            _track.setData_load(track.getData_load());
            _track.setFile_name(track.getFile_name());
            _track.setGenre_id(track.getGenre_id());
            _track.setText(track.getText());
            return new ResponseEntity<>(trackRepository.save(_track), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public ResponseEntity<FileSystemResource> downloadTrack(UUID id){
        Track track = trackRepository.findTrackById(id);
        File savedTrack = new File(path, track.getFile_name());

        if (!savedTrack.exists()) {
            try {
                throw new IllegalAccessException("File not found! Path: '" + path + "'");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        FileSystemResource resource = new FileSystemResource(savedTrack);
        ResponseEntity<FileSystemResource> body = ResponseEntity.ok()
                .body(resource);
        return body;
    }

    @Override
    public void init() {
        try {
            Files.createDirectory(pathFile);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }

    @Override
    public void save(MultipartFile file) {
        try {
            Files.copy(file.getInputStream(), this.pathFile.resolve(file.getOriginalFilename()));
        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
    }

    @Override
    public ResponseEntity<Track> saveFileTrack(@RequestParam Track track) {
        try {
            Track newTrack = trackRepository
                    .save(new Track(track.getName(), track.getFile_name()));
            return new ResponseEntity<>(newTrack, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Resource load(String filename) {
        try {
            Path file = pathFile.resolve(filename);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(pathFile.toFile());
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.pathFile, 1).filter(path -> !path.equals(this.pathFile)).map(this.pathFile::relativize);
        } catch (IOException e) {
            throw new RuntimeException("Could not load the files!");
        }
    }

    private static final String path = "G:/Music for project/";
    private final Path pathFile = Paths.get("G:/Music for project/");

}