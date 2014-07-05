package leetcode;

/**
 * Created by Jacob on 2014/5/6.
 */
public class BalancedBinaryTree {

    public static void main(String[] args) {
        BalancedBinaryTree solution = new BalancedBinaryTree();
        System.out.println(solution.isBalanced(Tool.stringToTree("1 2 3 4 5 6 # 7 # # #")));
    }

    /**
     * Given a binary tree, determine if it is height-balanced.
     * <p/>
     * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(depth(root.left) - depth(root.right)) <= 1;
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int deep = 1;
        int left = depth(root.left);
        int right = depth(root.right);

        int max = left > right ? left : right;
        return deep + max;
    }


}
