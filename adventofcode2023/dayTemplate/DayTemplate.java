package adventofcode2023.dayTemplate;

import defaults.Reader;

public class DayTemplate {

    public static void main(String[] args) {

        Reader reader = new Reader();

        var puzzleInput = reader.loadFileToArray("adventofcode2023/dayTemplate/puzzleInput");
        var testInput = reader.loadFileToArray("adventofcode2023/dayTemplate/testInput");

        run(testInput, "test");

        run(puzzleInput, "puzzle");
    }

    public static void run(String[] input, String type) {
        System.out.println("- Run code against " + type);
        System.out.println(input[0]);
    }


}


