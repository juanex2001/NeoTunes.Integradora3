package model;

public class Duration {
    private int seconds;
    private int minutes;

    public Duration(int seconds, int minutes) {
        this.seconds = seconds;
        this.minutes = minutes;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    @Override
    public String toString() {
        return "Duration{" + minutes + " : " + seconds +
                '}';
    }
}
