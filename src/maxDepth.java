import java.util.*;

public class maxDepth {

    public static void main(String[] args) {
        // Creating a sample binary tree:
        //         1
        //        / \
        //       2   3
        //      /
        //     4

        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), null),
                new TreeNode(3));

        SolutionM sol = new SolutionM();
        int depth = sol.maxDepth(root);
        System.out.println("Maximum Depth of the Binary Tree: " + depth);
    }
}

class SolutionM {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int leftSubtreeDepth = maxDepth(root.left);
        int rightSubtreeDepth = maxDepth(root.right);
        return Math.max(leftSubtreeDepth, rightSubtreeDepth) + 1;
    }
}


