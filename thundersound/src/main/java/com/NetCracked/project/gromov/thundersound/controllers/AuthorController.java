package com.NetCracked.project.gromov.thundersound.controllers;

import com.NetCracked.project.gromov.thundersound.entity.Author;
import com.NetCracked.project.gromov.thundersound.serviceInterface.AuthorServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<Author> getAuthor() {
        return authorService.findAll();
    }

    @GetMapping("/{id}")
    public Author getAuthor(@PathVariable("id") int id) {
        return authorService.findById(id);
    }

    @PostMapping("")
    public void addAuthor(@RequestBody Author author){
        authorService.saveAuthor(author);
    }

    @PutMapping("/update/{id}")
    public void updateAuthor(@PathVariable(value = "id") int id, @RequestBody Author author) {
        authorService.updateAuthor(id, author);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAuthor(@PathVariable(value = "id") int id) {
        authorService.deleteById(id);
    }
}