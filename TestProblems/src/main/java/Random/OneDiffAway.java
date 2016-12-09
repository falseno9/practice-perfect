package Random;

/**
 * Created by Kunal on 12/7/2016.
 */
public class OneDiffAway {

    private static boolean oneDiffAway(String s1, String s2) {

        int s1Length = s1.length();
        int s2Length = s2.length();

        if (Math.abs(s1Length - s2Length) > 1) {
            return false;
        }
        int i = 0, j = 0;
        int diffCount = 0;
        for (; i < s1Length && j < s2Length; i++, j++) {
            if (s1.charAt(i) != s2.charAt(j)) {
                if (diffCount < 2) {
                    diffCount++;
                } else {
                    return false;
                }
            }
        }
        if (Math.abs(i - s1Length) > 1 || Math.abs(j - s2Length) > 1) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(oneDiffAway("car", "cas"));
        System.out.println(oneDiffAway("car", "cart"));
        System.out.println(oneDiffAway("car", "caret"));
    }
}
