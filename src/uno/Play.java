package uno;

import ca.sheridancollege.project.Card;
import ca.sheridancollege.project.GroupOfCards;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import ca.sheridancollege.project.Player;

/**
 * This is an uno game.
 *
 * @author rana , 2022
 * @author jobanpreet , 2022
 * @author mehakpreet , 2022
 */
public class Play {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("What is your name: ");
        String name = input.nextLine();

        UnoGame game = new UnoGame("UNO");

        // Main Game Loop
        do {
            System.out.println("Generating Deck...");
            GroupOfCards deck = new GroupOfCards(false, null);
            deck.shuffle();

            System.out.println("Giving cards to you...");
            Player player = new Player(name);
            GroupOfCards playerDeck = new GroupOfCards(true, deck.showCards());

            System.out.println("Giving cards to the computer...");
            Player computer = new Player("computer");
            GroupOfCards computerDeck = new GroupOfCards(true, deck.showCards());

            boolean move = true;
            Card currentCard;
            while (true) {
                currentCard = deck.showCards().get(0);
                if (currentCard.toString().split(" ")[1].length() == 1) {
                    currentCard = deck.pop(0);
                    break;
                } else {
                    deck.shuffle();
                }
            }

            // Round Loop
            while (deck.getSize() > 0 && playerDeck.getSize() > 0 && computerDeck.getSize() > 0) {

                System.out.println("Card on top of discard pile: " + currentCard);

                if (move) {
                    System.out.println("Your deck:");
                    printPlayerDeck(playerDeck.showCards());
                    System.out.print("Make a selection (-1 to draw): ");
                    
                    int selection = input.nextInt();

                    // Player wants to pass
                    if (selection == -1) {
                        playerDeck.push(deck.pop(0));
                        move = false;
                        continue;
                    }

                    Card card;
                    try {
                        card = playerDeck.showCards().get(selection);
                    } catch (Exception e) {
                        System.out.println("Invalid Selection");
                        continue;
                    }

                    // See if the move is valid
                    boolean valid = player.checkMove(card, currentCard);
                    if (valid) {
                        System.out.println("Valid Move!");

                        currentCard = playerDeck.pop(selection);
                        if (currentCard.toString().split(" ")[1].contentEquals("wild")
                                || currentCard.toString().split(" ")[1].contentEquals("+4")) {
                            while (true) {
                                System.out.println("Select a color:");
                                String colors[] = {"red", "green", "blue", "yellow"};
                                for (int k = 0; k < 4; k++) {
                                    System.out.println("  " + k + ": " + colors[k]);
                                }
                                System.out.println("");
                                int colorChoice = input.nextInt();
                                if (colorChoice < 0 || colorChoice > 4) {
                                    System.out.println("Invalid Selection");
                                    continue;
                                }
                                String color = colors[colorChoice];
                                currentCard.setColor(color);
                                break;
                            }
                        }
                        // This would be false in the case of skip or reverse
                        boolean done = player.play(computerDeck, currentCard, deck);

                        if (done) {
                            move = false;
                        }

                    } else {
                        System.out.println("Invalid Move!");
                    }

                } else {
                    System.out.println("Computer making a move...");

                    Card card = null;
                    for (int j = 0; j < computerDeck.getSize(); j++) {
                        boolean valid = computer.checkMove(computerDeck.showCards().get(j), currentCard);
                        if (valid) {
                            card = computerDeck.pop(j);
                            break;
                        }
                    }

                    if (card != null) {
                        currentCard = card;

                        if (currentCard.toString().split(" ")[1].contentEquals("wild")
                                || currentCard.toString().split(" ")[1].contentEquals("+4")) {
                            String colors[] = {"red", "green", "blue", "yellow"};
                            Random rand = new Random();
                            int colorSelection = rand.nextInt(4);
                            currentCard.setColor(colors[colorSelection]);
                        }

                        boolean done = computer.play(playerDeck, currentCard, deck);

                        if (done) {
                            System.out.println("Computer placed a " + currentCard.toString());
                            move = true;
                        }
                    } else {
                        System.out.println("Computer is drawing a card...");
                        computerDeck.push(deck.pop(0));
                        move = true;
                    }

                }

            }

            game.declareWinner(playerDeck, computerDeck, false);

            System.out.println(player.getPlayerID() + " Score: " + game.getPlayerScore());
            System.out.println("Computer Score: " + game.getComputerScore());

            System.out.println("Do you want to play again? (Y)");
            String selection = input.next();

            if (selection.toUpperCase().contentEquals("Y")) {
                continue;
            } else {
                game.declareWinner(playerDeck, computerDeck, true);
                break;
            }
        } while (true);

        input.close();
    }

    private static void printPlayerDeck(ArrayList<?> array) {
        int i = 0;
        for (Object item : array) {
            System.out.println("  " + i + ": " + item.toString());
            i++;
        }
    }
}
