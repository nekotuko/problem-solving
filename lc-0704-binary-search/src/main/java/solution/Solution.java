package solution;

public class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = -1;

        while (low <= high) {
            mid = (high + low) / 2;

            if (target == nums[mid])
                return mid;

            if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return (nums[mid] == target) ? mid : -1;
    }

    public static void main(String[] args) {
        System.out.println("lc-0704-binary-search");
    }
}