package com.NetCracked.project.gromov.thundersound.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "track")
public class Track {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @Column(name = "genre_id")
    private int genre_id;
    @Column(name = "name")
    private String name;
    @Column(name = "text")
    private String text;
    @Column(name = "file_name")
    private String file_name;
    @Column(name = "data_load")
    private LocalDate data_load;
    @Column(name = "duration")
    private LocalTime duration;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "track-album",
            joinColumns = @JoinColumn(name = "album_id"),
            inverseJoinColumns = @JoinColumn(name = "track_id")
    )
    private Set<Track> track_Album;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "track-author",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "track_id")
    )
    private Set<Track> track_Author;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "track-playlist",
            joinColumns = @JoinColumn(name = "playlist_id"),
            inverseJoinColumns = @JoinColumn(name = "track_id")
    )
    private Set<Track> track_Playlist;

    public Set<Track> getTrack_Album() {
        return track_Album;
    }
    public void setTrack_Album(Set<Track> track_Album) {
        this.track_Album = track_Album;
    }

    public Set<Track> getTrack_Author() {
        return track_Author;
    }
    public void setTrack_Author(Set<Track> track_Author) {
        this.track_Author = track_Author;
    }

    public Set<Track> getTrack_Playlist() {
        return track_Playlist;
    }
    public void setTrack_Playlist(Set<Track> track_Playlist) {
        this.track_Playlist = track_Playlist;
    }

    public Track(String name, String text, String file_name, LocalDate data_load, LocalTime duration, int genre_id) {
        this.name = name;
        this.text = text;
        this.file_name = file_name;
        this.data_load = data_load;
        this.duration = duration;
        this.genre_id = genre_id;
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
