package com.NetCracked.project.gromov.thundersound.service;

import com.NetCracked.project.gromov.thundersound.entity.Track;
import com.NetCracked.project.gromov.thundersound.repository.TrackRepository;
import com.NetCracked.project.gromov.thundersound.serviceInterface.TrackServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TrackService implements TrackServiceInterface {

    private final TrackRepository trackRepository;

    @Autowired
    public TrackService(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public void saveTrack(Track track) {
        trackRepository.save(track);
    }

    @Override
    public List<Track> findAll() {
        return (List<Track>) trackRepository.findAll();
    }

    @Override
    public Track findById(int Id){
        return trackRepository.findById(Id).orElse(null);
    }

    @Override
    public void deleteById(int id) {
        trackRepository.deleteById(id);
    }

    @Override
    public void updateTrack(int id, Track track) {
        Track trackToBD = trackRepository.findById(id).get();
        trackToBD.setName(track.getName());
        trackToBD.setText(track.getText());
        trackToBD.setGenre_id(track.getGenre_id());
        trackToBD.setFile_name(track.getFile_name());
        trackToBD.setDuration(track.getDuration());
        trackToBD.setData_load(track.getData_load());
        trackRepository.save(trackToBD);
    }
}