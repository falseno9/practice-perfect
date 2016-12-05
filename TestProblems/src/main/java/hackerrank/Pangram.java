package hackerrank;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Kunal on 12/4/2016.
 */
public class Pangram {
    private static final String IS_PANGRAM = "1";
    private static final String IS_NOT_PANGRAM = "0";

    static String isPangram(String[] strings) {
        StringBuilder result = new StringBuilder();
        for (String string : strings) {
            Set<Character> charOccurred = new HashSet<>();
            for (int i = 0; i < string.length(); i++) {
                Character currChar = string.charAt(i);
                if (currChar != ' ') {
                    charOccurred.add(currChar);
                }
            }
            result.append(charOccurred.size() == 26 ? IS_PANGRAM : IS_NOT_PANGRAM);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(isPangram(new String[]{"the quick brown fox jumps over the lazy dog"}));
    }

}
