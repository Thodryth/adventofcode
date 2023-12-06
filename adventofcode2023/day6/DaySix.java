package adventofcode2023.day6;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import defaults.Reader;

public class DaySix {

    private static final int TASK_1_RESULT = 288;
    private static final int TASK_2_RESULT = -1;

    static double wincounter = 0;

    public static void main(String[] args) {

        Reader reader = new Reader();

        var puzzleInput = reader.loadFileToArray("adventofcode2023/day6/puzzleInput");
        var puzzleInputTwo = reader.loadFileToArray("adventofcode2023/day6/puzzleInputTwo");

        int[] result = run(puzzleInput, "puzzle");
        System.out.println("Task 1: " + result[0] + " Task 2: " + result[1]);
        wincounter = 0;
        run(puzzleInputTwo, "puzzle");
        System.out.println("Wincounter " + wincounter);
    }

    public static int[] run(String[] input, String type) {
        int[] result = {-1, -1};
        System.out.println("- Run code against " + type);
        System.out.println(input[0]);
        List<Race> races = splitInputToRaces(input);
        races.stream().forEach(race -> calculateWinnings(race, 0));
        result[0] = races.stream().map(race -> race.possibleWins.size()).reduce(1, (a, b) -> a * b);
        return result;
    }

    public static List<Race> splitInputToRaces(String[] input) {

        List<Race> races = new ArrayList<>();

        String[] times = removeAnyNaN(input[0]);
        String[] distances = removeAnyNaN(input[1]);

        for (int index = 0; index < times.length; index++) {
            Race race = new Race(Long.parseLong(times[index]), Long.parseLong(distances[index]));

            races.add(race);
        }
        return races;
    }

    public static String[] removeAnyNaN(String line) {
        return line.replaceAll("[A-Za-z]", "").replace(":", "").replaceAll("\\s+", " ").trim()
                .split(" ");
    }

    public static Race calculateWinnings(Race race, int startTime) {
        for (int i = startTime; i < race.time; i++) {
            var result = getResult(i, race.time);
            if (result > race.dinstance) {
                race.possibleWins.add(result);
                wincounter++;
            }
        }
        return race;
    }

    public static long getResult(long buttonTime, long raceTime) {
        return buttonTime * (raceTime - buttonTime);
    }

}


