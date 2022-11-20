package model;

import java.util.Arrays;

public abstract class Consumer extends User{
    private int id;

    public Consumer(String name, Date date, int id) {
        super(name, date);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Consumer{" +
                "id=" + id +
                '}';
    }

}
