package com.NetCracked.project.gromov.thundersound.controllers;

import com.NetCracked.project.gromov.thundersound.entity.Genre;
import com.NetCracked.project.gromov.thundersound.serviceInterface.genreServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Genre> getGenre() {
        return genreService.findAll();
    }

    @GetMapping("/{id}")
    public Genre getGenre(@PathVariable("id") int id) {
        return genreService.findById(id);
    }

    @PostMapping("")
    public void addGenre(@RequestBody Genre genre){
        genreService.saveGenre(genre);
    }

    @PatchMapping("/update/{id}")
    public void updateGenre(@PathVariable(value = "id") int id, @RequestBody Genre genre) {
        genreService.updateGenre(id, genre);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteGenre(@PathVariable(value = "id") int id) {
        genreService.deleteById(id);
    }
}