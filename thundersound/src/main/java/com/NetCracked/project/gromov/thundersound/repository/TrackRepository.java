package com.NetCracked.project.gromov.thundersound.repository;

import com.NetCracked.project.gromov.thundersound.entity.Track;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface TrackRepository extends CrudRepository<Track, UUID> {
    List<Track> findAllByNameContaining(String name);
    Track findTrackById(UUID id);

}
