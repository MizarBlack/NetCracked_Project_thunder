package com.NetCracked.project.gromov.thundersound.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;
    private UUID genre_id;
    private String name;
    private String description;

    public Author(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public Author() {
    }

    public UUID getGenre_id() {
        return genre_id;
    }
    public void setGenre_id(UUID genre_id) {
        this.genre_id = genre_id;
    }
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
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
