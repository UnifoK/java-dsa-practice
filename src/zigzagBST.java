import java.util.*;
public class zigzagBST {

    // Original Solution class
    static class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            Queue<TreeNode> q = new LinkedList<>();
            if (root != null)
                q.add(root);
            int counter = 1;
            while (!q.isEmpty()) {
                int levelSize = q.size();
                List<Integer> currentLevel = new ArrayList<>();
                for (int i = 0; i < levelSize; i++) {
                    TreeNode currentNode = q.poll();
                    currentLevel.add(currentNode.val);
                    if (currentNode.left != null) {
                        q.add(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        q.add(currentNode.right);
                    }
                }
                if (counter % 2 == 0) {
                    Collections.reverse(currentLevel);
                    result.add(currentLevel);
                } else {
                    result.add(currentLevel);
                }
                counter++;
            }
            return result;
        }
    }

    // Main method to test the zigzag level order
    public static void main(String[] args) {
        /*
             1
            / \
           2   3
          / \   \
         4   5   6
        */

        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4), new TreeNode(5)),
                new TreeNode(3,
                        null, new TreeNode(6)));

        Solution sol = new Solution();
        List<List<Integer>> zigzag = sol.zigzagLevelOrder(root);

        for (List<Integer> level : zigzag) {
            System.out.println(level);
        }
    }
}
