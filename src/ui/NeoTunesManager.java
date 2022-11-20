package ui;
import java.util.Scanner;


import model.Duration;
import model.NeoTunesController;

public class NeoTunesManager {
    private Scanner sc;
    public NeoTunesController controller;

    public NeoTunesManager(){
        super();
        this.sc = new Scanner(System.in);
        this.controller = new NeoTunesController();
    }
    public static void main(String[] args){
        NeoTunesManager m = new NeoTunesManager();
        m.menu();
    }

    public void menu(){
        System.out.println("Welcome to Neo Tunes");
        boolean exit = false;
        while(exit!=true){

            System.out.println("1, Register Consumer");
            System.out.println("2, Register Producer");
            System.out.println("3, Register Audio");
            System.out.println("4, Create Playlist");
            System.out.println("5, Edit Playlist");
            System.out.println("6, Share Playlist");
            System.out.println("7, Reproduce Audio");
            System.out.println("8, Buy Song");
            System.out.println("9, Show Reports");
            int option = sc.nextInt();

            switch(option){
                case 1:
                    registerConsumer();
                    break;
                case 2:
                    registerProducer();
                    break;
                case 3:
                    registerAudio();
                    break;
                case 4:
                    createPlaylist();
                    break;
                case 5:
                    editPlaylist();
                    break;
                case 6:
                    sharePlaylist();
                    break;
                case 7:
                    reproduceAudio();
                    break;
                case 8:
                    buySong();
                    break;
                case 9:
                    showReports();
                    break;
                default:
                    System.out.println("");
                    break;
            }
        }
    }
    public void registerConsumer(){
        System.out.println("Name");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.println("Date:");
        System.out.println("Day");
        int day = sc.nextInt();
        System.out.println("Month");
        int month = sc.nextInt();
        System.out.println("Year");
        int year = sc.nextInt();
        System.out.println("Id");
        int id = sc.nextInt();
        System.out.println("Type");
        System.out.println("(1) Standard");
        System.out.println("(2) Premium");
        int type = sc.nextInt();

        controller.registerConsumer(name,day,month,year,id,type);

    }
    public void registerProducer(){
        System.out.println("Name");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.println("Date:");
        System.out.println("Day");
        int day = sc.nextInt();
        System.out.println("Month");
        int month = sc.nextInt();
        System.out.println("Year");
        int year = sc.nextInt();
        System.out.println("URL");
        sc.nextLine();
        String URL = sc.nextLine();
        System.out.println("Type");
        System.out.println("(1) Artist");
        System.out.println("(2) Content Creator");
        int type = sc.nextInt();

        controller.registerProducer(name,day,month,year,URL,type);

    }
    public void registerAudio(){
        System.out.println("Type of producer");
        System.out.println("(1) Artist");
        System.out.println("(2) Content Creator");
        int answer = sc.nextInt();
        String pName = "";
        int type=0;
        switch (answer){
            case 1:
                controller.showArtists();
                System.out.println("What Artist");
                sc.nextLine();
                pName = sc.nextLine();
                type = 1;
                break;
            case 2:
                controller.showContentCreator();
                System.out.println("What Content Creator");
                sc.nextLine();
                pName = sc.nextLine();
                type = 2;
                break;

        }


        String name;
        String URL;
        int numReproductions;
        int seconds;
        int minutes;

        switch(type){
            case 1:
                System.out.println("Song info:");
                System.out.println("Name");
                name = sc.nextLine();
                System.out.println("Album");
                String album = sc.nextLine();
                System.out.println("Genre");
                System.out.println("(1) Rock");
                System.out.println("(2) Pop");
                System.out.println("(3) Trap");
                System.out.println("(4) House");
                int genre = sc.nextInt();
                System.out.println("URL");
                sc.nextLine();
                URL = sc.nextLine();
                System.out.println("Duration: ");
                System.out.println("Seconds ");
                seconds = sc.nextInt();
                System.out.println("Minutes ");
                minutes = sc.nextInt();


                numReproductions = 0;

                System.out.println("Price");
                double price = sc.nextInt();
                int numSales = 0;

                controller.registerSong(pName, name, album, genre, URL, seconds, minutes, numReproductions, price, numSales);
                break;
            case 2:
                System.out.println("Podcast info:");
                System.out.println("Name");
                name = sc.nextLine();
                System.out.println("description");
                String description = sc.nextLine();
                System.out.println("Category");
                System.out.println("(1) Politics");
                System.out.println("(2) Entertainment");
                System.out.println("(3) VideoGames");
                System.out.println("(4) Fashion");
                int category = sc.nextInt();
                System.out.println("URL");
                sc.nextLine();
                URL = sc.nextLine();
                System.out.println("Duration: ");
                System.out.println("Seconds ");
                seconds = sc.nextInt();
                System.out.println("Minutes ");
                minutes = sc.nextInt();

                numReproductions = 0;

                controller.registerPodcast(pName, name,description,category,URL,seconds, minutes,numReproductions);
                break;
        }

    }
    public void createPlaylist(){
        controller.showConsumers();
        System.out.println("Id of consumer");
        int id = sc.nextInt();
        System.out.println("Name of playlist");
        sc.nextLine();
        String namePlaylist = sc.nextLine();

        System.out.println("What do you wish to add");
        System.out.println("(1) Songs");
        System.out.println("(2) Podcasts");
        System.out.println("(3) Songs and Podcasts");
        int answer = sc.nextInt();

        String nameSong = "";
        String namePodcast = "";
        switch(answer){
            case 1:
                controller.showCatalogSongs();
                System.out.println("What song do you wish to add (name)");
                sc.nextLine();
                nameSong = sc.nextLine();
                controller.createPlaylist(id, namePlaylist, answer, nameSong, null);
                break;
            case 2:
                controller.showCatalogPodcasts();
                System.out.println("What podcast do you wish to add (name)");
                sc.nextLine();
                namePodcast = sc.nextLine();
                controller.createPlaylist(id, namePlaylist, answer, null, namePodcast);
                break;
            case 3:
                controller.showCatalog();
                System.out.println("What song do you wish to add (name)");
                sc.nextLine();
                nameSong = sc.nextLine();
                System.out.println("What podcast do you wish to add (name)");
                namePodcast = sc.nextLine();
                controller.createPlaylist(id, namePlaylist, answer, nameSong, namePodcast);
                break;
        }
    }
    public void editPlaylist(){
        controller.showConsumers();
        System.out.println("What consumer do you wish to use (id)");
        int id = sc.nextInt();
        controller.showPlaylists(id);
        System.out.println("Name of playlist");
        String namePlaylist = sc.nextLine();
        sc.nextLine();

        System.out.println("What do you wish to edit");
        System.out.println("(1) Name of playlist");
        System.out.println("(2) Add Song");
        System.out.println("(3) Add podcast");
        System.out.println("(4) Remove Song");
        System.out.println("(5) Remove podcast");
        int answer = sc.nextInt();

        switch (answer){
            case 1:
                System.out.println("What name do you wish to change it to");
                sc.nextLine();
                String newName = sc.nextLine();
                controller.editPlaylist(id, namePlaylist, answer, newName, null, null, null, null);
                break;
            case 2:
                controller.showCatalog();
                System.out.println("What song do you wish to add (name)");
                sc.nextLine();
                String newSong = sc.nextLine();
                controller.editPlaylist(id, namePlaylist, answer, null, newSong, null, null, null);
                break;
            case 3:
                controller.showCatalog();
                System.out.println("What podcast do you wish to add (name)");
                sc.nextLine();
                String newPodcast = sc.nextLine();
                controller.editPlaylist(id, namePlaylist, answer, null, null, newPodcast, null, null);
                break;
            case 4:
                controller.showPlaylistsAudio(id, namePlaylist);
                System.out.println("What song do you wish to remove)");
                sc.nextLine();
                String remSong = sc.nextLine();
                controller.editPlaylist(id, namePlaylist, answer, null, null, null, remSong, null);
                break;
            case 5:
                controller.showPlaylistsAudio(id, namePlaylist);
                System.out.println("What podcast do you wish to remove)");
                sc.nextLine();
                String remPodcast = sc.nextLine();
                controller.editPlaylist(id, namePlaylist, answer, null, null, null, null, remPodcast);
                break;
        }
    }
    public void sharePlaylist(){
        controller.showConsumers();
        System.out.println("What consumer do you wish to add shared playlist to?");
        int id = sc.nextInt();
        System.out.println("Code of Playlist");
        String playlistCode = sc.nextLine();

        controller.sharePlaylist(id, playlistCode);
        controller.showPlaylists(id);

    }
    public void reproduceAudio(){
        System.out.println("Reproduce Audio:");

        controller.showConsumers();
        System.out.println("Choose Consumer (id)");
        int id = sc.nextInt();

        controller.showPlaylists(id);
        System.out.println("Choose Playlist");
        sc.nextLine();
        String namePlaylist = sc.nextLine();

        controller.showPlaylistsAudio(id, namePlaylist);
        System.out.println("Choose Audio");
        String nameSong = sc.nextLine();

        controller.repAudio(id, namePlaylist, nameSong);

    }
    public void buySong(){
        System.out.println("Buy Song:");
        controller.showConsumers();
        System.out.println("Choose consumer (id)");
        int id = sc.nextInt();

        controller.showCatalogSongs();
        System.out.println("Choose song (name)");
        String nameSong = sc.nextLine();

        controller.buySong(id, nameSong);

    }
    public void showReports(){
        System.out.println("Welcome to Neo Tunes");

    }
}
