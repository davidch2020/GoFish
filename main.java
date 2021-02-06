import java.util.Scanner;
import java.util.Random;
import org.apache.commons.lang3.ArrayUtils;

public class main {


    public static void main(String[] args) { 
        System.out.println("Welcome to Go Fish!");

        int computerPts = 0;
        int playerPts = 0;
        int cardNum = 14;
        boolean allowedSuite = false;
        boolean cardNumInList = false;
        int cardSuite = 0;
        boolean inDeck = false;

        Card cards = new Card();
        Computer computer = new Computer();
        Scanner getUserInput = new Scanner(System.in);
        Random randomNumGenerator = new Random();

        int[] playerCards = cards.playerCards;
        int[] computerCards = cards.computerCards;
        int[] playerSuites = cards.playerSuites;
        int[] computerSuites = cards.computerSuites;
        String[] allowedSuites = new String[]{"diamonds", "spades", "clubs", "hearts"};
        
        boolean goOn = true;
        while (goOn) {
            cardNum = 14;
            allowedSuite = false;
            System.out.println("Your Deck...");
            for (int i = 0; i < 5; i++) {
                System.out.println(playerCards[i] + " " + allowedSuites[playerSuites[i] - 1]);
            }

            while (cardNum > 13 || !cardNumInList) {
                System.out.println("Enter Card Number (Less Than 14)");
                String cardNumString = getUserInput.nextLine(); 
                cardNum = Integer.parseInt(cardNumString);

                for (int i = 0; i < playerCards.length; i++) {
                    if (playerCards[i] == cardNum) {
                        cardNumInList = true;
                        break;
                    }
                }
            }

            while (!allowedSuite) {
                System.out.println("Enter Card Suite (1-diamonds, 2-spades, 3-clubs, 4-hearts)");
                String oldCardSuite = getUserInput.nextLine();
                cardSuite = Integer.parseInt(oldCardSuite);
                
                for (int i = 0; i < (allowedSuites.length + 1); i++) {
                    if (cardSuite == playerSuites[i]) {
                        allowedSuite = true;
                        break;
                    }
                }
            }

            for (int i = 0; i < 5; i++) {
                if (cardSuite == computerSuites[i] && cardNum == computerCards[i]) {
                    inDeck = true;
                } else {
                    inDeck = false;
                }
            }

            if (inDeck) {
                System.out.println("Good job!");
                goOn = false;
            } else {
                System.out.println("Go fish!");
                System.out.println();
            }

            int computerGuessNum = randomNumGenerator.nextInt(13) + 1;
            int computerGuessSuite = randomNumGenerator.nextInt(3) + 1;
            System.out.println(Integer.toString(computerGuessNum) + " " + allowedSuites[computerGuessSuite]);

            System.out.println(computer.computerGuess(playerCards, playerSuites, computerGuessNum, computerGuessSuite));
        } 
    }
        
}
