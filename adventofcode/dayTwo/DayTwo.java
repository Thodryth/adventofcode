package adventofcode.dayTwo;

import adventofcode.defaults.Reader;

public class DayTwo {

    public static void main(String[] args) {
        Reader reader = new Reader();
        PairService pairService = new PairService();

        var list = reader.loadFileToArray("adventofcode/dayTwo/day2");
        var pairs = pairService.createPairsPerfect(list);

        var totalScore = pairService.calculateTotalScore(pairs);
        System.out.println("Score: " + totalScore);
    }
}