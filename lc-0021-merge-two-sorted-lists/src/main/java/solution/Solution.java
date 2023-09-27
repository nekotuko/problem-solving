package solution;

public class Solution {
    // *FROM PROBLEM STATEMENT*:
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        // Presents this linked list as an array.
        // This is also used by the debugger to print this class.
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (ListNode i = this; i != null; i = i.next) {
                sb.append(i.val);
                if (i.next != null) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            return sb.toString();
        }
    }
    // NOTES:

    // Orinally wanted to have a pointer that points to head (least of the two) and
    // a pointer that points at the current node. Keep assigning curr.next to the
    // least of the two nodes:

    // But instead of pointing to the minimum of the two, point at a 'prehead' to
    // avoid separating identifying the minimum of the two, then traversing, saving
    // code:

    // *SOLUTION*:

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // prehead points at nothing now but when first curr gets pointed to the next
        // node, this node will point at the beginning of the linked list:
        ListNode prehead = new ListNode(-1, null);

        // this will traverse and point to the least of the two nodes:
        ListNode curr = prehead;

        while (list1 != null && list2 != null) {
            // point curr at the least of the two:
            if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            // advance curr:
            curr = curr.next;
        }

        // complete the chain:
        if (list1 != null) {
            curr.next = list1;
        } else {
            curr.next = list2;
        }

        // prehead points at the head, so return head:
        return prehead.next;
    }

    // This is the same algorithm but creates a deep copy merge of the provided
    // lists as opposed to actually merging them. This is to test my SolutionTest
    // being able to recognize when the lists have been deep copied.
    public ListNode deepCopyMergeTwoLists(ListNode list1, ListNode list2) {

        // prehead points at nothing now but when first curr gets pointed to the next
        // node, this node will point at the beginning of the linked list:
        ListNode newList = new ListNode(-1, null);

        // this will traverse and point to the least of the two nodes:
        ListNode curr = newList;

        while (list1 != null && list2 != null) {
            // point curr at the least of the two:
            if (list1.val < list2.val) {
                curr.next = new ListNode(list1.val, list1.next);
                list1 = list1.next;
            } else {
                curr.next = new ListNode(list2.val, list2.next);
                list2 = list2.next;
            }
            // advance curr:
            curr = curr.next;
        }

        // complete the chain:
        if (list1 != null) {
            curr.next = list1;
        } else {
            curr.next = list2;
        }

        // prehead points at the head, so return head:
        return newList.next;
    }

    public static void main(String[] args) {
        System.out.println("lc-0021-merge-two-sorted-lists");
    }
}
