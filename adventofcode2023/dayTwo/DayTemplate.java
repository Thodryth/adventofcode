package adventofcode2023.dayTwo;

import defaults.Reader;

public class DayTemplate {

    public static void main(String[] args) {

        Reader reader = new Reader();

        var puzzleInput = reader.loadFileToArray("adventofcode2023/dayTemplate/puzzleInput");

        var testInput = reader.loadFileToArray("adventofcode2023/dayTemplate/testInput");

        runTest(testInput);

        runPuzzle(puzzleInput);
    }

    public static void runTest(String[] input) {
        System.out.println("- Run code against testInput");
        System.out.println(input[0]);
    }

    public static void runPuzzle(String[] input) {
        System.out.println("- Run code against puzzleInput");
        System.out.println(input[0]);
    }

}


