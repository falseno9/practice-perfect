package ic;

/**
 * Created by Kunal on 12/6/2016.
 */
public class Problem5 {

    private static int computePossibilities(int amt, int[] denominations) {
        return changePossibilities(amt, denominations, 0);
    }

    private static int changePossibilities(int amt, int[] denominations, int currentIndex) {
        if (amt == 0) {
            return 1;
        }

        if (amt < 0) {
            return 0;
        }

        if (currentIndex == denominations.length) {
            return 0;
        }

        int currentCoin = denominations[currentIndex];

        int numPossibilities = 0;
        while (amt >= 0) {
            numPossibilities += changePossibilities(amt, denominations, currentIndex + 1);
            amt -= currentCoin;
        }
        return numPossibilities;
    }

}
