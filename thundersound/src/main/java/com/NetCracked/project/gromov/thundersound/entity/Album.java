package com.NetCracked.project.gromov.thundersound.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;
    private String name;
    private String description;
    private LocalDate realise_data;

    public Album(String name, String description, LocalDate realise_data) {
        this.name = name;
        this.description = description;
        this.realise_data = realise_data;
    }

    public Album() {

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
    public LocalDate getRealise_data() {
        return realise_data;
    }
    public void setRealise_data(LocalDate realise_data) {
        this.realise_data = realise_data;
    }
    
}