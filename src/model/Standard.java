package model;
import java.util.Arrays;

public class Standard extends Consumer{
    private Song[] songs;
    private Playlist[] playlists;
    public Standard(String name, Date date, int id) {
        super(name, date, id);
        songs = new Song[100];
        playlists = new Playlist[20];
    }

    public Song[] getSongs() {
        return songs;
    }

    public void setSongs(Song[] songs) {
        this.songs = songs;
    }

    public Playlist[] getPlaylists() {
        return playlists;
    }

    public void setPlaylists(Playlist[] playlists) {
        this.playlists = playlists;
    }

    @Override
    public String toString() {
        return "Standard{" +
                "songs=" + Arrays.toString(songs) +
                ", playlists=" + Arrays.toString(playlists) +
                '}';
    }
}
