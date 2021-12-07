package com.NetCracked.project.gromov.thundersound.serviceInterface;

import com.NetCracked.project.gromov.thundersound.entity.Author;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface AuthorServiceInterface {

    ResponseEntity<Author> saveAuthor(Author author);

    ResponseEntity<List<Author>> findAll();

    ResponseEntity<Author> findById(UUID Id);

    ResponseEntity<HttpStatus> deleteById (UUID id);

    ResponseEntity<Author> updateAuthor(UUID id, Author author);

}
