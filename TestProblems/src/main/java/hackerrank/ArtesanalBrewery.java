package hackerrank;

import java.util.Scanner;

/**
 * Created by Kunal on 12/4/2016.
 */
public class ArtesanalBrewery {

    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);

        int numTestCases = in.nextInt();
        for (int i = 0; i < numTestCases; i++) {
            int moneyInWallet = in.nextInt();
            int price = in.nextInt();
            int bottleCaps = in.nextInt();
            countBeers(moneyInWallet, price, bottleCaps);
        }
    }

    private static void countBeers(int moneyInWallet, int price, int capsTraded) {

        int beers = moneyInWallet / price;
        int numCaps = beers;

        while (numCaps / capsTraded > 0) {
            int freeBeers = numCaps / capsTraded;
            beers += freeBeers;
            numCaps = numCaps % capsTraded;
            numCaps += freeBeers;
        }
        System.out.println(beers);
    }
}
