package com.NetCracked.project.gromov.thundersound.service;

import com.NetCracked.project.gromov.thundersound.entity.Playlist;
import com.NetCracked.project.gromov.thundersound.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PlaylistService {

    @Autowired
    private final PlaylistRepository playlistRepository;

    public PlaylistService(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    public void createPlaylist(Playlist playlist) {
        playlistRepository.save(playlist);
    }

    public List<Playlist> findAll() {
        return (List<Playlist>) playlistRepository.findAll();
    }

    public List<Playlist> findAllByName(String name){
        return playlistRepository.findAllByName(name);
    }

    public List<Playlist>  findAllByUserId (UUID Id) {
        return playlistRepository.findAllByUserId(Id);
    }
}