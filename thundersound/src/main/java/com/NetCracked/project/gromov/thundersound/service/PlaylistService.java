package com.NetCracked.project.gromov.thundersound.service;

import com.NetCracked.project.gromov.thundersound.entity.Playlist;
import com.NetCracked.project.gromov.thundersound.repository.PlaylistRepository;
import com.NetCracked.project.gromov.thundersound.serviceInterface.PlaylistServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PlaylistService implements PlaylistServiceInterface {

    private final PlaylistRepository playlistRepository;

    @Autowired
    public PlaylistService(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    @Override
    public ResponseEntity<Playlist> savePlaylist(Playlist playlist) {
        try {
            Playlist newPlaylist = playlistRepository
                    .save(new Playlist(playlist.getName(), playlist.getUser_id()));
            return new ResponseEntity<>(newPlaylist, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<Playlist>> findAll(String name) {
        try {
            List<Playlist> playlists = new ArrayList<Playlist>();

            if (name == null)
                playlistRepository.findAll().forEach(playlists::add);
            else
                playlistRepository.findAllByNameContaining(name).forEach(playlists::add);

            if (playlists.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(playlists, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Playlist> findById(int Id) {
        Optional<Playlist> playlist = playlistRepository.findById(Id);

        if (playlist.isPresent()) {
            return new ResponseEntity<>(playlist.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<HttpStatus> deleteById(int id) {
        try {
            playlistRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Playlist> updatePlaylist(int id, Playlist playlist) {
        Optional<Playlist> playlistBD = playlistRepository.findById(id);

        if (playlistBD.isPresent()) {
            Playlist _playlist = playlistBD.get();
            _playlist.setName(playlist.getName());
            _playlist.setUser_id(playlist.getUser_id());
            return new ResponseEntity<>(playlistRepository.save(_playlist), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}