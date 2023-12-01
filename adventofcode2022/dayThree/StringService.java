package adventofcode2022.dayThree;

import java.util.HashSet;
import java.util.Set;

public class StringService {

    public String findCharPairInStrings(String stringA, String stringB) {
        var foundChar = "";

        for (int i = 0; i < stringA.length(); i++) {
            var checkChar = stringA.charAt(i);
            if (stringB.contains(String.valueOf(checkChar))) {
                return (String.valueOf(checkChar));
            }
        }
        return foundChar;
    }

    public Set<String> findMatchingChars(String stringA, String stringB) {
        var chars = new HashSet<String>();

        for (int i = 0; i < stringA.length(); i++) {
            var checkChar = stringA.charAt(i);
            if (stringB.contains(String.valueOf(checkChar))) {
                chars.add(String.valueOf(checkChar));
            }
        }
        return chars;
    }

}
