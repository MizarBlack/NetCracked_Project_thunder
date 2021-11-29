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
    @Column(name = "genre_id", insertable=false, updatable = false)
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
    @JoinTable(name = "track_album",
            joinColumns = @JoinColumn(name = "track_id"),
            inverseJoinColumns = @JoinColumn(name = "album_id")
    )
    private Set<Album> album;
    public Set<Album> getAlbums() {
        return album;
    }
    public void setAlbum(Set<Album> album) {
        this.album = album;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "track_author",
            joinColumns = @JoinColumn(name = "track_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<Author> author;
    public Set<Author> getAuthor() {
        return author;
    }
    public void setAuthor(Set<Author> author) {
        this.author = author;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "track_playlist",
            joinColumns = @JoinColumn(name = "track_id"),
            inverseJoinColumns = @JoinColumn(name = "playlist_id")
    )
    private Set<Playlist> playlist;
    public Set<Playlist> getPlaylist() {
        return playlist;
    }
    public void setPlaylist(Set<Playlist> playlist) {
        this.playlist = playlist;
    }

    @ManyToOne (fetch = FetchType.EAGER, optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="genre_id")
    private Genre genre;

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
