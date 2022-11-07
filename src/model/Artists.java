package model;

import java.util.ArrayList;

public class Artists extends Producers{

    public Artists(String name, Date date, String URL) {
        super(name, date, URL);
    }

    @Override
    public String toString() {
        return "Artists{}";
    }
}
