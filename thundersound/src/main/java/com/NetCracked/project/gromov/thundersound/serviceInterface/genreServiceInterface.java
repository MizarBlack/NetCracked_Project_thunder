package com.NetCracked.project.gromov.thundersound.serviceInterface;

import com.NetCracked.project.gromov.thundersound.entity.Genre;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface genreServiceInterface {

    ResponseEntity<Genre> saveGenre(Genre genre);

    ResponseEntity<List<Genre>> findAll();

    ResponseEntity<Genre> findById(int Id);

    ResponseEntity<HttpStatus> deleteById(int id);

    ResponseEntity<Genre> updateGenre(int id, Genre genre);

}
