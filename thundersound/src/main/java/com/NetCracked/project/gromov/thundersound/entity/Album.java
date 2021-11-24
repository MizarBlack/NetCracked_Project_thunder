package com.NetCracked.project.gromov.thundersound.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "album")
public class Album {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "release_date")
    private LocalDate release_date;

    public Album(String name, String description, LocalDate realise_data) {
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
    public LocalDate getRealise_data() {
        return release_date;
    }
    public void setRealise_data(LocalDate realise_data) {
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