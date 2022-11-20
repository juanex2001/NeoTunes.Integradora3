package model;
import java.util.Arrays;

public class Standard extends Consumer implements ReproduceAudio {
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

    public void addPlaylist(String name, Audio Song, Audio Podcast) {
        Playlist newPlaylist = new Playlist(name, null, 0);
        for (int i = 0; i < playlists.length; i++) {
            if (playlists[i] == null) {
                playlists[i] = newPlaylist;
                break;
            }
        }
        for (int i = 0; i < playlists.length; i++) {
            if (playlists != null) {
                if (playlists[i] == newPlaylist) {
                    playlists[i].createMatrix();
                    playlists[i].addAudio(Song, Podcast);
                    break;
                }
            }
        }
    }

    public void sharedPlaylist(Playlist newPlaylist) {
        for (int i = 0; i < playlists.length; i++) {
            if (playlists[i] == null) {
                playlists[i] = newPlaylist;
                break;
            }
        }
    }

    @Override
    public void reproduceAudio(String playlistName, String songName) {
        for(int i=0; i<playlists.length; i++){
            if(playlists != null){
                if(playlists[i].getName().equals(playlistName)){
                    for (int j=0; j<playlists[i].getAudioList().size(); j++){
                        if(playlists[i].getAudioList()!=null){
                            if(playlists[i].getAudioList().get(j).getName().equals(songName)){
                                System.out.println(playlists[i].getName());
                                System.out.println("|| ----------* "+ playlists[i].getAudioList().get(j).getDuration());
                                playlists[i].getAudioList().get(j).setNumReproductions(playlists[i].getAudioList().get(j).getNumReproductions()+1);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Standard{" +
                "songs=" + Arrays.toString(songs) +
                ", playlists=" + Arrays.toString(playlists) +
                '}';
    }
}

