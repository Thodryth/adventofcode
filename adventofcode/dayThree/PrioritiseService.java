package adventofcode.dayThree;

import java.util.HashMap;
import java.util.Map;

public class PrioritiseService {

    private char a = 'a';
    private char bigA = 'A';

    private int aAsAscci = a;
    private int asAsciiA = bigA;
    private int priority = 1;
    private int numberOfChars = 26;

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

    public int calculatePriority(String charList) {
        return 0;
    }

}
