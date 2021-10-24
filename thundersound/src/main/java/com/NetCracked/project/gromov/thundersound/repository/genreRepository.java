package com.NetCracked.project.gromov.thundersound.repository;

import com.NetCracked.project.gromov.thundersound.entity.genre;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface genreRepository extends CrudRepository<genre, UUID> {
    List<genre> findAllByName(String name);
    List<genre> findAllById(UUID Id);
}
