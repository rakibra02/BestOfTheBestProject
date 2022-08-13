package ca.sheridancollege.project;

/**
 * A class that models each Player in the game. Players have an identifier,
 * which should be unique.
 *
 * @author dancye , 2018
 * @author rana , 2022
 * @author jobanpreet , 2022
 * @author mehakpreet , 2022
 */
public class Player {

    private String playerID; // the unique ID for this player

    /**
     * A constructor that allows you to set the player's unique ID
     *
     * @param name the unique ID to assign to this player.
     */
    public Player(String name) {
        playerID = name;
    }

    /**
     * @return the playerID
     */
    public String getPlayerID() {
        return playerID;
    }

    /**
     * Ensure that the playerID is unique
     *
     * @param givenID the playerID to set
     */
    public void setPlayerID(String givenID) {
        playerID = givenID;
    }

    /**
     * The method to be instantiated when you subclass the Player class with
     * your specific type of Player and filled in with logic to play your game.
     */
    public boolean play(GroupOfCards opponentDeck, Card currentCard, GroupOfCards deck) {

        String data[] = currentCard.toString().split(" ");

        if (data[1].length() == 1) {
            return true;
        } else if (data[1].contentEquals("skip") || data[1].contentEquals("reverse")) {
            return false;
        } else if (data[1].contentEquals("wild")) {
            return true;
        } else if (data[1].contentEquals("+2")) {
            for (int i = 0; i < 2; i++) {
                opponentDeck.push(deck.pop(0));
            }

            return true;
        } else if (data[1].contentEquals("+4")) {
            for (int i = 0; i < 4; i++) {
                opponentDeck.push(deck.pop(0));
            }

            return true;
        }

        return false;
    }

    public boolean checkMove(Card playerCard, Card currentCard) {
        String card[] = playerCard.toString().split(" ");
        String data[] = currentCard.toString().split(" ");

        if (card[0].contentEquals(data[0]) || card[1].contentEquals(data[1])) {
            return true;
        }

        if (card[1].contentEquals("wild") || card[1].contentEquals("+4")) {
            return true;
        }

        return false;
    }

}
