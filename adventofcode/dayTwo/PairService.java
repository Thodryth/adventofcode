package adventofcode.dayTwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PairService {

    public List<Pair> createPairs(String[] fileInput) {
        var pairList = new ArrayList<Pair>();
        Arrays.asList(fileInput).forEach(entry -> {
            var pair = new Pair(entry);
            pairList.add(pair);
        });
        return pairList;
    }

}
