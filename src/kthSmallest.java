import java.util.*;

public class kthSmallest {

    // Original Solution class unchanged
    static class Solution {

        private void inorderHelper(TreeNode root, List<Integer> list){
            if(root == null)
                return;
            inorderHelper(root.left, list);
            list.add(root.val);
            inorderHelper(root.right, list);
        }

        public int kthSmallest(TreeNode root, int k) {
            List<Integer> list = new ArrayList<>();
            inorderHelper(root, list);
            return list.get(k - 1);
        }
    }

    // Main method to test kth smallest
    public static void main(String[] args) {
        /*
             5
            / \
           3   6
          / \
         2   4
        /
       1
        */

        TreeNode root = new TreeNode(5,
                new TreeNode(3,
                        new TreeNode(2,
                                new TreeNode(1), null),
                        new TreeNode(4)),
                new TreeNode(6));

        Solution sol = new Solution();
        int k = 3;
        int result = sol.kthSmallest(root, k);
        System.out.println("The " + k + "rd smallest element is: " + result);
    }
}
