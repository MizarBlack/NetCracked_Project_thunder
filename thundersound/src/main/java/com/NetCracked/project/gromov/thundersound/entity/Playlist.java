package com.NetCracked.project.gromov.thundersound.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "playlist")
public class Playlist {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @Column(name = "user_id")
    private int user_id;
    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "track-playlist")
    private List<Track> track_Playlist;

    public List<Track> getTrack_Playlist() {
        return track_Playlist;
    }

    public void setTrack_Playlist(List<Track> track) {
        this.track_Playlist = track;
    }

    public Playlist(String name, int user_id){
        this.name = name;
        this.user_id = user_id;
    }
    public Playlist(){

    }

    public int getUser_id() {
        return user_id;
    }
    public void setUser_id(int id){
        this.user_id = id;
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


}
