package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;
import uno.ActionCard;
import uno.NumberCard;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you
 * might want to subclass this more than once. The group of cards has a maximum
 * size attribute which is flexible for reuse.
 *
 * @author dancye , 2018
 * @author rana , 2022
 * @author jobanpreet , 2022
 * @author mehakpreet , 2022
 */
public class GroupOfCards {

    // The group of cards, stored in an ArrayList
    private ArrayList<Card> cards;
    private int size;// the size of the grouping
    private boolean isPlayerDeck;

    public GroupOfCards(boolean isPlayerDeck, ArrayList<Card> deck) {
        this.isPlayerDeck = isPlayerDeck;

        // Create the deck
        cards = new ArrayList<Card>();

        if (isPlayerDeck) {
            for (int i = 0; i < 7; i++) {
                this.cards.add(deck.remove(0));
            }

            this.size = this.cards.size();
            return;
        }

        String colors[] = {"red", "yellow", "green", "blue"};

        for (String color : colors) {
            for (int i = 0; i < 10; i++) {
                if (i == 0) {
                    this.cards.add(new NumberCard(color, i));
                } else {
                    this.cards.add(new NumberCard(color, i));
                    this.cards.add(new NumberCard(color, i));
                }
            }

            // Skip
            this.cards.add(new ActionCard(color, "skip"));
            this.cards.add(new ActionCard(color, "skip"));

            // Reverse
            this.cards.add(new ActionCard(color, "reverse"));
            this.cards.add(new ActionCard(color, "reverse"));

            // +2
            this.cards.add(new ActionCard(color, "+2"));
            this.cards.add(new ActionCard(color, "+2"));
        }

        // Wild card and + 4
        for (int j = 0; j < 4; j++) {
            this.cards.add(new ActionCard("", "wild"));
            this.cards.add(new ActionCard("", "+4"));
        }

        this.size = this.cards.size();

        return;
    }

    /**
     * A method that will get the group of cards as an ArrayList
     *
     * @return the group of cards.
     */
    public ArrayList<Card> showCards() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return cards.size();
    }

    /**
     * @param givenSize the max size for the group of cards
     */
    public void setSize(int givenSize) {
        size = givenSize;
    }

    public Card pop(int index) {
        return this.cards.remove(index);
    }

    public void push(Card card) {
        this.cards.add(card);
    }

}// end class
