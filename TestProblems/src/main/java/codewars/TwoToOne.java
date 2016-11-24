package codewars;

import java.util.Set;
import java.util.TreeSet;

public class TwoToOne {

    public static String longest(String s1, String s2) {
        Set<Character> uniqueChars = new TreeSet<>();

        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        for (Character c : arr1) {
            if (!uniqueChars.contains(c)) {
                uniqueChars.add(c);
            }
        }

        for (Character c : arr2) {
            if (!uniqueChars.contains(c)) {
                uniqueChars.add(c);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (Character c : uniqueChars) {
            sb.append(c);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public static void main(String[] args) {
        longest("abc", "abz");
    }
}