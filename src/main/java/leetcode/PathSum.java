package leetcode;

/**
 * Created by Jacob on 14-7-5.
 */
public class PathSum {


    public static void main(String[] args) {
        TreeNode treeNode = Tool.stringToTree("5 4 8 11 # 13 4 7 2 # # # # # # # 1");

    }
    /**
     * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that
     * adding up all the values along the path equals the given sum.
     * <p/>
     * For example:
     * Given the below binary tree and sum = 22,
     * 5
     * / \
     * 4   8
     * /   / \
     * 11  13  4
     * /  \      \
     * 7    2      1
     * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
     *
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        boolean result1 = false;
        boolean result2 = false;
        if (root == null) {
            return false;
        }
        if (root.val == sum && root.left == null && root.right == null) {
            return true;
        }

        if (root.left != null) {
            result1 = hasPathSum(root.left, sum - root.val);
        }
        if (root.right != null) {
            result2 = hasPathSum(root.right, sum - root.val);
        }
        return result1 || result2;
    }
}
