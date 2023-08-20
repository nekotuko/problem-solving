package solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    Map<Character, Character> mCompliments; // To neatly access open-close brackets
    Stack<Character> mStack; // To keep track of order of open-close brackets

    public Solution() {
        // Construct class variables
        mCompliments = new HashMap<>(); // map<openingBracket, closingBracket>
        mCompliments.put('(', ')');
        mCompliments.put('[', ']');
        mCompliments.put('{', '}');

        mStack = new Stack<>();
    }

    // helper method checks if a given character is a correct complement for last
    // bracket in stack
    private boolean isComplement(char openBracket, char closeBracket) {
        if (mCompliments.containsKey(openBracket)) {
            return closeBracket == mCompliments.get(openBracket);
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
