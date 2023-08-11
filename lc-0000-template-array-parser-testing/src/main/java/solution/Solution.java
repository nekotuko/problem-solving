package solution;

public class Solution {
    public int[] add(int[] nums1, int[] nums2) {
        if (nums1.length != nums2.length) {
            return new int[] {};
        } else {
            int ans[] = new int[nums1.length];
            for (int i = 0; i < ans.length; i++) {
                ans[i] = nums1[i] + nums2[i];
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        System.out.println("A test project to test jUnit array parser.");
    }
}
