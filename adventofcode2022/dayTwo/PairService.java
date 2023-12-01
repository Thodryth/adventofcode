package adventofcode2022.dayTwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PairService {

    public List<PairProcessor> createPairs(String[] fileInput) {
        var pairList = new ArrayList<PairProcessor>();
        Arrays.asList(fileInput).forEach(entry -> {
            var pair = new PairProcessor(entry);
            pairList.add(pair);
        });
        return pairList;
    }

    public List<PairProcessor> createPairsPerfect(String[] fileInput) {
        var pairList = new ArrayList<PairProcessor>();
        Arrays.asList(fileInput).forEach(entry -> {
            var pair = new PairProcessor(entry, true);
            pairList.add(pair);
        });
        return pairList;
    }

    public int calculateTotalScore(List<PairProcessor> pairs) {
        return pairs.stream().map(PairProcessor::getTotalPoints)
                .collect(Collectors.summingInt(Integer::intValue));
    }

}
