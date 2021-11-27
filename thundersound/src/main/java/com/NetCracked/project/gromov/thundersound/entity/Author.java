package com.NetCracked.project.gromov.thundersound.entity;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @Column(name = "genre_id")
    private int genre_id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "track-author")
    private List<Track> track_Author;

    public List<Track> getTrack_Author() {
        return track_Author;
    }

    public void setTrack_Author(List<Track> track) {
        this.track_Author = track;
    }

    public Author(String name, String description, int genre_id) {
        this.name = name;
        this.description = description;
        this.genre_id = genre_id;
    }
    public Author() {
    }

    public int getGenre_id() {
        return genre_id;
    }
    public void setGenre_id(int genre_id) {
        this.genre_id = genre_id;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }


}
