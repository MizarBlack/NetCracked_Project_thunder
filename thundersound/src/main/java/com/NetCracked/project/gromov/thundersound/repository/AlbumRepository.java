package com.NetCracked.project.gromov.thundersound.repository;

import org.springframework.data.repository.CrudRepository;
import com.NetCracked.project.gromov.thundersound.entity.Album;

import java.util.List;

public interface AlbumRepository extends CrudRepository<Album, Integer> {

    List<Album> findAllByNameContaining(String name);

}
