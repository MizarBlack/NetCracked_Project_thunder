package com.NetCracked.project.gromov.thundersound.service;

import com.NetCracked.project.gromov.thundersound.entity.Album;
import com.NetCracked.project.gromov.thundersound.entity.Playlist;
import com.NetCracked.project.gromov.thundersound.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class AlbumService {

    @Autowired
    private final AlbumRepository albumRepository;

    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public void Album(Album album) {
        albumRepository.save(album);
    }

    public List<Album> findAll() {
        return (List<Album>) albumRepository.findAll();
    }

    public List<Album>  findAllById (UUID Id) {
        return albumRepository.findAllById(Id);
    }

    public List<Album> findAllByName(String name){
        return albumRepository.findAllByName(name);
    }

    public List<Album> findAllByRealise_data(LocalDate realise_data){
        return albumRepository.findAllByRealise_data(realise_data);
    }
}
