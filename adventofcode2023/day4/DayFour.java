package adventofcode2023.day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import defaults.Reader;

public class DayFour {

    private static final int TEST_RESULT = 13;
    private static final int TEST_AMOUNT = 30;

    public static void main(String[] args) {

        Reader reader = new Reader();

        var puzzleInput = reader.loadFileToArray("adventofcode2023/day4/puzzleInput");
        var testInput = reader.loadFileToArray("adventofcode2023/day4/testInput");


        int[] result = run(testInput, "test");

        if (result[0] == TEST_RESULT && result[1] == TEST_AMOUNT) {
            System.out.println("TestResult and TestAmount are as expected");
            run(puzzleInput, "puzzle");
        } else {
            System.out.println("Unexpected testResult! Solving puzzle not started!");
            System.out.println("Expected: " + TEST_RESULT + " Delivered: " + result);
        }
    }

    public static int[] run(String[] input, String type) {
        int[] result = {0, 0};
        System.out.println("- Run code against " + type);
        List<Card> cards = mapInputToCards(input);
        result[0] = cards.stream().map(Card::getValue)
                .collect(Collectors.summingInt(Integer::intValue));
        System.out.println("Result: " + result[0]);

        for (Card card : cards) {
            multipleCardsForWins(cards, card);
        }

        result[1] = cards.stream().map(Card::getAmount)
                .collect(Collectors.summingInt(Integer::intValue));
        System.out.println("Amount: " + result[1]);
        return result;
    }

    public static List<Card> mapInputToCards(String[] input) {
        List<Card> cardList = new ArrayList<>();

        for (int index = 0; index < input.length; index++) {
            Card card = new Card();
            card.id = findFirstNumber(input[index]);
            parseNumbersFromList(input[index], card);
            calculateWins(card);
            cardList.add(card);
        }
        return cardList;
    }

    public static int findFirstNumber(String substring) {
        Pattern digitsOnly = Pattern.compile("\\d+");
        Matcher matcher = digitsOnly.matcher(substring);
        matcher.find();
        return Integer.parseInt(matcher.group());
    }

    public static Card parseNumbersFromList(String line, Card card) {
        String workingLine = line.substring(line.indexOf(":") + 1);
        workingLine = workingLine.replace("  ", " ");
        String[] parts = workingLine.split("\\|");
        parts[0] = parts[0].trim();
        parts[1] = parts[1].trim();
        Arrays.asList(parts[0].split(" "))
                .forEach(part -> card.winningNumbers.add(Integer.parseInt(part.trim())));
        Arrays.asList(parts[1].split(" "))
                .forEach(part -> card.cardNumbers.add(Integer.parseInt(part.trim())));
        return card;
    }

    public static Card calculateWins(Card card) {
        for (Integer cardNumber : card.cardNumbers) {
            for (Integer winningNumber : card.winningNumbers) {
                if (cardNumber.equals(winningNumber))
                    card.wins++;
            }
        }
        return card;
    }

    public static List<Card> multipleCardsForWins(List<Card> cards, Card card) {

        int iteration = card.wins;
        int cardIndex = card.id - 1;

        for (int j = 0; j < card.amount; j++) {
            for (int i = iteration; i > 0; i--) {
                if (cardIndex + i <= cards.size()) {
                    cards.get(cardIndex + i).amount++;
                }
            }

        }
        return cards;
    }



}


