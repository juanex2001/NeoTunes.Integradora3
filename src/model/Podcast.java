package model;

public class Podcast extends Audio{
    private String description;
    private Category category;

    public Podcast(String name, String URL, Duration duration, int numReproductions, Category category, String description) {
        super(name, URL, duration, numReproductions);
        this.category = category;
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Podcast{" +
                "description='" + description + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
