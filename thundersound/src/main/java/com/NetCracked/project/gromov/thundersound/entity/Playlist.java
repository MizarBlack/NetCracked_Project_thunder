package com.NetCracked.project.gromov.thundersound.entity;

import javax.persistence.*;

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

    public Playlist(String name){
        this.name = name;
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
