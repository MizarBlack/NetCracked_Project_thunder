package com.NetCracked.project.gromov.thundersound.service;

import com.NetCracked.project.gromov.thundersound.entity.Genre;
import com.NetCracked.project.gromov.thundersound.repository.GenreRepository;
import com.NetCracked.project.gromov.thundersound.serviceInterface.genreServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GenreService implements genreServiceInterface {

    private final GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public ResponseEntity<Genre> saveGenre(Genre genre) {
        try {
            Genre newGenre = genreRepository
                    .save(new Genre(genre.getName(), genre.getDescription()));
            return new ResponseEntity<>(newGenre, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<Genre>> findAll() {
        try {
            List<Genre> genres = new ArrayList<Genre>();
            genreRepository.findAll().forEach(genres::add);
            if (genres.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(genres, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Genre> findById(int Id) {
        Optional<Genre> genre = genreRepository.findById(Id);

        if (genre.isPresent()) {
            return new ResponseEntity<>(genre.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<HttpStatus> deleteById(int id) {
        try {
            genreRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Genre> updateGenre(int id, Genre genre) {
        Optional<Genre> genreBD = genreRepository.findById(id);

        if (genreBD.isPresent()) {
            Genre _genre = genreBD.get();
            _genre.setName(genre.getName());
            _genre.setDescription(genre.getDescription());
            return new ResponseEntity<>(genreRepository.save(_genre), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
