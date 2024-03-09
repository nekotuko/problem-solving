package solution;

public class Solution {

    public TreeNode invertTree(TreeNode root) {

        if (root == null)
            return null;

        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);

        return root;
    }

    public static void main(String[] args) {
        System.out.println("lc-0226-invert-binary-tree");
    }
}
