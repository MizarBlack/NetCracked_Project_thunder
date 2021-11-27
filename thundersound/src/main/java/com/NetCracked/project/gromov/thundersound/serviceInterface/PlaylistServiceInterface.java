package com.NetCracked.project.gromov.thundersound.serviceInterface;

import com.NetCracked.project.gromov.thundersound.entity.Playlist;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface PlaylistServiceInterface {

    ResponseEntity<Playlist> savePlaylist(Playlist playlist);

    ResponseEntity<List<Playlist>> findAll(String name);

    ResponseEntity<Playlist> findById(int Id);

    ResponseEntity<HttpStatus> deleteById(int id);

    ResponseEntity<Playlist> updatePlaylist(int id, Playlist playlist);
}
