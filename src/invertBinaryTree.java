import java.util.*;

public class invertBinaryTree {

    public static void main(String[] args) {
        // Original Tree:
        //      1
        //     / \
        //    2   3
        //   / \
        //  4   5

        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3));

        SolutionI sol = new SolutionI();
        TreeNode inverted = sol.invertTree(root);

        System.out.println("Inverted Tree (Level Order):");
        printLevelOrder(inverted);
    }

    // Helper to print tree in level order
    static void printLevelOrder(TreeNode root) {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.val + " ");
            if (current.left != null)
                queue.offer(current.left);
            if (current.right != null)
                queue.offer(current.right);
        }
    }
}

class SolutionI {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;

        invertTree(root.left);
        invertTree(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }
}
