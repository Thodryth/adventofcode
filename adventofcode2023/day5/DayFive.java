package adventofcode2023.day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import defaults.Reader;

public class DayFive {

    private final static int TASK_ONE_TEST_RESULT = 35;

    public static void main(String[] args) {

        Reader reader = new Reader();

        var puzzleInput = reader.loadFileToArrayWithoutEmptyLines("adventofcode2023/day5/puzzleInput");
        var testInput = reader.loadFileToArrayWithoutEmptyLines("adventofcode2023/day5/testInput");

        int[] testResult = run(testInput, "test");
        if (!(testResult[0] == TASK_ONE_TEST_RESULT) /* && result[1] == TEST_AMOUNT */) {
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
        for (int i = 0; i < 1640984363 ; i++) {
            map.put(i, i);
        }
        String mapIdentifier = "";
        for (int lineIndex = 1; lineIndex < lines.length; lineIndex++) {
            String actualLine = lines[lineIndex];
            if (actualLine.contains("-")) {
                if (lineIndex > 1) {
                    maps.put(mapIdentifier, map);
                    map = new HashMap<>();
                    mapIdentifier = actualLine;
                }
            } else {
                String[] numbersInLine = actualLine.split(" ");
                int destination = Integer.parseInt(numbersInLine[0]);
                int source = Integer.parseInt(numbersInLine[1]);
                int steps = Integer.parseInt(numbersInLine[2]);

                System.out.println(" Destination " + destination + " Source " + source + " Steps " + steps);

                for (int i = 0; i < steps; i++) {
                    map.replace(destination + i, destination + i);
                    System.out.println(destination+i);
                    System.out.println(map.get(destination+i));
                }

                map.forEach((k, v) -> System.out.println(k + " - " + v));

            }

        }

        return maps;
    }

}
