package com.NetCracked.project.gromov.thundersound.serviceInterface;

import com.NetCracked.project.gromov.thundersound.entity.Album;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface AlbumServiceInterface {

    ResponseEntity<Album> saveAlbum(Album album);

    ResponseEntity<List<Album>> findAll(String name);

    ResponseEntity<Album> findById(UUID Id);

    ResponseEntity<HttpStatus> deleteById(UUID Id);

    ResponseEntity<Album> updateAlbum(UUID id, Album album);

}
