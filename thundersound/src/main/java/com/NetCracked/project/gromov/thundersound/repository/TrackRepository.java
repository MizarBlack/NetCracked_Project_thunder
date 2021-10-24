package com.NetCracked.project.gromov.thundersound.repository;

import com.NetCracked.project.gromov.thundersound.entity.Track;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

public interface TrackRepository extends CrudRepository<Track, UUID> {
    List<Track> findAllByName(String name);
    List<Track> findAllByData_load(LocalDate data_load);
    List<Track> findAllByDuration(LocalTime duration);
    List<Track> findAllById(UUID Id);

}
