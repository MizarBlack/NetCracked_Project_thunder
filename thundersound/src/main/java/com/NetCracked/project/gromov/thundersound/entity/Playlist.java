package com.NetCracked.project.gromov.thundersound.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "playlist")
public class Playlist {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(name = "user_id", insertable=false, updatable = false)
    private int user_id;
    @Column(name = "name")
    private String name;

    @ManyToOne (fetch = FetchType.EAGER, optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="user_id")
    private User user;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "playlist")
    private List<Track> track;
    public List<Track> getTrack() {
        return track;
    }
    public void setTrack(List<Track> track) {
        this.track = track;
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
