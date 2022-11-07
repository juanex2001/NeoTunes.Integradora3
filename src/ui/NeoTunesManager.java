package ui;
import java.util.Scanner;


import model.NeoTunesController;

public class NeoTunesManager {
    private Scanner sc;
    public NeoTunesController controller;

    public NeoTunesManager(){
        super();
        this.sc = new Scanner(System.in);
        this.controller = new NeoTunesController();
    }
//test
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
        String URL = sc.nextLine();
        System.out.println("Type");
        System.out.println("(1) Artist");
        System.out.println("(2) Content Creator");
        int type = sc.nextInt();

        controller.registerProducer(name,day,month,year,URL,type);

    }
    public void registerAudio(){
        System.out.println("What type of Audio");
        System.out.println("(1) Songs");
        System.out.println("(2) Podcasts");
        int type = sc.nextInt();

        String name;
        String URL;
        int duration;
        int numReproductions;

        switch(type){
            case 1:
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
                URL = sc.nextLine();
                System.out.println("Duration");
                duration = sc.nextInt();

                numReproductions = 0;

                System.out.println("Price");
                double price = sc.nextInt();
                int numSales = 0;

                controller.registerSong(name, album, genre, URL, duration, numReproductions, price, numSales);
                break;
            case 2:
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
                URL = sc.nextLine();
                System.out.println("Duration");
                duration = sc.nextInt();

                numReproductions = 0;

                controller.registerPodcast(name,description,category,URL,duration,numReproductions);
                break;
        }

    }
    public void createPlaylist(){
        System.out.println("Id of consumer");
        int id = sc.nextInt();
        System.out.println("Name of playlist");
        String namePlaylist = sc.nextLine();

        System.out.println("What do you wish to add");
        System.out.println("(1) Songs");
        System.out.println("(2) Podcasts");
        System.out.println("(3) Songs and Podcasts");
        int answer = sc.nextInt();

        String nameSong = null;
        String namePodcast = null;
        switch(answer){
            case 1:
                controller.showCatalog();
                System.out.println("What song do you wish to add (name)");
                nameSong = sc.nextLine();
                break;
            case 2:
                controller.showCatalog();
                System.out.println("What podcast do you wish to add (name)");
                namePodcast = sc.nextLine();
                break;
            case 3:
                controller.showCatalog();
                System.out.println("What song do you wish to add (name)");
                nameSong = sc.nextLine();
                System.out.println("What podcast do you wish to add (name)");
                namePodcast = sc.nextLine();
                break;
        }


    }
    public void editPlaylist(){
        System.out.println("Welcome to Neo Tunes");

    }
}
