package adventofcode2023.dayTwo;

public class Game {
    int id;
    String name;

    int blue = 0;
    int red = 0;
    int green = 0;

    public String toString() {
        return "Game " + id + " Blue: " + blue + " Green: " + green + " Red: " + red;
    }
}
