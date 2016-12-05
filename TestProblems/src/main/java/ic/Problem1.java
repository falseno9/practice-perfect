package ic;

/**
 * Created by Kunal on 11/30/2016.
 */
public class Problem1 {

    public static int getMaxProfit(int[] stockPricesYesterday) {



/*        for (int i = 0; i < stockPricesYesterday.length; i++) {
            for (int j = i + 1; j < stockPricesYesterday.length; j++) {
                Integer currProfit = stockPricesYesterday[j] - stockPricesYesterday [i];
                if(currProfit > maxProfit) {
                    maxProfit = currProfit;
                }
            }
        }*/
        int maxProfit = stockPricesYesterday[1] - stockPricesYesterday[0];
        int lowestPrice = stockPricesYesterday[0];

        for (int i = 1; i < stockPricesYesterday.length; i++) {
            int currentPrice = stockPricesYesterday[i];

            int potentialProfit = currentPrice - lowestPrice;

            maxProfit = Math.max(maxProfit, potentialProfit);

            lowestPrice = Math.min(lowestPrice, currentPrice);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(getMaxProfit(new int[]{10, 7, 5, 8, 11, 9}));
        System.out.println(getMaxProfit(new int[]{20, 14, 13, 9, 4, 1}));
    }
}
