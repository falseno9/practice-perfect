package hackerrank;

import java.io.IOException;

/**
 * Created by Kunal on 11/26/2016.
 */
public class IsNumbers {

    static boolean is_number(String toTest) {
        boolean hasNonZeroChar = false;
        boolean hasZero = false;
        int isDecimal = 0;

        if (toTest == null) {
            return false;
        }

        if (toTest.charAt(toTest.length() - 1) == '.') {
            return false;
        }

        for (int i = 0; i < toTest.length(); i++) {
            char c = toTest.charAt(i);


            if (c == '.') {
                isDecimal++;
                if (isDecimal > 2) {
                    return false;
                }
                continue;
            } else if (c >= '1' && c < '9') {
                hasNonZeroChar = true;
            } else if (c == '0') {
                hasZero = true;
                if (!hasNonZeroChar) {
                    if (i < toTest.length() - 1) {
                        if (toTest.charAt(i + 1) == '.' || isDecimal > 0) {
                            continue;
                        } else {
                            return false;
                        }
                    } else if (toTest.length() == 1) {
                        return true;
                    } else {
                        break;
                    }
                }
            } else if (c == '-') {
                if (i != 0) {
                    return false;
                }
            } else {
                return false;
            }
        }
        if (!hasNonZeroChar && !hasZero) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println(is_number("1."));
    }
}
