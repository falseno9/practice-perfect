package codewars;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Groups {

    public static boolean groupCheck(String s) {
        Map<Character, Character> openB = new HashMap<>();
        openB.put('(', ')');
        openB.put('[', ']');
        openB.put('{', '}');

        Map<Character, Character> closedB = new HashMap<>();
        closedB.put(')', '(');
        closedB.put(']', '[');
        closedB.put('}', '{');

        Stack<Character> unmatched = new Stack<>();
        char[] symbols = s.toCharArray();
        for (int i = 0; i < symbols.length; i++) {
            char c = symbols[i];
            if (openB.containsKey(c)) {
                unmatched.push(c);
            } else {
                if (unmatched.isEmpty()) {
                    return false;
                } else {
                    if (unmatched.pop().compareTo(closedB.get(c)) != 0) {
                        return false;
                    }
                }
            }
        }
        return unmatched.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(groupCheck("()"));
        System.out.println(groupCheck("({"));
    }
}