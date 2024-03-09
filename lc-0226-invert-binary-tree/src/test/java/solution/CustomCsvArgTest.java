package solution;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CustomCsvArgTest {

    static class MyTreeAsList {
        public ArrayList<Integer> values;

        // Generate List from delimeted CSV input string:
        MyTreeAsList(String s) {
            // Convert to String[] array:
            s = s.replaceAll("\\[", "");
            s = s.replaceAll("\\]", "");
            String[] tokens = s.split(",");

            // Generate ArrayList<>():
            values = new ArrayList<>();
            for (String token : tokens) {
                // Account for 'null' and "" strings:
                if (!token.equals("null") && !token.equals("")) {
                    values.add(Integer.parseInt(token));
                } else {
                    values.add(null);
                }
            }
        }

        // Generate List from TreeNode head:
        MyTreeAsList(TreeNode head) {

            values = new ArrayList<>();

            if (head == null) {
                values.add(null); // Add a 'null' instead of having empty List to stay consistent
            } else {
                Queue<TreeNode> q = new LinkedList<>();
                q.offer(head);

                // Build arraylist:
                while (!q.isEmpty()) {
                    TreeNode curr = q.poll();
                    if (curr != null) {
                        values.add(curr.val);
                        q.offer(curr.left);
                        q.offer(curr.right);
                    } else {
                        values.add(null);
                    }
                }

                // Trim tail nulls:
                while (values.get(values.size() - 1) == null) {
                    values.remove(values.size() - 1);
                }
            }
        }
    }

    // Generate TreeNode tree and store it's 'head':
    static class MyTree {
        private TreeNode head;

        MyTree(String s) {

            // Use MyIntArrList to first build the List<Integer>
            List<Integer> values = new MyTreeAsList(s).values;

            // Build TreeNode:
            if (values.isEmpty() || (values.size() == 1 && values.get(0) == null)) {
                head = null;
            } else {
                head = new TreeNode(values.get(0));

                Queue<TreeNode> q = new LinkedList<>();

                q.add(head);

                int i = 1;

                while (i < values.size()) {

                    TreeNode curr = q.remove();

                    if (curr == null) {
                        i = i + 2; // Skip children when parent node is 'null' and go to next parent
                    } else {
                        // Add left & right if they're not input as 'null' and within list Size:

                        if (i < values.size() && values.get(i) != null) {
                            curr.left = new TreeNode(values.get(i));
                            q.add(curr.left);
                        }
                        i++;

                        if (i < values.size() && values.get(i) != null) {
                            curr.right = new TreeNode(values.get(i));
                            q.add(curr.right);
                        }
                        i++;

                    }
                }
            }
        }
    }

    // *** Check that reordered tree has the values in the right order:
    @ParameterizedTest
    @CsvSource(value = {
            "[4,2,7,1,3,6,9]; [4,7,2,9,6,3,1]",
            "[4,2,7,1,3,6]; [4,7,2,null,6,3,1]",
            "[2,1,3]; [2,3,1]",
            "[]; []",
            "[null]; [null]",
            "[1,2,3,4]; [1,3,2,null,null,null,4]",
            "[1,2,3,null,4]; [1,3,2,null,null,4]",
            "[1,2,3,null,null,null,4]; [1,3,2,4]"
    }, delimiter = ';')
    void invertedTreeProducesValuesInCorrectOrder(MyTree inputTree, MyTreeAsList expectedIntArrList) {
        Solution s = new Solution();

        List<Integer> resultTreeAsIntegerList = new MyTreeAsList(s.invertTree(inputTree.head)).values;

        assertTrue((resultTreeAsIntegerList.size() == expectedIntArrList.values.size()));

        for (int i = 0; i < resultTreeAsIntegerList.size(); i++) {
            assertEquals(resultTreeAsIntegerList.get(i), expectedIntArrList.values.get(i));
        }
    }

    // *** Check that reordered tree is made of original objects using hashCodes:
    @ParameterizedTest
    @CsvSource(value = {
            "[4,2,7,1,3,6,9]",
            "[4,2,7,1,3,6]",
            "[2,1,3]",
            "[]",
            "[null]",
            "[1,2,3,4]",
            "[1,2,3,null,4]",
            "[1,2,3,null,null,null,4]"
    }, delimiter = ';')

    void invertedTreeIsMadeOfOriginalTreeNodes(MyTree inputTree) {
        Solution s = new Solution();

        s.invertTree(inputTree.head);

        assertEquals(getAggHashOfTreeNodes(inputTree.head), getAggHashOfTreeNodes(s.invertTree(inputTree.head)));
    }

    // Do a level order/BFS traversal and generate aggregate hash:
    private int getAggHashOfTreeNodes(TreeNode head) {
        int aggHash = 0;

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(head);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr != null) {
                aggHash ^= curr.hashCode();
                if (curr.left != null)
                    q.offer(curr.left);
                if (curr.right != null)
                    q.offer(curr.right);
            }
        }

        return aggHash;
    }
}
