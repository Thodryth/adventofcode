package adventofcode2023.day7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import defaults.Reader;

public class Day7 {

    public static int TEST_TOTAL_WINNINGS = 6440;

    public static void main(String[] args) {

        Reader reader = new Reader();

        var puzzleInput = reader.loadFileToArray("adventofcode2023/day7/puzzleInput");
        var testInput = reader.loadFileToArray("adventofcode2023/day7/testInput");

        run(testInput, "test");

        // run(puzzleInput, "puzzle");
    }

    public static void run(String[] input, String type) {
        System.out.println("- Run code against " + type);
        List<Hand> hands = fillHands(input);
        hands.forEach(hand -> {
            System.out.println("Card: " + hand.rank);
            System.out.println("Hand: " + hand.getCards() + " Bid: " + hand.bid + " Type: " + hand.type);
            hand.calculateType();
        });
        System.out.println(input[0]);
    }

    public static List<Hand> fillHands(String[] lines) {
        List<Hand> hands = new ArrayList<>();

        int i = 0;
        for (String line : lines) {
            Hand hand = new Hand();
            String[] split = line.split(" ");
            hand.bid = Integer.parseInt(split[1]);
            hand.cards = mapCharToNumber(split[0].toCharArray(), hand);
            hand.rank = i + 1;
            hand.calculateType();
            hands.add(hand);
            i++;
        }
        sortByType(hands);
        for (int j = 0; j < hands.size(); j++) {
            hands.get(j).rank = j + 1;
        }
        return hands;
    }

    public static int[] mapCharToNumber(char[] cards, Hand hand) {
        int[] mappedCards = new int[5];
        for (int i = 0; i < cards.length; i++) {
            if (Character.isDigit(cards[i])) {
                mappedCards[i] = Character.getNumericValue(cards[i]);
            } else {
                switch (cards[i]) {
                    case 'A':
                        mappedCards[i] = 13;
                        break;
                    case 'K':
                        mappedCards[i] = 13;
                        break;
                    case 'Q':
                        mappedCards[i] = 12;
                        break;
                    case 'J':
                        mappedCards[i] = 11;
                        break;
                    case 'T':
                        mappedCards[i] = 10;
                        break;
                    default:
                        break;
                }
            }
            hand.addCard(String.valueOf(cards[i]));
        }
        return mappedCards;
    }

    public static void sortByType(List<Hand> hands) {
        Collections.sort(hands, (o1, o2) -> (Integer.valueOf(o1.type.value).compareTo(o2.type.value)));
    }

    public static Hand getHandType(Hand hands) {

        return hands;
    }

}
