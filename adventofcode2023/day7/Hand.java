package adventofcode2023.day7;

import java.util.HashMap;
import java.util.Map;

/**
 * Hand
 */
public class Hand {

    int rank;
    int bid;
    int[] cards = new int[5];
    Map<String, Integer> cardMap = new HashMap<>();
    Type type;

    enum Type {
        FIVE(5),
        FOUR(4),
        FULL_HOUSE(3),
        THREE(2),
        TWO(1),
        HIGHEST(0);

        final int value;
        
        Type(int value) {
            this.value = value;
        }

        int getValue() {
            return this.value;
        }
    }

    Hand() {
        cardMap.put("2", 0);
        cardMap.put("3", 0);
        cardMap.put("4", 0);
        cardMap.put("5", 0);
        cardMap.put("6", 0);
        cardMap.put("7", 0);
        cardMap.put("8", 0);
        cardMap.put("9", 0);
        cardMap.put("T", 0);
        cardMap.put("J", 0);
        cardMap.put("Q", 0);
        cardMap.put("K", 0);
        cardMap.put("A", 0);
    }

    String getCards() {
        String printableCards = "";
        for (int card = 0; card < cards.length; card++) {
            printableCards += cards[card] + " ";
        }
        return printableCards;
    }

    void addCard(String key) {
        cardMap.put(key, cardMap.get(key) + 1);
    }

    void calculateType() {
        if (cardMap.containsValue(1))
            type = Type.HIGHEST;
        if (cardMap.containsValue(2))
            type = Type.TWO;
        if (cardMap.containsValue(3))
            type = Type.THREE;
        if (cardMap.containsValue(3) && cardMap.containsValue(2))
            type = Type.FULL_HOUSE;
        if (cardMap.containsValue(4))
            type = Type.FOUR;
        if (cardMap.containsValue(5))
            type = Type.FIVE;
    }

}