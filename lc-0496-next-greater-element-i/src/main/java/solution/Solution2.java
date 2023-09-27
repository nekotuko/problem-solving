package solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution2 {
    // Use a monotonic stack data structure. Since we need to find the next greater
    // element in terms of its index (as opposed to value), we can utilize a
    // monotonically decreasing stack to track this relationship for all elements in
    // 'nums2[]'.
    // If a given element in 'nums2[]' is greater than the top element in the stack,
    // add to map<nums2[i], stack.pop()>. Repeat this until the stack is empty or
    // nums2[i] is no longer greater than top element of stack. Once done with this,
    // add the current element to the stack and move on to the next element.
    // All the elements that remain in the stack after we've checked all elements
    // in 'nums2[]' have no next greater element, therefore add them to the map as
    // map<stack.pop(), -1>

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>(); // monotonically decreasing stack
        Map<Integer, Integer> map = new HashMap<>(); // map to store values <element, next greater element>

        // build map for elements that have next greater elements:
        for (int num2 : nums2) {
            while (!stack.isEmpty() && num2 > stack.peek()) {
                map.put(stack.pop(), num2);
            }

            stack.push(num2);
        }

        // build map for elements that don't have next greater elements:
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }

        // write to return array for elements requested in 'nums1[]':
        int ans[] = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("lc-0496-next-greater-element-i");
    }
}
