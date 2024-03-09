package solution;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean canConstruct(String ransomNote, String magazine) {
        
        Map<Character, Integer> map = new HashMap<>();

        for (char m : magazine.toCharArray()) {
            if (!map.containsKey(m)) {
                map.put(m, 0);
            } else {
                map.put(m, map.get(m) + 1);
            }
        }

        for (char r : ransomNote.toCharArray()) {
            int curr = -1;
            if (map.containsKey(r)) {
                curr = map.put(r, map.get(r) - 1);
            }

            if (curr < 0)
                return false;
        }

        return true;
    
    }

    public static void main(String[] args) {
        System.out.println("lc-0383-ransom-note");
    }
}
