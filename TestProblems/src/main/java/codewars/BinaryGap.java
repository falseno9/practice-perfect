package codewars;

/**
 * Created by Kunal on 11/27/2016.
 */
public class BinaryGap {

    public static int solution(int N) {

        String binary = Integer.toBinaryString(N);

        int numZero = 0;
        int currZero = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '0') {
                currZero++;
                if (currZero > numZero) {
                    numZero = currZero;
                }
            } else {
                currZero = 0;
            }
        }
        return numZero;
    }

    public static void main(String[] args) {
        solution(1041);
    }
}
