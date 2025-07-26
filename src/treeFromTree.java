import java.util.*;

public class treeFromTree {
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        Solutionl solution = new Solutionl();
        TreeNode root = solution.buildTree(preorder, inorder);

        // Print the tree in level order to verify
        printLevelOrder(root);
    }

    public static void printLevelOrder(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            System.out.print(curr.val + " ");
            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
        }
    }
}


class Solutionl {
    int preorderIndex;
    Map<Integer, Integer> inorderMap;
    int[] preorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.preorderIndex = 0;
        this.inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            inorderMap.put(inorder[i], i);
        return helper(0, inorder.length - 1);
    }

    private TreeNode helper(int left, int right) {
        if (left > right)
            return null;
        int rootVal = preorder[preorderIndex];
        TreeNode root = new TreeNode(rootVal);
        preorderIndex++;
        int inorderRootIndex = inorderMap.get(rootVal);
        root.left = helper(left, inorderRootIndex - 1);
        root.right = helper(inorderRootIndex + 1, right);
        return root;
    }
}
