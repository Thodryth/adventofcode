package adventofcode2023.dayTwo;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import defaults.Reader;

public class DayTwo {

    private static final int RED = 12;
    private static final int GREEN = 13;
    private static final int BLUE = 14;

    public static void main(String[] args) {

        Reader reader = new Reader();

        var puzzleInput = reader.loadFileToArray("adventofcode2023/dayTwo/puzzleInput");

        var testInput = reader.loadFileToArray("adventofcode2023/dayTwo/testInput");

        run(testInput, "test");
        run(puzzleInput, "puzzle");
    }

    public static void run(String[] input, String type) {
        System.out.println("\n- Run code against " + type);
        int idSumm = getIdSummForInput(input);
        System.out.println("Id TestSumm: " + idSumm);
    }

    private static int getIdSummForInput(String[] input) {
        List<Game> listOfGames = new ArrayList<>();
        Arrays.asList(input).forEach(line -> listOfGames.add(generateGameFromLine(line)));
        List<Game> possibleGames = findPossibleGames(listOfGames);
        System.out.println("Power Of All Games: " + getPowerOfAllGames(listOfGames));
        System.out.println("Number of possible Games: " + possibleGames.size());
        return possibleGames.stream().map(game -> game.id)
                .collect(Collectors.summingInt(Integer::intValue));
    }

    public static int getPowerOfAllGames(List<Game> allGames) {
        return allGames.stream().map(DayTwo::getPowerOfGame)
                .collect(Collectors.summingInt(Integer::intValue));
    }

    public static int getPowerOfGame(Game game) {
        return game.blue * game.red * game.green;
    }

    public static Game generateGameFromLine(String line) {
        List<SimpleEntry<Integer, String>> allPairsInGame = getColorAmountList(line);
        Game game = new Game();
        createGameFromEntries(game, allPairsInGame);
        game.id = getGameId(line);
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

    public static int findNumbers(String substring) {
        Pattern digitsOnly = Pattern.compile("\\d+");
        Matcher matcher = digitsOnly.matcher(substring);
        matcher.find();
        return Integer.parseInt(matcher.group());
    }

    public static int getGameId(String line) {
        String gameIndexString = line.substring(0, line.indexOf(":"));
        return findNumbers(gameIndexString);
    }


    public static SimpleEntry<Integer, String> mapFieldToAmount(String entry) {
        int number = findNumbers(entry);
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

}


