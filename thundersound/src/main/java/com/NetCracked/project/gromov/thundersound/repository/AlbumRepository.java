package com.NetCracked.project.gromov.thundersound.repository;

import org.springframework.data.repository.CrudRepository;
import com.NetCracked.project.gromov.thundersound.entity.Album;

import java.util.List;
import java.util.UUID;

public interface AlbumRepository extends CrudRepository<Album, UUID> {

    List<Album> findAllByNameContaining(String name);

}
