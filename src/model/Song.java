package model;

public class Song extends Audio {
    private String album;
    private Genre genre;
    private double price;
    private int sales;

    public Song(String name, String URL, Duration duration, int numReproductions, String album, Genre genre, double price, int sales) {
        super(name, URL, duration, numReproductions);
        this.album = album;
        this.genre = genre;
        this.price = price;
        this.sales = sales;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    @Override
    public String toString() {
        return "Song{" +
                "album='" + album + '\'' +
                ", genre=" + genre +
                ", price=" + price +
                ", sales=" + sales +
                '}';
    }
}
