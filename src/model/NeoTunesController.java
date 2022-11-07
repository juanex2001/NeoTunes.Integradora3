package model;

import java.util.ArrayList;

public class NeoTunesController {
    private ArrayList<Audio> catalog;
    private ArrayList<Consumer> consumers;
    private ArrayList<Producers> producers;

    private ArrayList<Playlist> playlists;


    public NeoTunesController() {
        this.catalog = new ArrayList<Audio>();
    }

    public void registerConsumer(String name, int day, int month, int year, int id, int type){
        switch(type){
            case 1:
                Standard newStandard = new Standard(name, new Date(day,month,year), id);
                consumers.add(newStandard);
                break;
            case 2:
                Premium newPremium = new Premium(name, new Date(day,month,year), id);
                consumers.add(newPremium);
                break;
        }
    }
    public void registerProducer(String name, int day, int month, int year, String URL, int type){
        switch(type){
            case 1:
                Artists newArtists = new Artists(name, new Date(day,month,year), URL);
                producers.add(newArtists);
                break;
            case 2:
                ContentCreators newContentCreators = new ContentCreators(name, new Date(day,month,year), URL);
                producers.add(newContentCreators);
                break;
        }
    }
    public void registerSong(String name, String album, int genre, String URL, int duration, int numReproductions, double price, int numSales){
       Song newSong = new Song(null,null,0,0,null,null,0,0);
        switch(genre){
            case 1:
                newSong = new Song(name, URL, duration, numReproductions, album, Genre.ROCK, price, numSales);
                break;
            case 2:
                newSong = new Song(name, URL, duration, numReproductions, album, Genre.POP, price, numSales);
                break;
            case 3:
                newSong = new Song(name, URL, duration, numReproductions, album, Genre.TRAP, price, numSales);
                break;
            case 4:
                newSong = new Song(name, URL, duration, numReproductions, album, Genre.HOUSE, price, numSales);
                break;
        }

        catalog.add(newSong);
    }
    public void registerPodcast(String name, String description, int category, String URL, int duration, int numReproductions){
        Podcast newPodcast = new Podcast(null,null,0,0,null,null);
        switch(category){
            case 1:
                newPodcast = new Podcast(name, URL, duration, numReproductions, Category.POLITICS, description);
                break;
            case 2:
                newPodcast = new Podcast(name, URL, duration, numReproductions, Category.ENTERTAINMENT, description);
                break;
            case 3:
                newPodcast = new Podcast(name, URL, duration, numReproductions, Category.VIDEOGAMES, description);
                break;
            case 4:
                newPodcast = new Podcast(name, URL, duration, numReproductions, Category.FASHION, description);
                break;
        }
        catalog.add(newPodcast);
    }
    public void showCatalog(){
        for(int i=0; i<catalog.size(); i++){
            if(catalog.isEmpty()){
                System.out.println(catalog.get(i));
            }
        }
    }

    public void createPlaylist(int id, String name, String nameSong, String namePodcast){
        int position;

        if(nameSong!=null & namePodcast!=null){
            int code = SPCode();
        } else if (nameSong!=null & namePodcast==null) {
            int code = SCode();
        } else if (namePodcast!=null & nameSong==null) {
            int code = PCode();
        }
        for(int i=0; i<consumers.size(); i++){
            if(consumers.isEmpty()){
                if(consumers.get(i) instanceof Standard){
                    if(consumers.get(i).getId()==id){

                    }
                } else if (consumers.get(i) instanceof Premium) {
                    if(consumers.get(i).getId()==id){

                    }
                }
            }
        }
    }
    public int SCode(){

        return SCode;
    }
    public int PCode(){

        return PCode;
    }
    public int SPCode(){

        return SPCode;
    }

}
