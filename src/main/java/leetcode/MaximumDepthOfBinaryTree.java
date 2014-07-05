package leetcode;

/**
 * Created by Jacob on 2014/5/6.
 */
public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        MaximumDepthOfBinaryTree solution = new MaximumDepthOfBinaryTree();
        System.out.println(solution.maxDepth(Tool.stringToTree("1 2 3 4 # # # 5 # # #")));
    }

    /**
     * Given a binary tree, find its maximum depth.
     * <p/>
     * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : 1 + (Math.max(maxDepth(root.left), maxDepth(root.right)));
    }


}
