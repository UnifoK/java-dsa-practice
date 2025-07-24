import java.util.*;

public class bfsTree {

    // BFS level-order traversal
    static class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            Queue<TreeNode> q = new LinkedList<>();
            if (root != null) {
                q.add(root);
            }

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
                result.add(currentLevel);
            }
            return result;
        }
    }

    // Main method to test the BFS traversal
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4), new TreeNode(5)),
                new TreeNode(3,
                        new TreeNode(6), new TreeNode(7)));

        Solution sol = new Solution();
        List<List<Integer>> levels = sol.levelOrder(root);

        for (List<Integer> level : levels) {
            System.out.println(level);
        }
    }
}
