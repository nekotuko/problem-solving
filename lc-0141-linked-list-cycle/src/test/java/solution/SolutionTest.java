package solution;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {

    @ParameterizedTest
    @CsvSource(value = {
            "[3,2,0,-4]; 0; true",
            "[3,2,0,-4]; -1; false",
            "[3,2,0,-4]; 2; true",
            "[1,2]; 0; true",
            "[]; -1; false"
    }, delimiter = ';')
    void testWithMyArgs(String inputListAsString, int inputPos, String expectedAsString) {

        Solution s = new Solution();

        ListNode head = buildList(inputListAsString, inputPos);

        assertEquals(s.hasCycle(head), Boolean.parseBoolean(expectedAsString));

    }

    private ListNode buildList(String s, int pos) {
        ListNode head = null;

        s = s.replaceAll("\\[", "");
        s = s.replaceAll("\\]", "");

        String[] tokens = s.split(",");
        int n = tokens.length;

        if (n == 0 || n == 1 && tokens[0] == "") {
            return head;
        } else {
            head = new ListNode(Integer.parseInt(tokens[0]));
            ListNode curr = head;
            ListNode cycleNode = null;

            if (pos == 0) {
                cycleNode = head;
            }

            for (int i = 1; i < n; ++i) {
                curr.next = new ListNode(Integer.parseInt(tokens[i]));
                curr = curr.next;

                if (pos == i) {
                    cycleNode = curr;
                }
            }

            curr.next = cycleNode;
        }
        return head;
    }
}
