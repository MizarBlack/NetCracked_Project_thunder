package com.NetCracked.project.gromov.thundersound.serviceInterface;

import com.NetCracked.project.gromov.thundersound.entity.Author;
import java.util.List;

public interface AuthorServiceInterface {

    void saveAuthor(Author author);

    List<Author> findAll();

    Author findById(int Id);

    void deleteById (int id);

    void updateAuthor(int id, Author author);

}
