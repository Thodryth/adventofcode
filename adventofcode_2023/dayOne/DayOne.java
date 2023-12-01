package adventofcode_2023.dayOne;

import java.util.ArrayList;
import java.util.List;

import adventofcode.defaults.Reader;

public class DayOne {

    public static void main(String[] args) {

        Reader reader = new Reader();

        var input = reader.loadFileToArray("adventofcode_2023\\dayOne\\puzzleInput");

        System.out.println("Summ: " + summOfFirstAndLastDigit(input));

        System.out.println("Corrected Summ: " + summOfFirstAndLastDigit(makeWordsToDigits(input)));

    }

    public static int summOfFirstAndLastDigit(String[] lines) {
        int summ = 0;

        for (int i = 0; i < lines.length; i++) {
            String firstDigit = null;
            String lastDigit = null;
            for (int j = 0; j < lines[i].length(); j++) {
                if (Character.isDigit(lines[i].charAt(j))) {
                    firstDigit = String.valueOf(lines[i].charAt(j));
                    break;
                }
            }

            for (int j = lines[i].length() - 1; j >= 0; j--) {
                if (Character.isDigit(lines[i].charAt(j))) {
                    lastDigit = String.valueOf(lines[i].charAt(j));
                    break;
                }
            }

            summ += Integer.parseInt(firstDigit + lastDigit);

        }

        return summ;
    }

    public static String[] makeWordsToDigits(String[] lines) {

        String[] translatedInput = new String[lines.length];

        int i = 0;

        for (String line : lines) {
            line = line.replace("one", "o1e");
            line = line.replace("two", "t2o");
            line = line.replace("three", "t3e");
            line = line.replace("four", "f4r");
            line = line.replace("five", "f5e");
            line = line.replace("six", "s6x");
            line = line.replace("seven", "s7n");
            line = line.replace("eight", "e8t");
            line = line.replace("nine", "n9e");
            translatedInput[i] = line;
            i++;
        }

        return translatedInput;
    }

}
