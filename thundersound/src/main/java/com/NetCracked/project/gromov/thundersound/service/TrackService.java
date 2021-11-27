package com.NetCracked.project.gromov.thundersound.service;

import com.NetCracked.project.gromov.thundersound.entity.Track;
import com.NetCracked.project.gromov.thundersound.repository.TrackRepository;
import com.NetCracked.project.gromov.thundersound.serviceInterface.TrackServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@Service
public class TrackService implements TrackServiceInterface {

    private final TrackRepository trackRepository;

    @Autowired
    public TrackService(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public ResponseEntity<Track> saveTrack(Track track) {
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
    public ResponseEntity<Track> findById(int Id){
        Optional<Track> track = trackRepository.findById(Id);

        if (track.isPresent()) {
            return new ResponseEntity<>(track.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<HttpStatus> deleteById(int id) {
        try {
            trackRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Track> updateTrack(int id, Track track) {
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
    public ResponseEntity<FileSystemResource> downloadTrack(int id){
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

    private static final String path = "G:/Music for project/";
}