package com.NetCracked.project.gromov.thundersound.service;

import com.NetCracked.project.gromov.thundersound.entity.Playlist;
import com.NetCracked.project.gromov.thundersound.repository.PlaylistRepository;
import com.NetCracked.project.gromov.thundersound.serviceInterface.PlaylistServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PlaylistService implements PlaylistServiceInterface {

    private final PlaylistRepository playlistRepository;

    @Autowired
    public PlaylistService(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    @Override
    public void savePlaylist(Playlist playlist) {
        playlistRepository.save(playlist);
    }

    @Override
    public List<Playlist> findAll() {
        return (List<Playlist>) playlistRepository.findAll();
    }

    @Override
    public ResponseEntity<Playlist> findById(int Id) {
        Playlist playlist = playlistRepository.findById(Id).get();
        return ResponseEntity.ok(playlist);
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteById(int id) {
        playlistRepository.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Playlist> updatePlaylist(int id, Playlist playlist) {
        Playlist playlistToBD = playlistRepository.findById(id).get();
        playlistToBD.setName(playlist.getName());
        playlistToBD.setUser_id(playlist.getUser_id());
        Playlist updatePlaylist = playlistRepository.save(playlistToBD);
        return ResponseEntity.ok(updatePlaylist);
    }

    @Override
    public List<Playlist> findByNameContaining(String name){
        return playlistRepository.findByNameContaining(name);
    }
}