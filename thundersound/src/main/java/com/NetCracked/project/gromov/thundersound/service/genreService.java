package com.NetCracked.project.gromov.thundersound.service;

import com.NetCracked.project.gromov.thundersound.entity.Genre;
import com.NetCracked.project.gromov.thundersound.repository.GenreRepository;
import com.NetCracked.project.gromov.thundersound.serviceInterface.genreServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GenreService implements genreServiceInterface {

    private final GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public void saveGenre(Genre genre) {
        genreRepository.save(genre);
    }

    @Override
    public List<Genre> findAll() {
        return (List<Genre>) genreRepository.findAll();
    }

    @Override
    public Genre findById(int Id) {
        return genreRepository.findById(Id).orElse(null);
    }

    @Override
    public void deleteById(int id) {
        genreRepository.deleteById(id);
    }

    @Override
    public void updateGenre(int id, Genre genre) {
        Genre genreToBD = genreRepository.findById(id).get();
        genreToBD.setName(genre.getName());
        genreToBD.setDescription(genre.getDescription());
        genreRepository.save(genreToBD);
    }
}
