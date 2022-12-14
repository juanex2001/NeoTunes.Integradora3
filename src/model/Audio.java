package model;

public abstract class Audio {
    private String name;
    private String URL;
    private Duration duration;
    private int numReproductions;

    public Audio(String name, String URL, Duration duration, int numReproductions) {
        super();
        this.name = name;
        this.URL = URL;
        this.duration = duration;
        this.numReproductions = numReproductions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public int getNumReproductions() {
        return numReproductions;
    }

    public void setNumReproductions(int numReproductions) {
        this.numReproductions = numReproductions;
    }

    @Override
    public String toString() {
        return "Audio{" +
                "name='" + name + '\'' +
                ", URL='" + URL + '\'' +
                ", duration=" + duration +
                ", numReproductions=" + numReproductions +
                '}';
    }
}
