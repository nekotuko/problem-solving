package solution;

public class Solution extends VersionControl {

    Solution(int badVersion) {
        super(badVersion);
    }

    // Perform binary search:
    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;

        // Perform binary search:
        int mid = low + (high - low) / 2;

        while (low < high) {
            mid = low + (high - low) / 2;
            if (isBadVersion(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        // If 'low == high', return either. 'mid' is out of date:
        if (low == high) {
            return low;
        }

        // Else 'mid' was updated to be the answer:
        return mid;
    }

    public static void main(String[] args) {
        System.out.println("lc-0278-first-bad-version");
    }
}
