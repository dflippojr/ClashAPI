import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * Daniel Flippo, 4/26/2024
 * Represents a Deck of cards.
 * 1. Populates Deck
 * 2. Shuffles Deck
 * 3. Sorts Deck by rank
 * 4. Sorts Deck by suit
 */
public class DeckOfCards {

    // Define suits
    final static String[] suits = {"SPADES", "HEARTS", "DIAMONDS", "CLUBS"};
    // Define ranks
    final static String[] ranks = {"TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN", "JACK", "QUEEN", "KING", "ACE"};
        

    public static class Card {
        // Attributes
        private final String suit;
        private final String rank;
        // rank value used for sorting
        private final int rankValue;
        
        // Constructor
        public Card(String suit, String rank, int rankValue) {
            this.suit = suit;
            this.rank = rank;
            this.rankValue = rankValue;
        }

        // will be printing the cards a lot so let's define a toString
        @Override
        public String toString() {
            return this.rank + " of " + this.suit;
        }
    }

    // Create the deck of cards
    public static List<Card> createDeck() {
        List<Card> deck = new ArrayList<>();

        // Populate Cards
        for (String suit : suits) {
            for (int i = 0; i < ranks.length; i++) {
                String rank = ranks[i];
                deck.add(new Card(suit, rank, i + 2));
            }
        }

        return deck;
    }

    // Print the deck
    public static void printDeck(List<Card> deck) {
        for (Card card : deck) {
            System.out.println(card);
        }
    }

    // create rank comparator
    public static class RankComparator implements Comparator<Card> {
        @Override
        public int compare(Card c1, Card c2) {
            return Integer.compare(c2.rankValue, c1.rankValue);
        }
    };

    /* 
     * create suit comparator
     * We don't care about order of the suits I assume,
     * so just comparing string values 
     */
    public static class SuitComparator implements Comparator<Card> {  
        @Override
        public int compare(Card c1, Card c2) {
            return c1.suit.compareTo(c2.suit);
        }
    };

    public static void main(String[] args) {
        List<Card> deck = createDeck();
        System.out.println(deck.size() + " cards in deck.\n");

        Collections.shuffle(deck);
        System.out.println("Shuffled Deck:\n");
        printDeck(deck);

        deck.sort(new RankComparator());
        System.out.println("\nSorted by Rank:\n");
        printDeck(deck);

        deck.sort(new SuitComparator());
        System.out.println("\nSorted by Suit:\n");
        printDeck(deck);
    }
}