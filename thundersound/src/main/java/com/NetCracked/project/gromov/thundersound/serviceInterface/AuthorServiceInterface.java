package com.NetCracked.project.gromov.thundersound.serviceInterface;

import com.NetCracked.project.gromov.thundersound.entity.Author;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AuthorServiceInterface {

    ResponseEntity<Author> saveAuthor(Author author);

    ResponseEntity<List<Author>> findAll();

    ResponseEntity<Author> findById(int Id);

    ResponseEntity<HttpStatus> deleteById (int id);

    ResponseEntity<Author> updateAuthor(int id, Author author);

}
