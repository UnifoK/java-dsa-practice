public class sameTree {
    public static void main(String[] args) {
        // Create tree 1: [1,2,3]
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        // Create tree 2: [1,2,3]
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);

        // Test isSameTree
        SolutionS sol = new SolutionS();
        boolean result = sol.isSameTree(p, q);

        System.out.println("Are trees the same? " + result); // Output: true
    }
}

// Solution class with the isSameTree method
class SolutionS {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null)
            return true;
        if((p!=null&&q!=null)&&(p.val!=q.val)||((p!=null&&q==null)||(p==null&&q!=null)))
            return false;

        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);

    }
}
