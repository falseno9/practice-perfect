package hackerrank;

/**
 * Created by Kunal on 11/26/2016.
 */
public class Staircase {

    static void stairCase(int n) {
        for (int i = 0; i < n && (n - i - 1) > 0; i++) {
            System.out.println(String.format("%0" + (n - i - 1) + "d", 0).replace("0", " ") + String.format("%0" + (i + 1) + "d", 0).replace("0", "#"));
        }
        System.out.println((String.format("%0" + n + "d", 0).replace("0", "#")));
    }

    public static void main(String[] args) {
        stairCase(100);
    }
}
