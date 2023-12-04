package adventofcode2023.day4;

import java.util.ArrayList;
import java.util.List;

public class Card {
    int id;
    int wins = 0;
    int amount = 1;
    List<Integer> winningNumbers = new ArrayList<>();
    List<Integer> cardNumbers = new ArrayList<>();

    public Card() {}

    public Card(Card card) {
        this.id = card.id;
        this.wins = card.wins;
        this.winningNumbers = card.winningNumbers;
        this.cardNumbers = card.cardNumbers;
    }


    public int getValue() {
        if (wins == 0) {
            return 0;
        }
        int value = 1;

        int counter = wins - 1;
        while (counter > 0) {
            value = value * 2;
            counter--;
        }
        return value * amount;
    }

    public String toString() {
        return "Card " + this.id + " - Wins: " + wins + " - Amount: " + amount;
    }

    public int getAmount() {
        return this.amount;
    }
}

