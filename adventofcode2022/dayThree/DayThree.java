package adventofcode2022.dayThree;

import java.util.Arrays;
import defaults.Reader;

public class DayThree {
    public static void main(String[] args) {
        Reader reader = new Reader();
        PrioritiseService prioritiseService = new PrioritiseService();

        var file = reader.loadFileToArray("adventofcode2022/dayThree/day3");

        var resultOne = prioritiseService.calculatePriority(Arrays.asList(file));
        System.out.println(resultOne);
        var resultThree = prioritiseService.calculateThreePrioriy(Arrays.asList(file));
        System.out.println(resultThree);

    }
}
