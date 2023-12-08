package adventofcode2023.day7;

/**
 * Hand
 */
public class Hand {

    int bid;
    int[] cards = new int[5];

    String getCards() {
        String printableCards = "";
        for (int card = 0; card < cards.length; card++) {
            printableCards += cards[card] + " ";
        }
        return printableCards;
    }

    void printAsciiValues() {
        for (int card = 0; card < cards.length; card++) {
            System.out.println(
                    cards[card]);
        }
    }

}