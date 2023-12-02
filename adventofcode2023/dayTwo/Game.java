package adventofcode2023.dayTwo;

public class Game {
    int id;

    int blue = 0;
    int red = 0;
    int green = 0;

    public String toString() {
        return "Game " + id + " Blue: " + blue + " Green: " + green + " Red: " + red;
    }

    public int getPowerOfGame() {
        return this.blue * this.red * this.green;
    }
}
