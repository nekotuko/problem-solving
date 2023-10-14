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

    static class TestTreeNode extends TreeNode {
        private TestTreeNode(List<Integer> values) {
            super(); // Instantiate an empty 'this' node

            int values_size = values.size();

            // Initialize head:
            if (values_size > 0 && values.get(0) != null) {
                this.val = values.get(0);
            }

            // Build a queue to build the tree:
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(this);

            int i = 1;
            while (i < values_size) {

                TreeNode curr = q.poll();

                // If the current value is null, it can't have children:
                if (curr == null) {
                    i = i + 2;
                } else {
                    if (i < values_size && values.get(i) != null) {
                        curr.left = new TreeNode(values.get(i));
                    }
                    q.offer(curr.left);
                    i++;

                    if (i < values_size && values.get(i) != null) {
                        curr.right = new TreeNode(values.get(i));
                    }
                    q.offer(curr.right);
                    i++;
                }
            }
        }

        // Factory method to control 'null' and empty string inputs. If constructed
        // directly, 'super()' will instantiate a node with 'val = 0', instead of not
        // generating a node at all. This way we can return a 'null' 'TreeNode' when the
        // inputs are 'null':
        static TestTreeNode fromString(String s) {
            List<Integer> values = new MyTreeAsList(s).values;

            if (values.isEmpty() || values.get(0) == null) {
                return null;
            } else {
                return new TestTreeNode(values);
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
    void invertedTreeProducesValuesInCorrectOrder(TestTreeNode inputTree,
            MyTreeAsList expectedIntArrList) {
        Solution s = new Solution();

        List<Integer> resultTreeAsIntegerList = new MyTreeAsList(s.invertTree(inputTree)).values;

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

    void invertedTreeIsMadeOfOriginalTreeNodes(TestTreeNode inputTree) {
        Solution s = new Solution();

        s.invertTree(inputTree);

        assertEquals(getAggHashOfTreeNodes(inputTree), getAggHashOfTreeNodes(s.invertTree(inputTree)));
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
