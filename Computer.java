import java.util.Random;

public class Computer {
    int randomCardNum;
    int randomSuite;
    int[][] sameCards = new int[5][5];

    public String computerGuess(int[] playerCardNums, int[] playerSuites, int computerGuessNum, int computerGuessSuite) {
        int x = 0;
        for (int i = 0; i < playerCardNums.length; i++) {
            if (playerCardNums[i] == computerGuessNum && playerSuites[i] == computerGuessSuite) {
                return "Good job!";
            }
        }
        return "Go fish!";
    }
}
