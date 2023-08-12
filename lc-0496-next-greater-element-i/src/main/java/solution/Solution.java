package solution;

public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        int i = 0;
        while (i < nums1.length) {
            int j = 0;
            int val = -1;
            boolean matchFound = false;
            while (j < nums2.length) {
                if (matchFound && nums2[j] > nums1[i]) {
                    val = nums2[j];
                    break;
                } else if (!matchFound && nums2[j] == nums1[i]) {
                    matchFound = true;
                }
                j++;
            }
            ans[i] = val;
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("lc-0496-next-greater-element-i");
    }
}
