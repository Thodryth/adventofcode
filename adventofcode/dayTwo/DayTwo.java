package adventofcode.dayTwo;

import adventofcode.defaults.Reader;

public class DayTwo {

    public static void main(String[] args) {
        Reader reader = new Reader();
        PairService pairService = new PairService();

        var list = reader.loadFileToArray("adventofcode/dayTwo/day2");
        var pairs = pairService.createPairs(list);
        pairs.forEach(pair -> System.out.println(pair.minePoints));
    }
}