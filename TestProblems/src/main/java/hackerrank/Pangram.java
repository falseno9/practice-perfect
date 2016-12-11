package hackerrank;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

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

    public static String listMissingLetters(String s) {

        TreeSet<Character> allChars = new TreeSet<>();
        allChars.add('a');
        allChars.add('b');
        allChars.add('c');
        allChars.add('d');
        allChars.add('e');
        allChars.add('f');
        allChars.add('g');
        allChars.add('h');
        allChars.add('i');
        allChars.add('j');
        allChars.add('k');
        allChars.add('l');
        allChars.add('m');
        allChars.add('n');
        allChars.add('o');
        allChars.add('p');
        allChars.add('q');
        allChars.add('r');
        allChars.add('s');
        allChars.add('t');
        allChars.add('u');
        allChars.add('v');
        allChars.add('w');
        allChars.add('x');
        allChars.add('y');
        allChars.add('z');

        for (char c : s.toCharArray()) {
            int ascii = Character.toLowerCase(c);
            if (ascii >= 'a' || ascii <= 'z') {
                if (allChars.contains(c)) {
                    allChars.remove(c);
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (Character c : allChars) {
            result.append(c);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        //System.out.println(isPangram(new String[]{"the quick brown fox jumps over the lazy dog"}));
        System.out.println(listMissingLetters("A quick brown fox jumps over the lazy dog"));
        System.out.println(listMissingLetters("Four score and seven years ago."));
        System.out.println(listMissingLetters("To be or not to be, that is the question!"));
        System.out.println(listMissingLetters(""));
    }

}
