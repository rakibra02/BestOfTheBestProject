package uno;

import ca.sheridancollege.project.Card;

/**
 *
 * @author ranoo
 */
public class NumberCard extends Card {

    private String color;
    private int value;

    public NumberCard(String color, int value) {
        this.color = color;
        this.value = value;
    }

    public String toString() {
        return this.color + ' ' + String.valueOf(value);
    }

    public void setColor(String color) {
        this.color = color;
    }
}
