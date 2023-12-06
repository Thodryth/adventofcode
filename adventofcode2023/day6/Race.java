package adventofcode2023.day6;

import java.util.ArrayList;
import java.util.List;

public class Race {

    long dinstance;
    long time;
    List<Long> possibleWins = new ArrayList<>();

    public Race(long time, long dinstance) {
        this.time = time;
        this.dinstance = dinstance;
    }

    public String toString() {
        return "Time: " + time + " Distance: " + dinstance;
    }

}
