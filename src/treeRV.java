import java.util.*;

public class treeRV {

    // Solution class with right side view logic
    static class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            Queue<TreeNode> q = new LinkedList<>();
            if (root != null) {
                q.add(root);
            }
            while (!q.isEmpty()) {
                int levelSize = q.size();
                for (int i = 0; i < levelSize; i++) {
                    TreeNode currentNode = q.poll();
                    if (i == levelSize - 1)
                        result.add(currentNode.val);
                    if (currentNode.left != null)
                        q.add(currentNode.left);
                    if (currentNode.right != null)
                        q.add(currentNode.right);
                }
            }
            return result;
        }
    }

    // Main method to test right side view
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        null, new TreeNode(5)),
                new TreeNode(3,
                        null, new TreeNode(4)));

        Solution sol = new Solution();
        List<Integer> rightView = sol.rightSideView(root);

        for (int val : rightView) {
            System.out.println(val);
        }
    }
}
