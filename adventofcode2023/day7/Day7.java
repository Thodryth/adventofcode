package adventofcode2023.day7;

import java.util.ArrayList;
import java.util.Arrays;
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
            System.out.println("Hand: " + hand.getCards() + " Bid: " + hand.bid);
            System.out.println("CARD: ");

            hand.printAsciiValues();
        });
        System.out.println(input[0]);
    }

    public static List<Hand> fillHands(String[] lines) {
        List<Hand> hands = new ArrayList<>();

        for (String line : lines) {
            Hand hand = new Hand();
            String[] split = line.split(" ");
            hand.bid = Integer.parseInt(split[1]);
            hand.cards = mapCharToNumber(split[0].toCharArray());
            hands.add(hand);
        }
        return hands;
    }

    public static int[] mapCharToNumber(char[] hand) {
        int[] mappedCards = new int[5];
        for (int i = 0; i < hand.length; i++) {
            if (Character.isDigit(hand[i])) {
                mappedCards[i] = Character.getNumericValue(hand[i]);
            } else {
                switch (hand[i]) {
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
        }
        Arrays.sort(mappedCards);
        return mappedCards;
    }

    public static List<Hand> sortHandCards(List<Hand> hands) {

        return hands;
    }

}
