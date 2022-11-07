package model;

import java.util.ArrayList;
import java.util.Arrays;

public class Premium extends Consumer{
    private ArrayList<Song> songs;
    private ArrayList<Playlist> playlist;

    public Premium(String name, Date date, int id) {
        super(name, date, id);
        this.songs = new ArrayList<Song>();
        this.playlist = new ArrayList<Playlist>();
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }

    public ArrayList<Playlist> getPlaylist() {
        return playlist;
    }

    public void setPlaylist(ArrayList<Playlist> playlist) {
        this.playlist = playlist;
    }
    public void addPlaylist(){

    }

    @Override
    public String toString() {
        return "Premium{" +
                "songs=" + songs +
                ", playlist=" + playlist +
                '}';
    }
}
