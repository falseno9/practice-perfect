package Random;

import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Given a string of brackets including (,{ and [. Delete minimum number of brackets to make the string balanced.
 * Example: In the string {([)]} the answer is 2 i.e either delete [ and ] or ( and ).
 */
public class BalanceBrackets {

    static boolean areBracketsBalanced(String brackets) {
        if (StringUtils.isBlank(brackets)) {
            return false;
        }

        Set<Character> openingBrace = new HashSet<>();
        openingBrace.add('(');
        openingBrace.add('[');
        openingBrace.add('{');

        Set<String> closingBracePair = new HashSet<>();
        closingBracePair.add("()");
        closingBracePair.add("[]");
        closingBracePair.add("{}");

        Stack<Character> currentOpenBraces = new Stack<>();
        for (int i = 0; i < brackets.length(); i++) {
            Character c = brackets.charAt(i);
            if (openingBrace.contains(c)) {
                currentOpenBraces.push(c);
            } else {
                if (!currentOpenBraces.isEmpty()) {
                    if (!closingBracePair.contains(currentOpenBraces.pop().toString() + c.toString())) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return currentOpenBraces.isEmpty();
    }

    static int deleteBraces(String brackets) {

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(areBracketsBalanced("["));
        System.out.println(areBracketsBalanced("[]"));
        System.out.println(areBracketsBalanced("([{}])"));
        System.out.println(areBracketsBalanced("([{}]))"));
        System.out.println(areBracketsBalanced(""));
        System.out.println(areBracketsBalanced("{"));
    }
}
