package com.NetCracked.project.gromov.thundersound.service;

import com.NetCracked.project.gromov.thundersound.entity.Author;
import com.NetCracked.project.gromov.thundersound.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AuthorService {

    @Autowired
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void Author(Author author) {
        authorRepository.save(author);
    }

    public List<Author> findAll() {
        return (List<Author>) authorRepository.findAll();
    }

    public List<Author> findAllByName(String name){
        return authorRepository.findAllByName(name);
    }

    public List<Author> findAllById(UUID Id){
        return authorRepository.findAllById(Id);
    }

    public List<Author> findAllByGenre_id(UUID genreId){
        return authorRepository.findAllByGenre_id(genreId);
    }
}
