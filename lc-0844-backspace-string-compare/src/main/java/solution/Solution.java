package solution;

public class Solution {
    public boolean backspaceCompare(String s, String t) {
        String processedS = process(s);
        String processedT = process(t);

        return processedS.equals(processedT);
    }

    private String process(String x) {
        StringBuilder sb = new StringBuilder();

        for (char c : x.toCharArray()) {
            if (c != '#') {
                sb.append(c);
            } else if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("lc-0844-backspace-string-compare");
    }
}
