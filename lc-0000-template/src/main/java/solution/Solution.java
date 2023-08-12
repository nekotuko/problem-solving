package solution;

public class Solution {
    public int add(int a, int b) {
        return a + b;
    }

    public int[] addAll(int[] a, int[] b) {
        int n = Math.min(a.length, b.length);
        int[] c = new int[n];
        for (int i = 0; i < n; ++i) {
            c[i] = a[i] + b[i];
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println("I'm a template!");
    }
}
