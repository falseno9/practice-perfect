package ic;

import java.util.Arrays;

/**
 * Created by Kunal on 11/30/2016.
 */
public class Problem2 {

    private static int[] getProductsOfAllIntsExceptAtIndex(int[] arr) {

        int[] productsExceptAtIndex = new int[arr.length];

        int currProduct = 1;

        for (int i = 0; i < arr.length; i++) {
            productsExceptAtIndex[i] = currProduct;
            currProduct *= arr[i];
        }
        currProduct = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            productsExceptAtIndex[i] *= currProduct;
            currProduct *= arr[i];
        }
        return productsExceptAtIndex;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getProductsOfAllIntsExceptAtIndex(new int[]{1, 7, 3, 4})));
    }
}
