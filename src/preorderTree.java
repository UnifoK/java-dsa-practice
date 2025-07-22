import java.util.ArrayList;
import java.util.List;

class Solutionp {
    private void preorderHelper(TreeNode node, List<Integer> temp) {
        if (node == null)
            return;
        temp.add(node.val);
        preorderHelper(node.left, temp);
        preorderHelper(node.right, temp);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> temp = new ArrayList<>();
        preorderHelper(root, temp);
        return temp;
    }
}

public class preorderTree {
    public static void main(String[] args) {
        // Tree structure:
        //      1
        //     / \
        //    2   3
        //   / \
        //  4   5
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)),
                new TreeNode(3));

        Solutionp sol = new Solutionp();
        List<Integer> preorder = sol.preorderTraversal(root);

        System.out.println("Preorder Traversal: " + preorder); // Expected: [1, 2, 4, 5, 3]
    }
}
