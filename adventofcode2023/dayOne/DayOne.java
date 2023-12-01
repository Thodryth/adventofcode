package adventofcode2023.dayOne;

import defaults.Reader;

public class DayOne {

    public static void main(String[] args) {

        Reader reader = new Reader();

        var puzzleInput = reader.loadFileToArray("adventofcode2023/dayOne/puzzleInput");
        var testInputOne = reader.loadFileToArray("adventofcode2023/dayOne/testInputOne");
        var testInputTwo = reader.loadFileToArray("adventofcode2023/dayOne/testInputTwo");

        runTest(testInputOne, testInputTwo);

        runPuzzle(puzzleInput);
    }

    public static void runTest(String[] inputOne, String[] inputTwo) {
        System.out.println("\n<- Evaluate TestInput ->");
        System.out.println("Summ 1: " + summOfFirstAndLastDigit(inputOne));
        System.out.println("Summ 2: " + summOfFirstAndLastDigit(makeWordsToDigits(inputTwo)));
    }

    public static void runPuzzle(String[] input) {
        System.out.println("\n<- Evaluate PuzzleInput ->");
        System.out.println("Summ 1: " + summOfFirstAndLastDigit(input));
        System.out.println("Summ 2: " + summOfFirstAndLastDigit(makeWordsToDigits(input)));
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
