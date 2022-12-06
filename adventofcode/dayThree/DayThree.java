package adventofcode.dayThree;

import java.util.Arrays;

import adventofcode.defaults.Reader;

public class DayThree {
    public static void main(String[] args) {
        Reader reader = new Reader();
        PrioritiseService prioritiseService = new PrioritiseService();
        StringService stringService = new StringService();

        var file = reader.loadFileToArray("adventofcode/dayThree/day3");

        var result = prioritiseService.calculatePriority(Arrays.asList(file));
        System.out.println(result);

    }
}
