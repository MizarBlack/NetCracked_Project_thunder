package com.NetCracked.project.gromov.thundersound.service;

import antlr.ASTNULLType;
import com.NetCracked.project.gromov.thundersound.entity.Track;
import com.NetCracked.project.gromov.thundersound.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Service
public class TrackService {

    @Autowired
    private final TrackRepository trackRepository;

    public TrackService(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    public void createUsers(Track track) {
        trackRepository.save(track);
    }

    public List<Track> findAll() {
        return (List<Track>) trackRepository.findAll();
    }

    public List<Track> findAllByName(String name){
        return trackRepository.findAllByName(name);
    }

    public List<Track> findAllById(UUID Id){
        return trackRepository.findAllById(Id);
    }

    public List<Track> findAllByData_load(LocalDate data_load){
        return trackRepository.findAllByData_load(data_load);
    }

    public List<Track> findAllByDuration(LocalTime duration){
        return trackRepository.findAllByDuration(duration);
    }
}