import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode() {}

    TreeNode(int val) { this.val = val; }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class SolutionT {
    private void inorderHelper(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inorderHelper(node.left, list);
        list.add(node.val);
        inorderHelper(node.right, list);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }
}

public class inOrderTree {
    public static void main(String[] args) {
        // Building the tree:
        //       1
        //        \
        //         2
        //        /
        //       3
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        SolutionT sol = new SolutionT();
        List<Integer> inorder = sol.inorderTraversal(root);

        System.out.println("Inorder Traversal: " + inorder); // Expected: [1, 3, 2]
    }
}
