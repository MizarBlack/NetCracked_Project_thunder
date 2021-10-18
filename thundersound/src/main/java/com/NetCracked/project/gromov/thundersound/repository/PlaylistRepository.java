package com.NetCracked.project.gromov.thundersound.repository;

import com.NetCracked.project.gromov.thundersound.entity.Playlist;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PlaylistRepository extends CrudRepository<Playlist, UUID> {
}