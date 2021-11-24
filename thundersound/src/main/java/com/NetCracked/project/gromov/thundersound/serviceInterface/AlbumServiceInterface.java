package com.NetCracked.project.gromov.thundersound.serviceInterface;

import com.NetCracked.project.gromov.thundersound.entity.Album;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


public interface AlbumServiceInterface {

    ResponseEntity<Album> saveAlbum(Album album);

    ResponseEntity<List<Album>> findAll(String name);

    ResponseEntity<Album> findById(int Id);

    ResponseEntity<HttpStatus> deleteById(int Id);

    ResponseEntity<Album> updateAlbum(int id, Album album);

}
