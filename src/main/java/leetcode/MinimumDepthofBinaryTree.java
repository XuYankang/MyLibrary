package leetcode;

/**
 * Created by Jacob on 2014/5/6.
 */
public class MinimumDepthofBinaryTree {

    public static void main(String[] args) {
        MinimumDepthofBinaryTree solution = new MinimumDepthofBinaryTree();
        System.out.println(solution.minDepth(Tool.stringToTree("1 2 # # #")));
    }

    /**
     * Given a binary tree, find its minimum depth.
     * <p/>
     * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null && root.right != null) {
            return 1 + minDepth(root.right);
        }
        if (root.right == null && root.left != null) {
            return 1 + minDepth(root.left);
        }

        return Math.min(1 + minDepth(root.left), 1 + minDepth(root.right));
    }


}
