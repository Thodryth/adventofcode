package adventofcode2023.dayThree;

import java.util.ArrayList;
import java.util.List;

public class Number {
    int value = 0;
    String valueAsString = "";
    List<Coordinates> coordinates = new ArrayList<>();


    public List<Coordinates> neighbours() {
        List<Coordinates> neighbourIndexes = new ArrayList<>();
        for (Coordinates coordinate : coordinates) {
            neighbourIndexes.add(new Coordinates(coordinate.x + 1, coordinate.y));
            neighbourIndexes.add(new Coordinates(coordinate.x - 1, coordinate.y));
            neighbourIndexes.add(new Coordinates(coordinate.x, coordinate.y + 1));
            neighbourIndexes.add(new Coordinates(coordinate.x, coordinate.y - 1));
            neighbourIndexes.add(new Coordinates(coordinate.x + 1, coordinate.y - 1));
            neighbourIndexes.add(new Coordinates(coordinate.x - 1, coordinate.y - 1));
            neighbourIndexes.add(new Coordinates(coordinate.x + 1, coordinate.y + 1));
            neighbourIndexes.add(new Coordinates(coordinate.x - 1, coordinate.y + 1));
        }

        return neighbourIndexes;
    }
}


