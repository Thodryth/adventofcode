package adventofcode2023.day3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import defaults.Reader;

public class DayThree {

    private static final int TEST_SUMM = 4361;
    private static final int PUZZLE_SUMM = 532428;

    public static void main(String[] args) {

        Reader reader = new Reader();

        String[] puzzleInput = reader.loadFileToArray("adventofcode2023/day3/puzzleInput");
        String[] testInput = reader.loadFileToArray("adventofcode2023/day3/testInput");

        int testResult = run(testInput, "test");

        if (testResult == TEST_SUMM) {
            System.out.println("Test result is as expected. PuzzleInput next");
            System.out.println("TestResult: " + testResult);
            int puzzleResult = run(puzzleInput, "puzzle");
            System.out.println("PuzzleResult: " + puzzleResult);
            System.out.println("Is result still as expected? " + (puzzleResult == PUZZLE_SUMM));
        } else {
            System.out.println("Failed on test input! Puzzle input not used!");
        }
    }

    public static int run(String[] input, String type) {
        int result = 0;
        System.out.println("- Run code against " + type);
        String[][] twoDimArray = mapInputTo2dimArray(input);
        fillNullWithDots(twoDimArray);
        List<SpecialChar> specialChars = findSpecialChars(twoDimArray);
        List<Number> numbers = findNumbersWithCoordinates(twoDimArray);
        List<Number> filteredNumbers = filterNumbers(specialChars, numbers);
        result = filteredNumbers.stream().map(number -> Integer.parseInt(number.valueAsString))
                .collect(Collectors.summingInt(Integer::intValue));

        System.out.println("Gear: " + getGear(specialChars));

        return result;
    }

    private static int getGear(List<SpecialChar> specialChars) {
        return specialChars.stream().filter(c -> c.sign.equals("*") && c.neighbour.size() == 2)
                .collect(Collectors.toList()).stream()
                .map(c -> Integer.parseInt(c.neighbour.get(0).valueAsString)
                        * Integer.parseInt(c.neighbour.get(1).valueAsString))
                .collect(Collectors.summingInt(Integer::intValue));
    }

    public static List<Number> filterNumbers(List<SpecialChar> chars, List<Number> numbers) {
        List<Number> filteredNumbers = new ArrayList<>();

        numbers.stream().forEach(number -> number.neighbours().stream()
                .forEach(neighbour -> chars.forEach(character -> {
                    if (neighbour.equals(character.coordinates)
                            && !filteredNumbers.contains(number)) {
                        filteredNumbers.add(number);
                        character.neighbour.add(number);
                    }
                })));

        return filteredNumbers;
    }

    public static List<Number> findNumbersWithCoordinates(String[][] twoDimArray) {
        List<Number> numberList = new ArrayList<>();
        Number foundNumber = new Number();
        for (int index = 0; index < twoDimArray.length; index++) {
            for (int charIndex = 0; charIndex < twoDimArray[index].length; charIndex++) {
                if (twoDimArray[index][charIndex].matches("\\d")) {
                    foundNumber.valueAsString =
                            foundNumber.valueAsString + twoDimArray[index][charIndex];
                    foundNumber.coordinates.add(new Coordinates(index, charIndex));
                } else {
                    if (!foundNumber.valueAsString.equals(""))
                        numberList.add(foundNumber);
                    foundNumber = new Number();
                }
            }
        }
        return numberList;
    }


    public static List<SpecialChar> findSpecialChars(String[][] twoDimArry) {
        List<SpecialChar> specialChars = new ArrayList<>();
        int i = 0;
        for (String[] line : twoDimArry) {
            int j = 0;
            for (String c : line) {
                if (!c.equals(".") && !c.matches("\\d")) {
                    specialChars.add(new SpecialChar(new Coordinates(i, j), c));
                }
                j++;
            }
            i++;
        }
        return specialChars;
    }

    public static String[][] mapInputTo2dimArray(String[] input) {

        String[][] twoDimArray = new String[input.length + 2][input[0].length() + 2];

        for (int index = 0; index < input.length; index++) {
            char[] singleChars = input[index].toCharArray();
            for (int charIndex = 0; charIndex < singleChars.length; charIndex++) {
                twoDimArray[index + 1][charIndex + 1] = String.valueOf(singleChars[charIndex]);
            }
        }
        return twoDimArray;
    }

    private static String[][] fillNullWithDots(String[][] twoDimArry) {
        int i = 0;
        for (String[] line : twoDimArry) {
            int j = 0;
            for (String c : line) {
                if (c == null) {
                    twoDimArry[i][j] = ".";
                }
                j++;
            }
            i++;
        }
        return twoDimArry;
    }
}


