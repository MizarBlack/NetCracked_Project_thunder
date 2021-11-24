package com.NetCracked.project.gromov.thundersound.repository;

import com.NetCracked.project.gromov.thundersound.entity.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface AuthorRepository extends CrudRepository<Author, Integer> {

}
