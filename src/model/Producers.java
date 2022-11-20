package model;


import java.util.ArrayList;

public abstract class Producers extends User{
    private String URL;
    private ArrayList<Audio> catalog;

    public Producers(String name, Date date, String URL) {
        super(name, date);
        this.URL = URL;
        this.catalog = new ArrayList<Audio>();
    }

    public void addAudio(Audio newAudio){
        catalog.add(newAudio);
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    @Override
    public String toString() {
        return "Producers{" +
                "URL='" + URL + '\'' +
                '}';
    }
}
