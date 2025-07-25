public class flattenBST {

    // Original Solution class without any changes
    static class Solution {
        private TreeNode prev = null;

        public void flatten(TreeNode root) {
            if (root == null)
                return;
            flatten(root.right);
            flatten(root.left);
            root.right = prev;
            root.left = null;
            prev = root;
        }
    }

    // Main method to test flattening a binary tree
    public static void main(String[] args) {
        /*
             1
            / \
           2   5
          / \   \
         3   4   6

         After flattening:
         1 - 2 - 3 - 4 - 5 - 6
        */

        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3), new TreeNode(4)),
                new TreeNode(5,
                        null, new TreeNode(6)));

        Solution sol = new Solution();
        sol.flatten(root);

        // Print flattened tree (right-skewed list)
        TreeNode curr = root;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.right;
        }
    }
}
