package com.NetCracked.project.gromov.thundersound.serviceInterface;

import com.NetCracked.project.gromov.thundersound.entity.Track;

import java.util.List;

public interface TrackServiceInterface {

    void saveTrack(Track track);

    List<Track> findAll();

    Track findById(int Id);

    void deleteById(int id);

    void updateTrack(int id, Track track);

}
