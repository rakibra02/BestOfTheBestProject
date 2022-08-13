package uno;

import ca.sheridancollege.project.Card;

/**
 *
 * @author rana , 2022
 * @author jobanpreet , 2022
 * @author mehakpreet , 2022
 */
public class ActionCard extends Card {

    private String color;
    private String type;

    /**
     *
     * @param color
     * @param type
     */
    public ActionCard(String color, String type) {
        this.color = color;
        this.type = type;
    }

    /**
     *
     * @return color and type
     */
    @Override
    public String toString() {
        return this.color + ' ' + this.type;
    }

    /**
     *
     * @param color
     */
    @Override
    public void setColor(String color) {
        this.color = color;
    }

}
