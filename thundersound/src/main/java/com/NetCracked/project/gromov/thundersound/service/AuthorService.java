package com.NetCracked.project.gromov.thundersound.service;

import com.NetCracked.project.gromov.thundersound.entity.Author;
import com.NetCracked.project.gromov.thundersound.repository.AuthorRepository;
import com.NetCracked.project.gromov.thundersound.serviceInterface.AuthorServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AuthorService implements AuthorServiceInterface {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void saveAuthor(Author author) {
        authorRepository.save(author);
    }

    @Override
    public List<Author> findAll() {
        return (List<Author>) authorRepository.findAll();
    }

    @Override
    public Author findById(int Id){
        return authorRepository.findById(Id).orElse(null);
    }

    @Override
    public void deleteById (int id) {
        authorRepository.deleteById(id);
    }

    @Override
    public void updateAuthor(int id, Author author) {
        Author authorToBD = authorRepository.findById(id).get();
        authorToBD.setName(author.getName());
        authorToBD.setDescription(author.getDescription());
        authorToBD.setGenre_id(author.getGenre_id());
        authorRepository.save(authorToBD);
    }
}
