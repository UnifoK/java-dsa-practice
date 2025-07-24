import java.util.*;
public class bstValidate {

    // Original Solution class without modification
    static class Solution {

        private boolean helper(TreeNode node, Integer min, Integer max){
            if (node == null)
                return true;
            if (min != null && node.val <= min) {
                return false;
            }
            if (max != null && node.val >= max) {
                return false;
            }
            boolean isLeftValid = helper(node.left, min, node.val);
            boolean isRightValid = helper(node.right, node.val, max);
            return isLeftValid && isRightValid;
        }

        public boolean isValidBST(TreeNode root) {
            return helper(root, null, null);
        }
    }

    // Main method to test BST validation
    public static void main(String[] args) {
        // Valid BST
        TreeNode root = new TreeNode(5,
                new TreeNode(3,
                        new TreeNode(2), new TreeNode(4)),
                new TreeNode(7,
                        new TreeNode(6), new TreeNode(8)));

        Solution sol = new Solution();
        boolean isValid = sol.isValidBST(root);
        System.out.println("Is valid BST: " + isValid);
    }
}
