package solution;

public class Solution2 {

    public boolean canConstruct(String ransomNote, String magazine) {
        int a = 'a';
        int z = 'z';
        int[] map = new int[z - a + 1];

        for (char m : magazine.toCharArray()) {
            map[m - a]++;
        }

        for (char r : ransomNote.toCharArray()) {
            if (--map[r - a] < 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("lc-0383-ransom-note");
    }
}
