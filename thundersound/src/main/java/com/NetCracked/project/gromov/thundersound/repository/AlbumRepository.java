package com.NetCracked.project.gromov.thundersound.repository;

import org.springframework.data.repository.CrudRepository;
import com.NetCracked.project.gromov.thundersound.entity.Album;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface AlbumRepository extends CrudRepository<Album, UUID> {
    List<Album> findAllByName (String name);
    List<Album> findAllById(UUID Id);
    List<Album> findAllByRealise_data(LocalDate realise_data);
}
