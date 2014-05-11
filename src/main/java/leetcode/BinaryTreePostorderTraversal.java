package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Administrator on 2014/5/6.
 */
public class BinaryTreePostorderTraversal {

    public static void main(String[] args) {
        BinaryTreePostorderTraversal solution = new BinaryTreePostorderTraversal();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = null;
        node1.right = node2;
        node2.left = node3;
        node2.right = null;
        node3.left = null;
        node3.right = null;
        System.out.println(solution.postorderTraversal(node1));
    }

    /**
     * Given a binary tree, return the postorder traversal of its nodes' values.
     * <p/>
     * For example:
     * Given binary tree {1,#,2,3},
     * 1
     * \
     * 2
     * /
     * 3
     * return [3,2,1].
     * <p/>
     * Note: Recursive solution is trivial, could you do it iteratively?
     *
     * @param root
     * @return
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        if (root == null) {
            return result;
        }
        if (root.left != null) {
            ArrayList<Integer> lr = postorderTraversal(root.left);
            result.addAll(lr);
        }
        if (root.right != null) {
            ArrayList<Integer> rr = postorderTraversal(root.right);
            result.addAll(rr);
        }
        result.add(root.val);

        return result;
    }


}
