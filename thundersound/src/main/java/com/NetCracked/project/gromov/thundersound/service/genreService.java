package com.NetCracked.project.gromov.thundersound.service;

import com.NetCracked.project.gromov.thundersound.entity.genre;
import com.NetCracked.project.gromov.thundersound.repository.genreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class genreService {

    @Autowired
    private final genreRepository genreRepository;

    public genreService(genreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public void genre(genre genre) {
        genreRepository.save(genre);
    }

    public List<genre> findAll() {
        return (List<genre>) genreRepository.findAll();
    }

    public List<genre> findAllByName(String name) {
        return genreRepository.findAllByName(name);
    }

    public List<genre> findAllById(UUID Id) {
        return genreRepository.findAllById(Id);
    }
}
