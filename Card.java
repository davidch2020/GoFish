import java.util.Random;

public class Card {
    int[] playerCards = new int[5];
    int[] playerSuites = new int[5];
    int[] computerCards = new int[5];
    int[] computerSuites = new int[5];
    int randomNum;
    boolean stillLooking = true;

    Random randomNumGenerator = new Random();

    public Card() {
       for (int i = 0; i < playerCards.length; i++) {
            createRandomNum(i);
        }   
    }
    
    void createRandomNum(int i) {
        int cardRandomNum = 0;
        int suitesRandomNum = 0;
        
        while (stillLooking) {
            cardRandomNum = randomNumGenerator.nextInt(13) + 1;
            //playerCards[i] = cardRandomNum;
            suitesRandomNum = randomNumGenerator.nextInt(4) + 1;
            //playerSuites[i] = suitesRandomNum;
            stillLooking = false;
            for (int x = 0; x < 5; x++) {
                if (playerCards[x] == cardRandomNum && playerSuites[x] == suitesRandomNum) {
                    stillLooking = true;
                } 
            }
        }

        playerCards[i] = cardRandomNum;
        playerSuites[i] = suitesRandomNum;
    }

}
