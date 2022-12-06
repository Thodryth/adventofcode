package adventofcode.dayThree;

public class StringService {

    public String findCharPairInStrings(String stringA, String stringB) {
        String foundChar = "";

        for (int i = 0; i < stringA.length(); i++) {
            var checkChar = stringA.charAt(i);
            if (stringB.contains(String.valueOf(checkChar))) {
                return (String.valueOf(checkChar));
            }
        }
        return foundChar;
    }

}
