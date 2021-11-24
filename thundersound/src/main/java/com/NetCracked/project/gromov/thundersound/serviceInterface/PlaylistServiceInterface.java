package com.NetCracked.project.gromov.thundersound.serviceInterface;

import com.NetCracked.project.gromov.thundersound.entity.Playlist;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface PlaylistServiceInterface {

    void savePlaylist(Playlist playlist);

    List<Playlist> findAll();

    ResponseEntity<Playlist> findById(int Id);

    ResponseEntity<Map<String, Boolean>> deleteById(int id);

    ResponseEntity<Playlist> updatePlaylist(int id, Playlist playlist);

    List<Playlist> findByNameContaining(String name);
}
