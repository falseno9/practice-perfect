package Random;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class CommonBond {

    private static final Character LEFT_SHRAPNEL = '<';
    private static final Character RIGHT_SHRAPNEL = '>';
    private static final Character BOTH_SHRAPNEL = 'X';
    private static final Character BOMB = 'B';

    /**
     * Given a string s, return all characters in alphabetical order
     * which prevent string s from being a pangram
     *
     * @param s String parameter input to check for missing characters which prevent it from being a pangram
     * @return all the characters missing
     */
    public String listMissingLetters(String s) {

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
            Character lowerC = Character.toLowerCase(c);
            int ascii = lowerC;
            if (ascii >= 'a' || ascii <= 'z') {
                if (allChars.contains(lowerC)) {
                    allChars.remove(lowerC);
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (Character c : allChars) {
            result.append(c);
        }
        return result.toString();
    }

    /**
     * Method to display explosion of bomb per unit time
     *
     * @param bombs String of initial bomb positions
     * @param force Integer value by which shrapnel explodes
     * @return array of strings representing movement of shrapnel per unit time until all shrapnel has exploded
     */
    public String[] explode(String bombs, int force) {

        if (bombs == null) {
            throw new IllegalArgumentException("Bombs provided is null");
        }

        if (bombs.length() < 1 || bombs.length() > 50) {
            throw new IllegalArgumentException("bombs must be between 1 to 50 characters in length");
        }

        if (force < 1 || force > 10) {
            throw new IllegalArgumentException("force must be between 1 to 10");
        }

        List<String> result = new ArrayList<>();
        result.add(bombs);

        char[] currentShrapnel = new char[bombs.length()];
        for (int i = 0; i < bombs.length(); i++) {
            currentShrapnel[i] = '.';
        }

        char[] currentPosition = intializeShrapnel(bombs, force, currentShrapnel);
        result.add(new String(currentPosition));

        while (!checkIfShrapnelExploded(currentShrapnel)) {
            char[] interShrapnel = new char[bombs.length()];
            for (int j = 0; j < currentShrapnel.length; j++) {
                interShrapnel[j] = '.';
            }
            for (int i = 0; i < currentShrapnel.length; i++) {
                if (currentShrapnel[i] == LEFT_SHRAPNEL) {
                    placeShrapnel(interShrapnel, i - force, LEFT_SHRAPNEL);
                }
                if (currentShrapnel[i] == RIGHT_SHRAPNEL) {
                    placeShrapnel(interShrapnel, i + force, RIGHT_SHRAPNEL);
                }
                if (currentShrapnel[i] == BOTH_SHRAPNEL) {
                    placeShrapnel(interShrapnel, i - force, LEFT_SHRAPNEL);
                    placeShrapnel(interShrapnel, i + force, RIGHT_SHRAPNEL);
                }
            }
            result.add(new String(interShrapnel));
            currentShrapnel = interShrapnel;
        }

        String[] resultArray = new String[result.size()];
        int i = 0;
        for (String line : result) {
            resultArray[i] = line;
            i++;
        }
        return resultArray;
    }

    /**
     * Helper method to initialize shrapnel for the first time
     *
     * @param bombs           Initial bombs location
     * @param force           Force of shrapnel
     * @param currentShrapnel Current shrapnel location
     * @return New shrapnel location
     */
    private char[] intializeShrapnel(String bombs, int force, char[] currentShrapnel) {

        for (int i = 0; i < bombs.length(); i++) {
            if (bombs.charAt(i) == '.') {
                continue;
            } else if (bombs.charAt(i) == BOMB) {
                placeShrapnel(currentShrapnel, i - force, LEFT_SHRAPNEL);
                placeShrapnel(currentShrapnel, i + force, RIGHT_SHRAPNEL);
            } else {
                throw new IllegalArgumentException("Illegal character in bomb string");
            }
        }
        return currentShrapnel;
    }

    /**
     * Helper method to place shrapnel at new locations
     *
     * @param currentShrapnel current shrapnel locations
     * @param position        position to place shrapnel
     * @param shrapnel        type of shrapnel to place (left or right)
     */
    private void placeShrapnel(char[] currentShrapnel, int position, char shrapnel) {
        if (position >= 0 && position < currentShrapnel.length) {
            if (currentShrapnel[position] == LEFT_SHRAPNEL || currentShrapnel[position] == RIGHT_SHRAPNEL) {
                currentShrapnel[position] = BOTH_SHRAPNEL;
            } else {
                currentShrapnel[position] = shrapnel;
            }
        }
    }

    /**
     * Helper method to check if all shrapnel exploded
     *
     * @param currentShrapnel current location of all shrapnel
     * @return true if all shrapnel have been exploded
     */
    private boolean checkIfShrapnelExploded(char[] currentShrapnel) {
        for (int i = 0; i < currentShrapnel.length; i++) {
            if (currentShrapnel[i] != '.') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CommonBond cb = new CommonBond();
         /* Problem 1 Test cases */
        System.out.println("*************************************** Problem 1 ***************************************");
        System.out.println("Output: " + cb.listMissingLetters("A quick brown fox jumps over the lazy dog"));
        System.out.println("Output: " + cb.listMissingLetters("Four score and seven years ago."));
        System.out.println("Output: " + cb.listMissingLetters("To be or not to be, that is the question!"));
        System.out.println("Output: " + cb.listMissingLetters(""));

        /* Problem 2 Test cases */
        System.out.println("*************************************** Problem 2 ***************************************");
        String[] result = cb.explode("..B....", 2);
        for (String line : result) {
            System.out.println(line);
        }
        System.out.println("-----------------------------------------------");
        result = cb.explode("..B.B..B", 10);
        for (String line : result) {
            System.out.println(line);
        }
        System.out.println("-----------------------------------------------");
        result = cb.explode("B.B.B.BB.", 2);
        for (String line : result) {
            System.out.println(line);
        }
        System.out.println("-----------------------------------------------");
        result = cb.explode("..B.B..B", 1);
        for (String line : result) {
            System.out.println(line);
        }
        System.out.println("-----------------------------------------------");
        result = cb.explode("..B.BB..B.B..B...", 1);
        for (String line : result) {
            System.out.println(line);
        }
    }
}
