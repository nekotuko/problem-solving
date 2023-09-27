package solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    Map<Character, Character> mComplements; // To neatly access open-close brackets
    Stack<Character> mStack; // To keep track of order of open-close brackets

    public Solution() {
        // Construct class variables
        mComplements = new HashMap<>(); // map<openingBracket, closingBracket>
        mComplements.put('(', ')');
        mComplements.put('[', ']');
        mComplements.put('{', '}');

        mStack = new Stack<>();
    }

    // helper method checks if a given character is a correct complement for last
    // bracket in stack
    private boolean isComplement(char openBracket, char closeBracket) {
        if (mComplements.containsKey(openBracket)) {
            return closeBracket == mComplements.get(openBracket);
        }
        return false;
    }

    public boolean isValid(String s) {
        for (char c : s.toCharArray()) {
            if (!mStack.empty() && isComplement(mStack.peek(), c)) {
                mStack.pop();
            } else {
                mStack.push(c);
            }
        }

        return mStack.isEmpty(); // Stack is empty if all brackets correctly accounted for
    }

    public static void main(String[] args) {
        System.out.println("lc-0020-valid-parentheses");
    }
}
