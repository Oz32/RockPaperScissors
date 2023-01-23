package rockpaperscissors;

public class Player {
    private String name;
    private String choice;
    int rating = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating += rating;
    }
}
