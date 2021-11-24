package com.NetCracked.project.gromov.thundersound.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "track")
public class Track {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private int genre_id;
    private String name;
    private String text;
    private String file_name;
    private LocalDate data_load;
    private LocalTime duration;

    public Track(String name, String text, String file_name, LocalDate data_load, LocalTime duration) {
        this.name = name;
        this.text = text;
        this.file_name = file_name;
        this.data_load = data_load;
        this.duration = duration;
    }
    public Track() {
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
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public String getFile_name() {
        return file_name;
    }
    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }
    public LocalDate getData_load() {
        return data_load;
    }
    public void setData_load(LocalDate data_load) {
        this.data_load = data_load;
    }
    public LocalTime getDuration() {
        return duration;
    }
    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }

}
