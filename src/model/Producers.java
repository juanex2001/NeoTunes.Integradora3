package model;


public abstract class Producers extends User{
    private String URL;

    public Producers(String name, Date date, String URL) {
        super(name, date);
        this.URL = URL;
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
