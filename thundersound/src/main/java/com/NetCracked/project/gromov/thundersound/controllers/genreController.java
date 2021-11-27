package com.NetCracked.project.gromov.thundersound.controllers;

import com.NetCracked.project.gromov.thundersound.entity.Genre;
import com.NetCracked.project.gromov.thundersound.serviceInterface.genreServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/genre")
public class GenreController {

    private final genreServiceInterface genreService;

    @Autowired
    public GenreController(genreServiceInterface genreService) {
        this.genreService = genreService;
    }

    @GetMapping("")
    public ResponseEntity<List<Genre>> getGenre() {
        return genreService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Genre> getGenre(@PathVariable("id") int id) {
        return genreService.findById(id);
    }

    @PostMapping("")
    public ResponseEntity<Genre> addGenre(@RequestBody Genre genre){
        return genreService.saveGenre(genre);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Genre> updateGenre(@PathVariable(value = "id") int id, @RequestBody Genre genre) {
        return genreService.updateGenre(id, genre);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteGenre(@PathVariable(value = "id") int id) {
        return genreService.deleteById(id);
    }
}