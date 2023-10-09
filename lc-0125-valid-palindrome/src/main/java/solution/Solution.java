package solution;

public class Solution {
    public boolean isPalindrome(String s) {
        char[] c = s.replaceAll("[^a-zA-Z0-9()]", "").toLowerCase().toCharArray();

        int len = c.length;

        for (int i = 0; i < len / 2; i++) {
            if (c[i] != c[len - i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("125. Valid Palindrome");
    }
}
