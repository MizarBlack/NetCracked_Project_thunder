package com.NetCracked.project.gromov.thundersound.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "album")
public class Album {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "release_date")
    private String release_date;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "album")
    private List<Track> tracks;
    public List<Track> getTracks() {
        return tracks;
    }
    public void setTracks(List<Track> track) {
        this.tracks = track;
    }

    public Album(String name, String description, String realise_data) {
        this.name = name;
        this.description = description;
        this.release_date = realise_data;
    }

    public Album() {

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
    public String getRealise_data() {
        return release_date;
    }
    public void setRealise_data(String realise_data) {
        this.release_date = realise_data;
    }




    @Override
    public String toString() {
        return "Album[" +
                "id=" + id +
                ", name='" + name +
                ", description='" + description +
                ", release_date=" + release_date +
                ']';
    }
}