import java.util.ArrayList;
import java.util.List;

// Solution with postorder logic
class SolutionP {
    private void postorderHelper(TreeNode node, List<Integer> temp) {
        if (node == null)
            return;
        postorderHelper(node.left, temp);
        postorderHelper(node.right, temp);
        temp.add(node.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> temp = new ArrayList<>();
        postorderHelper(root, temp);
        return temp;
    }
}

// Main class to test
public class postorderTree {
    public static void main(String[] args) {
        // Create the tree:
        //        1
        //       / \
        //      2   3
        //     / \
        //    4   5

        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)),
                new TreeNode(3));

        SolutionP sol = new SolutionP();
        List<Integer> postorder = sol.postorderTraversal(root);

        System.out.println("Postorder Traversal: " + postorder); // Expected: [4, 5, 2, 3, 1]
    }
}
