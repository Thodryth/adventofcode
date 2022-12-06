package adventofcode.dayTwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PairService {

    public List<Pair> createPairs(String[] fileInput) {
        var pairList = new ArrayList<Pair>();
        Arrays.asList(fileInput).forEach(entry -> {
            var pair = new Pair(entry);
            pairList.add(pair);
        });
        return pairList;
    }

    public List<Pair> createPairsPerfect(String[] fileInput) {
        var pairList = new ArrayList<Pair>();
        Arrays.asList(fileInput).forEach(entry -> {
            var pair = new Pair(entry, true);
            pairList.add(pair);
        });
        return pairList;
    }

    public int calculateTotalScore(List<Pair> pairs) {
        return pairs.stream().map(Pair::getTotalPoints).collect(Collectors.summingInt(Integer::intValue));
    }

}
