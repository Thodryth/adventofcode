package adventofcode2023.dayTwo;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import defaults.Reader;

public class DayTwo {

    private static final int RED = 12;
    private static final int GREEN = 13;
    private static final int BLUE = 14;

    private static final int PUZZLE_SUM = 2476;
    private static final int PUZZLE_POWER = 54911;
    private static final int TEST_SUM = 8;
    private static final int TEST_POWER = 2286;

    private static final Map<String, Integer> results = new HashMap<>();

    public static void main(String[] args) {

        Reader reader = new Reader();

        var puzzleInput = reader.loadFileToArray("adventofcode2023/dayTwo/puzzleInput");

        var testInput = reader.loadFileToArray("adventofcode2023/dayTwo/testInput");

        run(testInput, "test");
        run(puzzleInput, "puzzle");
    }

    public static void run(String[] input, String type) {
        List<Game> listOfGames = Arrays.asList(input).stream().map(DayTwo::generateGameFromLine)
                .collect(Collectors.toList());

        int power = getPowerOfAllGames(listOfGames);
        int sum = getIdSummForPossibleGames(listOfGames);

        System.out.println("\nTestType: " + type + "\n Power of all games is: " + power
                + " \n IdSumm for possible Games: " + sum);

        results.put("POWER", power);
        results.put("SUM", sum);
        runTest(results);
    }

    private static int getIdSummForPossibleGames(List<Game> listOfGames) {
        List<Game> possibleGames = findPossibleGames(listOfGames);
        return possibleGames.stream().map(game -> game.id)
                .collect(Collectors.summingInt(Integer::intValue));
    }

    public static int getPowerOfAllGames(List<Game> allGames) {
        return allGames.stream().map(Game::getPowerOfGame)
                .collect(Collectors.summingInt(Integer::intValue));
    }

    public static Game generateGameFromLine(String line) {
        List<SimpleEntry<Integer, String>> allPairsInGame = getColorAmountList(line);
        Game game = new Game();
        createGameFromEntries(game, allPairsInGame);
        game.id = findFirstNumber(line);
        return game;
    }

    private static Game createGameFromEntries(Game game,
            List<SimpleEntry<Integer, String>> allEntriesInGame) {
        allEntriesInGame.stream().forEach(entry -> {
            switch (entry.getValue()) {
                case ("blue"):
                    if (game.blue < entry.getKey())
                        game.blue = entry.getKey();
                    break;
                case ("red"):
                    if (game.red < entry.getKey())
                        game.red = entry.getKey();
                    break;
                case ("green"):
                    if (game.green < entry.getKey())
                        game.green = entry.getKey();
                    break;
                default:
                    System.out.println("Unexpected color");
            }
        });
        return game;
    }

    private static List<SimpleEntry<Integer, String>> getColorAmountList(String line) {
        int startOfCubes = line.indexOf(":") + 1;
        line = line.substring(startOfCubes);
        String[] sets = line.split(";");
        List<SimpleEntry<Integer, String>> allPairsInGame = new ArrayList<>();

        for (String set : sets) {
            String[] entries = set.split(",");
            for (String subentries : entries) {
                allPairsInGame.add(mapFieldToAmount(subentries));
            }
        }
        return allPairsInGame;
    }

    public static int findFirstNumber(String substring) {
        Pattern digitsOnly = Pattern.compile("\\d+");
        Matcher matcher = digitsOnly.matcher(substring);
        matcher.find();
        return Integer.parseInt(matcher.group());
    }

    public static SimpleEntry<Integer, String> mapFieldToAmount(String entry) {
        int number = findFirstNumber(entry);
        String name = entry.replace(String.valueOf(number), "");
        name = name.trim();
        return new SimpleEntry<>(number, name);
    }

    public static List<Game> findPossibleGames(List<Game> allGames) {
        List<Game> possibleGames = new ArrayList<>();

        allGames.forEach(game -> {
            if (game.blue <= BLUE && game.red <= RED && game.green <= GREEN) {
                possibleGames.add(game);
            }
        });
        return possibleGames;
    }

    public static void runTest(Map<String, Integer> results) {
        if (results.get("SUM") != PUZZLE_SUM && results.get("SUM") != TEST_SUM)
            throw new RuntimeException("Sum calculation went wrong");
        if (results.get("POWER") != PUZZLE_POWER && results.get("POWER") != TEST_POWER)
            throw new RuntimeException("Power calculation went wrong");

        System.out.println("\n Tests against results was successfull");
    }
}


