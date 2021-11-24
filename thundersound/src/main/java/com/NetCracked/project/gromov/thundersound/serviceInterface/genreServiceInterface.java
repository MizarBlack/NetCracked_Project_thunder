package com.NetCracked.project.gromov.thundersound.serviceInterface;

import com.NetCracked.project.gromov.thundersound.entity.Genre;

import java.util.List;

public interface genreServiceInterface {

    void saveGenre(Genre genre);

    List<Genre> findAll();

    Genre findById(int Id);

    void deleteById(int id);

    void updateGenre(int id, Genre genre);

}
