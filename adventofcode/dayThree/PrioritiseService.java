package adventofcode.dayThree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrioritiseService {

    StringService stringService = new StringService();

    private char a = 'a';
    private char bigA = 'A';

    private int aAsAscci = a;
    private int asAsciiA = bigA;
    private int priority = 1;
    private int numberOfChars = 26;

    private int totalPrio = 0;

    Map<String, Integer> charToAscii = new HashMap<>();

    public Map<String, Integer> createCharToAsciiMap() {
        var map = new HashMap<String, Integer>();

        for (int i = 1; i <= numberOfChars; i++) {
            map.put(Character.toString(aAsAscci), priority);
            priority++;
            aAsAscci++;
        }
        for (int i = 1; i <= numberOfChars; i++) {
            map.put(Character.toString(asAsciiA), priority);
            priority++;
            asAsciiA++;
        }
        return map;
    }

    public int calculatePriority(List<String> charList) {
        var priorityMap = this.createCharToAsciiMap();

        charList.forEach(entry -> {
            var text1 = entry.substring(0, entry.length() / 2);
            var text2 = entry.substring(entry.length() / 2, entry.length());
            var foundPair = stringService.findCharPairInStrings(text1, text2);
            var charPrio = priorityMap.get(foundPair);
            this.totalPrio += charPrio;
        });
        return this.totalPrio;
    }

}
