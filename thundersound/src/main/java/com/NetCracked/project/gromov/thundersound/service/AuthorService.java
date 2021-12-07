package com.NetCracked.project.gromov.thundersound.service;

import com.NetCracked.project.gromov.thundersound.entity.Author;
import com.NetCracked.project.gromov.thundersound.repository.AuthorRepository;
import com.NetCracked.project.gromov.thundersound.serviceInterface.AuthorServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthorService implements AuthorServiceInterface {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public ResponseEntity<Author> saveAuthor(Author author) {
        try {
            Author newAuthor = authorRepository
                    .save(new Author(author.getName(), author.getDescription(), author.getGenre_id()));
            return new ResponseEntity<>(newAuthor, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<Author>> findAll() {
        try {
            List<Author> authors = new ArrayList<Author>();
            authorRepository.findAll().forEach(authors::add);
            if (authors.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(authors, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Author> findById(UUID Id){
        Optional<Author> author = authorRepository.findById(Id);

        if (author.isPresent()) {
            return new ResponseEntity<>(author.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<HttpStatus> deleteById (UUID id) {
        try {
            authorRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Author> updateAuthor(UUID id, Author author) {
        Optional<Author> authorBD = authorRepository.findById(id);

        if (authorBD.isPresent()) {
            Author _author = authorBD.get();
            _author.setName(author.getName());
            _author.setDescription(author.getDescription());
            _author.setGenre_id(author.getGenre_id());
            return new ResponseEntity<>(authorRepository.save(_author), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
