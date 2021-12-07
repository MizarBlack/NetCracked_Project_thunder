package com.NetCracked.project.gromov.thundersound.serviceInterface;

import com.NetCracked.project.gromov.thundersound.entity.Genre;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface genreServiceInterface {

    ResponseEntity<Genre> saveGenre(Genre genre);

    ResponseEntity<List<Genre>> findAll();

    ResponseEntity<Genre> findById(UUID Id);

    ResponseEntity<HttpStatus> deleteById(UUID id);

    ResponseEntity<Genre> updateGenre(UUID id, Genre genre);

}
