package adventofcode.dayThree;

import adventofcode.defaults.Reader;

public class DayThree {
    public static void main(String[] args) {
        Reader reader = new Reader();
        PrioritiseService prioritiseService = new PrioritiseService();
        StringService stringService = new StringService();

        var file = reader.loadFileToArray("adventofcode/dayThree/day3");

        var priorityMap = prioritiseService.createCharToAsciiMap();

    }
}
