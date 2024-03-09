package solution;

public class Solution {
    // Per problem statement, below are the definitions:

    // Symbol Value
    // I 1
    // V 5
    // X 10
    // L 50
    // C 100
    // D 500
    // M 1000

    // Below are special cases:

    // I can be placed before V (5) and X (10) to make 4 and 9.
    // X can be placed before L (50) and C (100) to make 40 and 90.
    // C can be placed before D (500) and M (1000) to make 400 and 900.

    public int romanToInt(String s) {

        int ans = 0;

        int i = 0;

        while (i < s.length()) {

            int currVal = getIntVal(s.charAt(i));

            // If there's a character after current, check it
            if (i + 1 < s.length()) {

                int nextVal = getIntVal(s.charAt(i + 1));

                // Normal order, decreasing:
                if (currVal >= nextVal) {
                    ans += currVal;
                    i++;
                }
                // Special order, increasing:
                else {
                    ans += nextVal - currVal;
                    i = i + 2;
                }
            } else {
                ans += currVal;
                i++;
            }
        }

        return ans;

    }

    private int getIntVal(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("lc-0013-roman-to-integer");
    }
}
