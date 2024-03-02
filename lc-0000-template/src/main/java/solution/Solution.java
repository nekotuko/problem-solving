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

    public int addAll2DArray(int[][] nums) {
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                ans += nums[i][j];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("I'm a template!");
    }
}
