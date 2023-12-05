package adventofcode2023.day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import defaults.Reader;

public class DayFive {

    private final static int TASK_ONE_TEST_RESULT = 35;

    public static void main(String[] args) {

        Reader reader = new Reader();

        var puzzleInput = reader.loadFileToArrayWithoutEmptyLines("adventofcode2023/day5/puzzleInput");
        var testInput = reader.loadFileToArrayWithoutEmptyLines("adventofcode2023/day5/testInput");

        int[] testResult = run(testInput, "test");
        if (testResult[0] == TASK_ONE_TEST_RESULT /* && result[1] == TEST_AMOUNT */) {
            System.out.println("TestResult and TestAmount are as expected");
            run(puzzleInput, "puzzle");
        } else {
            System.out.println("Unexpected testResult! Solving puzzle not started!");
            System.out.println("Expected: " + TASK_ONE_TEST_RESULT + " Delivered: " + testResult[0]);
        }
    }

    public static int[] run(String[] input, String type) {

        int[] testResults = { -1, -1 };

        System.out.println("- Run code against " + type);
        List<Seed> seeds = seeds(input[0]);
        generateMap(input);

        return testResults;

    }

    public static List<Seed> seeds(String line) {
        List<Seed> seeds = new ArrayList<>();
        String workingLine = line.split(": ")[1];
        Arrays.asList(workingLine.split(" ")).stream().forEach(nr -> seeds.add(new Seed(Integer.parseInt(nr))));
        return seeds;
    }

    public static Map<String, Map<Integer, Integer>> generateMap(String[] lines) {
        Map<String, Map<Integer, Integer>> maps = new HashMap<>();

        Map<Integer, Integer> map = new HashMap<>();
        String mapIdentifier = "";
        for (int lineIndex = 1; lineIndex < lines.length; lineIndex++) {
            if (lines[lineIndex].contains("-")) {
                if (lineIndex > 1) {
                    maps.put(mapIdentifier, map);
                }
                map = new HashMap<>();
                mapIdentifier = lines[lineIndex];
            }

        }

        return maps;
    }

}
