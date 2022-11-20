package model;

import java.util.ArrayList;

public class NeoTunesController {
    private ArrayList<Audio> catalog;
    private ArrayList<Consumer> consumers;
    private ArrayList<Producers> producers;

    private ArrayList<Playlist> playlists;


    public NeoTunesController() {
        this.catalog = new ArrayList<Audio>();
        this.consumers = new ArrayList<Consumer>();
        this.producers = new ArrayList<Producers>();
        this.playlists = new ArrayList<Playlist>();
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
    public void showArtists(){
        for(int i=0; i<producers.size(); i++){
            if(producers.get(i) instanceof Artists){
                System.out.println("Name: " + ((Artists) producers.get(i)).getName());
                System.out.println("Date: " + ((Artists) producers.get(i)).getDate());
                System.out.println("URL: " + ((Artists) producers.get(i)).getURL());
            }
        }
    }
    public void showContentCreator(){
        for(int i=0; i<producers.size(); i++){
            if(producers.get(i) instanceof ContentCreators){
                System.out.println("Name: " + ((ContentCreators) producers.get(i)).getName());
                System.out.println("Date: " + ((ContentCreators) producers.get(i)).getDate());
                System.out.println("URL: " + ((ContentCreators) producers.get(i)).getURL());
            }
        }
    }
    public void registerSong(String pName, String name, String album, int genre, String URL, int seconds, int minutes, int numReproductions, double price, int numSales){
       Song newSong = new Song(null,null,new Duration(0,0),0,null,null,0,0);
        switch(genre){
            case 1:
                newSong = new Song(name, URL, new Duration(seconds, minutes), numReproductions, album, Genre.ROCK, price, numSales);
                break;
            case 2:
                newSong = new Song(name, URL, new Duration(seconds, minutes), numReproductions, album, Genre.POP, price, numSales);
                break;
            case 3:
                newSong = new Song(name, URL, new Duration(seconds, minutes), numReproductions, album, Genre.TRAP, price, numSales);
                break;
            case 4:
                newSong = new Song(name, URL, new Duration(seconds, minutes), numReproductions, album, Genre.HOUSE, price, numSales);
                break;
        }

        catalog.add(newSong);
        for(int i=0; i<producers.size(); i++){
            if(producers.get(i).getName().equals(pName)){
                if(producers.get(i) instanceof Artists){
                    ((Artists) producers.get(i)).addAudio(newSong);
                }
                break;
            }
        }
    }
    public void registerPodcast(String pName, String name, String description, int category, String URL, int seconds, int minutes, int numReproductions){
        Podcast newPodcast = new Podcast(null,null,new Duration(0,0),0,null,null);
        switch(category){
            case 1:
                newPodcast = new Podcast(name, URL, new Duration(seconds, minutes), numReproductions, Category.POLITICS, description);
                break;
            case 2:
                newPodcast = new Podcast(name, URL, new Duration(seconds, minutes), numReproductions, Category.ENTERTAINMENT, description);
                break;
            case 3:
                newPodcast = new Podcast(name, URL, new Duration(seconds, minutes), numReproductions, Category.VIDEOGAMES, description);
                break;
            case 4:
                newPodcast = new Podcast(name, URL, new Duration(seconds, minutes), numReproductions, Category.FASHION, description);
                break;
        }
        catalog.add(newPodcast);
        for(int i=0; i<producers.size(); i++){
            if(producers.get(i).getName().equals(pName)){
                if(producers.get(i) instanceof ContentCreators){
                    ((ContentCreators) producers.get(i)).addAudio(newPodcast);
                }
                break;
            }
        }
    }
    public void showCatalog(){
        for(int i=0; i<catalog.size(); i++){
            if(catalog.get(i) instanceof Song) {
                System.out.println("Name: " + (((Song) catalog.get(i)).getName()));
                System.out.println("Duration: " + ((Song) catalog.get(i)).getAlbum());
                System.out.println("Duration: " + ((Song) catalog.get(i)).getGenre());
                System.out.println("Duration: " + ((Song) catalog.get(i)).getPrice());
                System.out.println("Duration: " + ((Song) catalog.get(i)).getSales());
                System.out.println("Duration: " + ((Song) catalog.get(i)).getDuration());
                System.out.println("# of reproductions: " + ((Song) catalog.get(i)).getNumReproductions());
            }
            if(catalog.get(i) instanceof  Podcast) {
                System.out.println("Name: " + (((Podcast) catalog.get(i)).getName()));
                System.out.println("Name: " + (((Podcast) catalog.get(i)).getDescription()));
                System.out.println("Name: " + (((Podcast) catalog.get(i)).getCategory()));
                System.out.println("Name: " + (((Podcast) catalog.get(i)).getNumReproductions()));
            }
        }
    }
    public void showCatalogSongs(){
        for(int i=0; i<catalog.size(); i++){
            if(catalog.get(i) instanceof  Podcast) {
                System.out.println("Name: " + (((Podcast) catalog.get(i)).getName()));
                System.out.println("Name: " + (((Podcast) catalog.get(i)).getDescription()));
                System.out.println("Name: " + (((Podcast) catalog.get(i)).getCategory()));
                System.out.println("Name: " + (((Podcast) catalog.get(i)).getNumReproductions()));
            }
        }
    }
    public void showCatalogPodcasts(){
        for(int i=0; i<catalog.size(); i++){
            if(catalog.get(i) instanceof Song){
                System.out.println("Name: " + (((Song) catalog.get(i)).getName()));
                System.out.println("Duration: " + ((Song) catalog.get(i)).getAlbum());
                System.out.println("Duration: " + ((Song) catalog.get(i)).getGenre());
                System.out.println("Duration: " + ((Song) catalog.get(i)).getPrice());
                System.out.println("Duration: " + ((Song) catalog.get(i)).getSales());
                System.out.println("Duration: " + ((Song) catalog.get(i)).getDuration());
                System.out.println("# of reproductions: " + ((Song) catalog.get(i)).getNumReproductions());
            }
        }
    }
    public void showConsumers(){
        for(int i=0; i<consumers.size();i++){
            if(consumers.get(i) instanceof Standard){
                System.out.println("Name: " + ((Standard) consumers.get(i)).getName());
                System.out.println("Date: " + ((Standard) consumers.get(i)).getDate());
                System.out.println("Id: " + ((Standard) consumers.get(i)).getId());
            } else if (consumers.get(i) instanceof Premium) {
                System.out.println("Name: " + ((Premium) consumers.get(i)).getName());
                System.out.println("Date: " + ((Premium) consumers.get(i)).getDate());
                System.out.println("Id: " + ((Premium) consumers.get(i)).getId());
            }
        }
    }

    public void createPlaylist(int id, String name, int answer, String nameSong, String namePodcast){
        int position = 0;
        Audio SSong = null;
        Audio SPodcast = null;

        for(int i=0; i<catalog.size(); i++){
            switch(answer){
                case 1:
                    if(catalog.get(i).equals(nameSong)){
                        SSong = catalog.get(i);
                    }
                    break;
                case 2:
                    if(catalog.get(i).equals(namePodcast)){
                        SPodcast = catalog.get(i);
                    }
                    break;
                case 3:
                    if(catalog.get(i).equals(nameSong)){
                        SSong = catalog.get(i);
                    }
                    if(catalog.get(i).equals(namePodcast)){
                        SPodcast = catalog.get(i);
                    }
                    break;
            }
        }

        for(int i=0; i<consumers.size(); i++){
            if(consumers.get(i).getId()==id){
                if(consumers.get(i) instanceof Standard){
                    position = i;
                    ((Standard) consumers.get(i)).addPlaylist(name, SSong, SPodcast);
                    break;
                } else if (consumers.get(i) instanceof Premium) {
                    position = i;
                    ((Premium)  consumers.get(i)).addPlaylist(name, SSong, SPodcast);
                    break;
                }
                break;
            }
            break;
        }
        switch(answer) {
            case 1:
                if (consumers.get(position) instanceof Standard) {
                    int a = ((Standard) consumers.get(position)).getPlaylists().length;
                    for (int i = 0; i < a; i++) {
                        if (((Standard) consumers.get(position)).getPlaylists()[i] != null) {
                            if (((Standard) consumers.get(position)).getPlaylists()[i].getName().equals(name)) {
                                ((Standard) consumers.get(position)).getPlaylists()[i].setCode(SCode(position, name));
                                System.out.println(((Standard) consumers.get(position)).getPlaylists()[i].getCode());
                                break;
                            }
                        }
                    }
                } else if (consumers.get(position) instanceof Premium) {
                    int a = ((Premium) consumers.get(position)).getPlaylist().size();
                    ((Premium) consumers.get(position)).getPlaylist().get(a - 1).setCode(SCode(position, name));
                    System.out.println(((Premium) consumers.get(position)).getPlaylist().get(a - 1).getCode());
                    break;
                }
                break;
            case 2:
                if (consumers.get(position) instanceof Standard) {
                    int a = ((Standard) consumers.get(position)).getPlaylists().length;
                    for (int i = 0; i < a; i++) {
                        if (((Standard) consumers.get(position)).getPlaylists()[i] != null) {
                            if (((Standard) consumers.get(position)).getPlaylists()[i].getName().equals(name)) {
                                ((Standard) consumers.get(position)).getPlaylists()[i].setCode(PCode(position, name));
                                System.out.println(((Standard) consumers.get(position)).getPlaylists()[i].getCode());
                                break;
                            }
                        }
                    }
                } else if (consumers.get(position) instanceof Premium) {
                    int a = ((Premium) consumers.get(position)).getPlaylist().size();
                    ((Premium) consumers.get(position)).getPlaylist().get(a - 1).setCode(PCode(position, name));
                    System.out.println(((Premium) consumers.get(position)).getPlaylist().get(a - 1).getCode());
                    break;
                }
                break;
            case 3:
                if (consumers.get(position) instanceof Standard) {
                    int a = ((Standard) consumers.get(position)).getPlaylists().length;
                    for (int i = 0; i < a; i++) {
                        if (((Standard) consumers.get(position)).getPlaylists()[i] != null) {
                            if (((Standard) consumers.get(position)).getPlaylists()[i].getName().equals(name)) {
                                ((Standard) consumers.get(position)).getPlaylists()[i].setCode(SPCode(position, name));
                                System.out.println(((Standard) consumers.get(position)).getPlaylists()[i].getCode());
                                break;
                            }
                        }
                    }
                } else if (consumers.get(position) instanceof Premium) {
                    int a = ((Premium) consumers.get(position)).getPlaylist().size();
                    ((Premium) consumers.get(position)).getPlaylist().get(a - 1).setCode(SPCode(position, name));
                    System.out.println(((Premium) consumers.get(position)).getPlaylist().get(a - 1).getCode());
                    break;
                }
                break;
            default:
                break;
        }

    }
    public String SCode(int position, String name){
        String msg = "";
        if(consumers.get(position) instanceof Standard){
            for(int i = 0; i<((Standard) consumers.get(position)).getPlaylists().length; i++){
                if(((Standard) consumers.get(position)).getPlaylists()[i] != null){
                    if(((Standard) consumers.get(position)).getPlaylists()[i].getName().equals(name)){
                        int b = ((Standard) consumers.get(position)).getPlaylists()[i].getCodeMatrix().length;
                        // 6x6: length = 6 Posiciones 0 a 5
                        for (int j= b; j > 1; j--) { // Columnas

                            msg += ((Standard) consumers.get(position)).getPlaylists()[i].getCodeMatrix()[j-1][0];

                        }

                        for (int j = 0; j < b; j++) { // Columnas

                            msg += ((Standard) consumers.get(position)).getPlaylists()[i].getCodeMatrix()[j][j];
                        }

                        for (int j = b-1; j > 0; j--) { // Columnas

                            msg += ((Standard) consumers.get(position)).getPlaylists()[i].getCodeMatrix()[j-1][b-1];

                        }
                        return msg;
                    }
                }
            }

        } else if (consumers.get(position) instanceof Premium) {
            int a = ((Premium)  consumers.get(position)).getPlaylist().size();
            for(int j=0; j<a; j++){
                if (((Premium) consumers.get(position)).getPlaylist().get(j).getName().equals(name)) {
                    a = j;
                    break;
                }
            }
            int b = ((Premium)  consumers.get(position)).getPlaylist().get(a).getCodeMatrix().length;


            // 6x6: length = 6 Posiciones 0 a 5
            for (int j= b; j > 1; j--) { // Columnas

                msg += ((Standard) consumers.get(position)).getPlaylists()[a].getCodeMatrix()[j-1][0];

            }

            for (int j = 0; j < b; j++) { // Columnas

                msg += ((Standard) consumers.get(position)).getPlaylists()[a].getCodeMatrix()[j][j];
            }

            for (int j = b-1; j > 0; j--) { // Columnas

                msg += ((Standard) consumers.get(position)).getPlaylists()[a].getCodeMatrix()[j-1][b-1];

            }
            return msg;
        }
        return msg;
    }
    public String PCode(int position, String name){
        String msg = "";
        if(consumers.get(position) instanceof Standard){
            int a =((Standard) consumers.get(position)).getPlaylists().length;
            for(int i = 0; i<a; i++) {
                if(((Standard) consumers.get(position)).getPlaylists()[i] != null){
                    if (((Standard) consumers.get(position)).getPlaylists()[i].getName().equals(name)) {
                        int b = ((Standard) consumers.get(position)).getPlaylists()[i].getCodeMatrix().length;
                        for(int j=0; j<(b-b/2);j++){
                            msg += ((Standard) consumers.get(position)).getPlaylists()[i].getCodeMatrix()[0][j];
                        }
                        for(int j=1; j<b-1; j++){
                            msg += ((Standard) consumers.get(position)).getPlaylists()[i].getCodeMatrix()[j][2];
                        }
                        for(int j=2; j<b-2; j++){
                            msg += ((Standard) consumers.get(position)).getPlaylists()[i].getCodeMatrix()[5][j];
                        }
                        for(int j=4; j>0; j--){
                            msg += ((Standard) consumers.get(position)).getPlaylists()[i].getCodeMatrix()[j][3];
                        }
                        for(int j=3; j<b; j++){
                            msg += ((Standard) consumers.get(position)).getPlaylists()[i].getCodeMatrix()[0][j];
                        }
                        return msg;
                    }
                }
            }
        } else if (consumers.get(position) instanceof Premium) {
            int a = ((Premium)  consumers.get(position)).getPlaylist().size();
            for(int j=0; j<a; j++){
                if(((Premium)  consumers.get(position)).getPlaylist().get(j) != null){
                    if(((Premium)  consumers.get(position)).getPlaylist().get(j).getName().equals(name)){
                        a = j;
                        break;
                    }
                }
            }
            int b = ((Premium)  consumers.get(position)).getPlaylist().get(a).getCodeMatrix().length;
            for(int j=0; j<(b-b/2);j++){
                msg += ((Premium) consumers.get(position)).getPlaylist().get(a).getCodeMatrix()[0][j];
            }
            for(int j=1; j<b-1; j++){
                msg += ((Premium) consumers.get(position)).getPlaylist().get(a).getCodeMatrix()[j][2];
            }
            for(int j=2; j<b-2; j++){
                msg += ((Premium) consumers.get(position)).getPlaylist().get(a).getCodeMatrix()[5][j];
            }
            for(int j=4; j>0; j--){
                msg += ((Premium) consumers.get(position)).getPlaylist().get(a).getCodeMatrix()[j][3];
            }
            for(int j=3; j<b; j++){
                msg += ((Premium) consumers.get(position)).getPlaylist().get(a).getCodeMatrix()[0][j];
            }
            return msg;
        }
        return msg;
    }
    public String SPCode(int position, String name){
            String msg = "";
            if(consumers.get(position) instanceof Standard){
                int a =((Standard) consumers.get(position)).getPlaylists().length;
                for(int i = 0; i<a; i++) {
                    if(((Standard) consumers.get(position)).getPlaylists()[i] != null){
                        if (((Standard) consumers.get(position)).getPlaylists()[i].getName().equals(name)) {
                            for(int j=5; j>2; j=j-2){
                                msg += ((Standard) consumers.get(position)).getPlaylists()[i].getCodeMatrix()[0][j];
                            }
                            for(int j=4; j>1; j=j-2){
                                msg += ((Standard) consumers.get(position)).getPlaylists()[i].getCodeMatrix()[1][j];
                            }
                            for(int j=5; j>0; j=j-2){
                                msg += ((Standard) consumers.get(position)).getPlaylists()[i].getCodeMatrix()[2][j];
                            }
                            for(int j=4; j>=0; j=j-2){
                                msg += ((Standard) consumers.get(position)).getPlaylists()[i].getCodeMatrix()[3][j];
                            }
                            for(int j=5; j>0; j=j-2){
                                msg += ((Standard) consumers.get(position)).getPlaylists()[i].getCodeMatrix()[4][j];
                            }
                            for(int j=4; j>=0; j=j-2){
                                msg += ((Standard) consumers.get(position)).getPlaylists()[i].getCodeMatrix()[5][j];
                            }
                            return msg;
                        }
                    }
                }

            } else if (consumers.get(position) instanceof Premium) {
                int a = ((Premium)  consumers.get(position)).getPlaylist().size();
                for(int j=0; j<a; j++){
                    if(((Premium)  consumers.get(position)).getPlaylist().get(j).getName().equals(name)){
                        a = j;
                        break;
                    }
                }
                int b = ((Premium)  consumers.get(position)).getPlaylist().get(a).getCodeMatrix().length;
                for(int j=5; j>2; j=j-2){
                    msg += ((Premium) consumers.get(position)).getPlaylist().get(a).getCodeMatrix()[0][j];
                }
                for(int j=4; j>1; j=j-2){
                    msg += ((Premium) consumers.get(position)).getPlaylist().get(a).getCodeMatrix()[1][j];
                }
                for(int j=5; j>0; j=j-2){
                    msg += ((Premium) consumers.get(position)).getPlaylist().get(a).getCodeMatrix()[2][j];
                }
                for(int j=4; j>=0; j=j-2){
                    msg += ((Premium) consumers.get(position)).getPlaylist().get(a).getCodeMatrix()[3][j];
                }
                for(int j=5; j>0; j=j-2){
                    msg += ((Premium) consumers.get(position)).getPlaylist().get(a).getCodeMatrix()[4][j];
                }
                for(int j=4; j>=0; j=j-2){
                    msg += ((Premium) consumers.get(position)).getPlaylist().get(a).getCodeMatrix()[5][j];
                }
                return msg;
            }
         return msg;
    }
    public void showPlaylists(int id){
        for(int i=0; i<consumers.size();i++){
            if(consumers.get(i).getId()==id){
                if(consumers.get(i) instanceof Standard){
                    System.out.println(((Standard) consumers.get(i)).getPlaylists());
                    break;
                } else if (consumers.get(i) instanceof Premium) {
                    System.out.println(((Premium) consumers.get(i)).getPlaylist());
                    break;
                }
            }
        }
    }
    public void showPlaylistsAudio(int id, String namePlaylist){
        for(int i=0; i<consumers.size();i++){
            if(consumers.get(i).getId()==id){
                if(consumers.get(i) instanceof Standard){
                    for(int j=0; j<((Standard) consumers.get(i)).getPlaylists().length; j++){
                        if(((Standard) consumers.get(i)).getPlaylists()[j].getName().equals(namePlaylist)){
                            System.out.println(((Standard) consumers.get(i)).getPlaylists()[j].getAudioList());
                            break;
                        }
                    }
                } else if (consumers.get(i) instanceof Premium) {
                    for(int j=0; j<((Standard) consumers.get(i)).getPlaylists().length; j++){
                        if(((Standard) consumers.get(i)).getPlaylists()[j].getName().equals(namePlaylist)){
                            System.out.println(((Premium) consumers.get(i)).getPlaylist().get(j).getAudioList());
                            break;
                        }
                    }
                }
            }
        }
    }

    public void editPlaylist(int id, String namePlaylist, int answer, String newName, String newSong, String newPodcast, String remSong, String remPodcast){
       int position = 0;
       int Pposition = 0;
       Audio song = null;
       Audio podcast = null;
        for(int i=0; i<consumers.size();i++){
            if(consumers.get(i).getId()==id){
                position = i;
                if(consumers.get(i) instanceof Standard){
                    for(int j=0; j<((Standard) consumers.get(i)).getPlaylists().length; j++){
                        if(((Standard) consumers.get(i)).getPlaylists()[j].getName().equals(namePlaylist)){
                            Pposition = j;
                        }
                    }
                } else if (consumers.get(i) instanceof Premium) {
                    for(int j=0; j<((Premium) consumers.get(i)).getPlaylist().size(); j++){
                        if(((Premium) consumers.get(i)).getPlaylist().get(j).getName().equals(namePlaylist)){
                            Pposition = j;
                        }
                    }
                }
                break;
            }
        }


        switch(answer) {
            case 1:
                if (consumers.get(position) instanceof Standard) {
                    if(((Standard) consumers.get(position)).getPlaylists()[Pposition] != null){
                        ((Standard) consumers.get(position)).getPlaylists()[Pposition].setName(newName);
                        break;
                    }
                    break;
                } else if (consumers.get(position) instanceof Premium) {
                    if(((Premium) consumers.get(position)).getPlaylist().get(Pposition)!= null){
                        ((Premium) consumers.get(position)).getPlaylist().get(Pposition).setName(newName);
                        break;
                    }
                    break;
                }
                break;
            case 2:
                if (consumers.get(position) instanceof Standard) {
                    for (int i = 0; i < catalog.size(); i++) {
                        if (catalog.get(i).getName().equals(newSong)) {
                            ((Standard) consumers.get(position)).getPlaylists()[Pposition].addAudio(catalog.get(i), podcast);
                            break;
                        }
                    }
                } else if (consumers.get(position) instanceof Premium) {
                    for (int i = 0; i < catalog.size(); i++) {
                        if (catalog.get(i).getName().equals(newSong)) {
                            ((Premium) consumers.get(position)).getPlaylist().get(Pposition).addAudio(catalog.get(i), podcast);
                            break;
                        }
                    }
                }
                break;
            case 3:
                if (consumers.get(position) instanceof Standard) {
                    for (int i = 0; i < catalog.size(); i++) {
                        if (catalog.get(i).getName().equals(newPodcast)) {
                            ((Standard) consumers.get(position)).getPlaylists()[Pposition].addAudio(song, catalog.get(i));
                            break;
                        }
                    }
                } else if (consumers.get(position) instanceof Premium) {
                    for (int i = 0; i < catalog.size(); i++) {
                        if (catalog.get(i).getName().equals(newPodcast)) {
                            ((Premium) consumers.get(position)).getPlaylist().get(Pposition).addAudio(song, catalog.get(i));
                            break;
                        }
                    }
                }
                break;
            case 4:
                if (consumers.get(position) instanceof Standard) {
                    for (int i = 0; i < catalog.size(); i++) {
                        if (catalog.get(i).getName().equals(remSong)) {
                            ((Standard) consumers.get(position)).getPlaylists()[Pposition].remAudio(catalog.get(i), podcast);
                            break;
                        }
                    }
                } else if (consumers.get(position) instanceof Premium) {
                    for (int i = 0; i < catalog.size(); i++) {
                        if (catalog.get(i).getName().equals(remSong)) {
                            ((Premium) consumers.get(position)).getPlaylist().get(Pposition).remAudio(catalog.get(i), podcast);
                            break;
                        }
                    }
                }
                break;
            case 5:
                if (consumers.get(position) instanceof Standard) {
                    for (int i = 0; i < catalog.size(); i++) {
                        if (catalog.get(i).getName().equals(remPodcast)) {
                            ((Standard) consumers.get(position)).getPlaylists()[Pposition].remAudio(song, catalog.get(i));
                            break;
                        }
                    }
                } else if (consumers.get(position) instanceof Premium) {
                    for (int i = 0; i < catalog.size(); i++) {
                        if (catalog.get(i).getName().equals(remPodcast)) {
                            ((Premium) consumers.get(position)).getPlaylist().get(Pposition).remAudio(song, catalog.get(i));
                            break;
                        }
                    }
                }
                break;
        }
    }

    public void sharePlaylist(int id, String code){
        Playlist sharedPlaylist = null;
        String Scode = "0";
        String Pcode = "0";
        String SPcode = "0";
        int codeA = 0;
        String name = "";
        for(int i=0; i<consumers.size();i++){
            if(consumers.get(i) instanceof Standard){
                for(int j=0;j<((Standard) consumers.get(i)).getPlaylists().length; j++){
                    if(((Standard) consumers.get(i)).getPlaylists()[j].getCode().equals(code)){
                        sharedPlaylist = ((Standard) consumers.get(i)).getPlaylists()[j];
                        name = ((Standard) consumers.get(i)).getPlaylists()[j].getName();
                        Scode = SCode(i,name);
                        Pcode = PCode(i,name);
                        SPcode = SPCode(i,name);
                        if(((Standard) consumers.get(i)).getPlaylists()[j].getCode().equals(Scode)){
                            codeA = 1;
                        } else if (((Standard) consumers.get(i)).getPlaylists()[j].getCode().equals(Pcode)){
                            codeA = 2;
                        } else if (((Standard) consumers.get(i)).getPlaylists()[j].getCode().equals(SPcode)) {
                            codeA = 3;
                        }
                        break;
                    }
                }
            } else if (consumers.get(i) instanceof Premium) {
                for(int j=0;j<((Premium) consumers.get(i)).getPlaylist().size(); j++){
                    if(((Premium) consumers.get(i)).getPlaylist().get(j).getCode()==code){
                        sharedPlaylist = ((Premium) consumers.get(i)).getPlaylist().get(j);
                        name = ((Premium) consumers.get(i)).getPlaylist().get(j).getName();
                        Scode = SCode(i,name);
                        Pcode = PCode(i,name);
                        SPcode = SPCode(i,name);
                        if(((Standard) consumers.get(i)).getPlaylists()[j].getCode()==Scode){
                            codeA = 1;
                        } else if (((Standard) consumers.get(i)).getPlaylists()[j].getCode()==Pcode){
                            codeA = 2;
                        } else if (((Standard) consumers.get(i)).getPlaylists()[j].getCode()==SPcode) {
                            codeA = 3;
                        }
                        break;
                    }
                }
            }
        }
        for(int i=0; i<consumers.size(); i++){
            if(consumers.get(i).getId()==id){
                if(consumers.get(i) instanceof Standard){
                    ((Standard) consumers.get(i)).sharedPlaylist(sharedPlaylist);
                    switch (codeA){
                        case 1:
                            code = SCode(i, sharedPlaylist.getName());
                            for(int j=0; j<((Standard) consumers.get(i)).getPlaylists().length; j++){
                                ((Standard) consumers.get(i)).getPlaylists()[j].setCode(code);
                                break;
                            }
                            break;
                        case 2:
                            code = PCode(i, sharedPlaylist.getName());
                            for(int j=0; j<((Standard) consumers.get(i)).getPlaylists().length; j++){
                                ((Standard) consumers.get(i)).getPlaylists()[j].setCode(code);
                                break;
                            }
                            break;
                        case 3:
                            code = SPCode(i, sharedPlaylist.getName());
                            for(int j=0; j<((Standard) consumers.get(i)).getPlaylists().length; j++){
                                ((Standard) consumers.get(i)).getPlaylists()[j].setCode(code);
                                break;
                            }
                            break;
                    }
                } else if (consumers.get(i) instanceof  Premium) {
                    ((Premium) consumers.get(i)).sharedPlaylist(sharedPlaylist);
                    switch (codeA){
                        case 1:
                            code = SCode(i, sharedPlaylist.getName());
                            for(int j=0; j<((Premium) consumers.get(i)).getPlaylist().size(); j++){
                                ((Premium) consumers.get(i)).getPlaylist().get(j).setCode(code);
                                break;
                            }
                            break;
                        case 2:
                            code = PCode(i, sharedPlaylist.getName());
                            for(int j=0; j<((Premium) consumers.get(i)).getPlaylist().size(); j++){
                                ((Premium) consumers.get(i)).getPlaylist().get(j).setCode(code);
                                break;
                            }
                            break;
                        case 3:
                            code = SPCode(i, sharedPlaylist.getName());
                            for(int j=0; j<((Premium) consumers.get(i)).getPlaylist().size(); j++){
                                ((Premium) consumers.get(i)).getPlaylist().get(j).setCode(code);
                                break;
                            }
                            break;
                    }
                }
            }
        }
    }

    public void repAudio(int id, String namePlaylist, String nameSong){
        for(int i=0; i<consumers.size();i++){
            if(consumers.get(i).getId()==id){
                if(consumers.get(i) instanceof Standard){
                    ((Standard) consumers.get(i)).reproduceAudio(namePlaylist, nameSong);
                    break;
                } else if (consumers.get(i) instanceof Premium) {
                    ((Premium) consumers.get(i)).reproduceAudio(namePlaylist, nameSong);
                }
            }
        }
    }
    public void buySong(int id, String nameSong){

    }
}
