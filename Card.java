import java.util.Random;

public class Card {
    int[] playerCards = new int[5];
    int[] playerSuites = new int[5];
    int[] computerCards = new int[5];
    int[] computerSuites = new int[5];
    int randomNum;

    Random randomNumGenerator = new Random();

    public Card() {
        for (int i = 0; i < playerCards.length; i++) {
            randomNum = randomNumGenerator.nextInt(13) + 1;
            playerCards[i] = randomNum;
            randomNum = randomNumGenerator.nextInt(13) + 1;
            computerCards[i] = randomNum;
            randomNum = randomNumGenerator.nextInt(4) + 1;
            playerSuites[i] = randomNum;
            randomNum = randomNumGenerator.nextInt(4) + 1;
            computerSuites[i] = randomNum;
        }    
    }

}
