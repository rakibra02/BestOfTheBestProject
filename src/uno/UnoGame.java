package uno;

import ca.sheridancollege.project.Game;
import ca.sheridancollege.project.GroupOfCards;

/**
 *
 * @author rana , 2022
 * @author jobanpreet , 2022
 * @author mehakpreet , 2022
 */
public class UnoGame extends Game {

    private int playerScore;
    private int computerScore;

    public UnoGame(String name) {
        super(name);
        this.playerScore = 0;
        this.computerScore = 0;
    }

    @Override
    public void play() {
        // TODO Auto-generated method stub

    }

    public int getPlayerScore() {
        return this.playerScore;
    }

    public int getComputerScore() {
        return this.computerScore;
    }

    @Override
    public void declareWinner(GroupOfCards playerDeck, GroupOfCards computerDeck, boolean gameEnd) {

        boolean playerWinner = playerDeck.getSize() < computerDeck.getSize();
        if (!gameEnd) {
            if (playerWinner) {
                System.out.println("You won this round!");
                this.playerScore++;
            } else {
                System.out.println("Computer won this round.");
                this.computerScore++;
            }
        } else {
            if (playerWinner) {
                System.out.println("You won the game!");
                playerScore++;
            } else {
                System.out.println("Computer won the game :( .");
                computerScore++;
            }

        }
    }
}
