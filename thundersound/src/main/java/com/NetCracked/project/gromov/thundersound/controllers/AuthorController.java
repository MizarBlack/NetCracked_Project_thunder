package com.NetCracked.project.gromov.thundersound.controllers;

import com.NetCracked.project.gromov.thundersound.entity.Author;
import com.NetCracked.project.gromov.thundersound.serviceInterface.AuthorServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/author")
public class AuthorController {

    private final AuthorServiceInterface authorService;

    @Autowired
    public AuthorController(AuthorServiceInterface authorService) {
        this.authorService = authorService;
    }

    @GetMapping("")
    public ResponseEntity<List<Author>> getAuthors() {
        return authorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthor(@PathVariable("id") UUID id) {
        return authorService.findById(id);
    }

    @PostMapping("")
    public ResponseEntity<Author> addAuthor(@RequestBody Author author){
        return authorService.saveAuthor(author);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable(value = "id") UUID id, @RequestBody Author author) {
        return authorService.updateAuthor(id, author);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteAuthor(@PathVariable(value = "id") UUID id) {
        return authorService.deleteById(id);
    }
}