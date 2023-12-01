package adventofcode2022.dayTwo;

import defaults.Reader;

public class DayTwo {

    public static void main(String[] args) {
        Reader reader = new Reader();
        PairService pairService = new PairService();

        var list = reader.loadFileToArray("adventofcode2022/dayTwo/day2");
        var pairsperfect = pairService.createPairsPerfect(list);
        var pairs = pairService.createPairs(list);

        var totalScore = pairService.calculateTotalScore(pairsperfect);
        System.out.println("Perfect Score: " + totalScore);
        totalScore = pairService.calculateTotalScore(pairs);
        System.out.println("First Score: " + totalScore);
    }
}
