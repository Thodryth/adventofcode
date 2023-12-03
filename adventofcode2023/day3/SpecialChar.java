package adventofcode2023.day3;

import java.util.ArrayList;
import java.util.List;

public class SpecialChar {

    String sign;

    public SpecialChar(Coordinates coordinates, String sign) {
        this.coordinates = coordinates;
        this.sign = sign;
    }

    Coordinates coordinates;

    List<Number> neighbour = new ArrayList<>();

}
