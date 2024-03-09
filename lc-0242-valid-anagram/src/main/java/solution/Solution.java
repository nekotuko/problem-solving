package solution;

public class Solution {
    public boolean isAnagram(String s, String t) {

        int[] charArr = new int['z' - 'a' + 1];

        for (char c : s.toCharArray()) {
            charArr[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            charArr[c - 'a']--;
        }

        for (int i : charArr) {
            if (i != 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("lc-0242-valid-anagram");
    }
}
