package com.NetCracked.project.gromov.thundersound.service;

import com.NetCracked.project.gromov.thundersound.entity.Album;
import com.NetCracked.project.gromov.thundersound.repository.AlbumRepository;
import com.NetCracked.project.gromov.thundersound.serviceInterface.AlbumServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlbumService implements AlbumServiceInterface {

    private final AlbumRepository albumRepository;

    @Autowired
    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public ResponseEntity<Album> saveAlbum(@RequestParam Album album) {
        try {
            Album newAlbum = albumRepository
                    .save(new Album(album.getName(), album.getDescription(), album.getRealise_data()));
            return new ResponseEntity<>(newAlbum, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<Album>> findAll(String name) {
        try {
            List<Album> albums = new ArrayList<Album>();

            if (name == null)
                albumRepository.findAll().forEach(albums::add);
            else
                albumRepository.findAllByNameContaining(name).forEach(albums::add);

            if (albums.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(albums, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Album> findById(int Id) {
        Optional<Album> album = albumRepository.findById(Id);

        if (album.isPresent()) {
            return new ResponseEntity<>(album.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<HttpStatus> deleteById(int Id) {
        try {
            albumRepository.deleteById(Id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
   }

    @Override
    public ResponseEntity<Album> updateAlbum(int id, Album album) {
        Optional<Album> albumBD = albumRepository.findById(id);

        if (albumBD.isPresent()) {
            Album _album = albumBD.get();
            _album.setName(album.getName());
            _album.setDescription(album.getDescription());
            _album.setRealise_data(album.getRealise_data());
            return new ResponseEntity<>(albumRepository.save(_album), HttpStatus.OK);
        } else {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
