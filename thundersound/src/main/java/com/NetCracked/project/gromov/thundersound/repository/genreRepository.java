package com.NetCracked.project.gromov.thundersound.repository;

import com.NetCracked.project.gromov.thundersound.entity.genre;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface genreRepository extends CrudRepository<genre, UUID> {
}
