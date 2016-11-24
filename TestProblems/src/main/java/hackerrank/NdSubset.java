package hackerrank;

import java.util.*;

/**
 * https://www.hackerrank.com/challenges/non-divisible-subset
 */
public class NdSubset {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int setSize = in.nextInt();
        int k = in.nextInt();

        List<Integer> inputData = new ArrayList<Integer>();
        Map<Integer, Integer> remainders = new HashMap<Integer, Integer>();
        for (int i = 0; i < setSize; i++) {
            inputData.add(in.nextInt());
        }

        for (Integer input : inputData) {
            int remainder = input % k;
            if (remainders.containsKey(remainder)) {
                remainders.put(remainder, remainders.get(remainder) + 1);
            } else {
                remainders.put(remainder, 1);
            }
        }

        for (Integer remainder : remainders.keySet()) {
            int pair = remainder - k;
            if (remainders.containsKey(pair)) {
                if (remainders.get(remainder) <= remainders.get(pair)) {
                    remainders.remove(pair);
                } else {
                    remainders.remove(remainder);
                }
            }
        }

        System.out.println(remainders.size());
    }
}
