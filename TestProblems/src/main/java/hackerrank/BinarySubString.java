package hackerrank;

/**
 * Created by Kunal on 12/10/2016.
 */
public class BinarySubString {

    static int counting(String s) {

        int index = 0;
        int totalSubstringCount = 0;
        while (index < s.length()) {

            char ch = s.charAt(index);
            int currIndex = index;
            int chCount = 0;
            if (index + 1 < s.length() && ch != s.charAt(index + 1)) {
                System.out.println("Incrementing total count");
                totalSubstringCount++;
            } else {
                while (currIndex < s.length() && ch == s.charAt(currIndex)) {
                    chCount++;
                    currIndex++;
                }
                if (currIndex < s.length()) {
                    ch = s.charAt(currIndex);
                }
                while (currIndex < s.length() && ch == s.charAt(currIndex)) {
                    chCount--;
                    if (chCount == 0) {
                        System.out.println("Incrementing total count here");
                        totalSubstringCount++;
                        break;
                    }
                    currIndex++;
                }
            }
            index++;
        }
        return totalSubstringCount;
    }

    public static void main(String[] args) {
        System.out.println(counting("000111"));
    }

}
