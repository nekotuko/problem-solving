package solution;

public class Solution {

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode runner1 = head;
        ListNode runner2 = head.next;

        while (runner2 != null) {
            if (runner1 == runner2) {
                return true;
            } else if (runner2.next == null) {
                return false;
            }
            runner1 = runner1.next;
            runner2 = runner2.next.next;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("lc-0141-linked-list-cycle");
    }
}
