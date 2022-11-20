package model;

import java.util.ArrayList;
import java.util.Arrays;

public class Premium extends Consumer implements ReproduceAudio{
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
    public void addPlaylist(String name, Audio Song, Audio Podcast) {
        Playlist newPlaylist = new Playlist(name, " ", 0);
        playlist.add(newPlaylist);
        for(int i=0; i<playlist.size(); i++){
            if(playlist.get(i).getName().equals(name)) {
                playlist.get(i).createMatrix();
                playlist.get(i).addAudio(Song, Podcast);
                break;
            }
            break;
        }

    }
    public void sharedPlaylist(Playlist newPlaylist){
        playlist.add(newPlaylist);
        newPlaylist.createMatrix();
    }

    @Override
    public void reproduceAudio(String playlistName, String songName) {
        for(int i=0; i<playlist.size(); i++){
            if(playlist.isEmpty()){
                if(playlist.get(i).getName().equals(playlistName)){
                    for (int j=0; j<playlist.get(i).getAudioList().size(); j++){
                        if(playlist.get(i).getAudioList().isEmpty()){
                            if(playlist.get(i).getAudioList().get(j).getName().equals(songName)){
                                System.out.println(playlist.get(i).getName());
                                System.out.println("|| ----------* "+ playlist.get(i).getAudioList().get(j).getDuration());
                                playlist.get(i).getAudioList().get(j).setNumReproductions(playlist.get(i).getAudioList().get(j).getNumReproductions()+1);
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
        return "Premium{" +
                "songs=" + songs +
                ", playlist=" + playlist +
                '}';
    }

}
