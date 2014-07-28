package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Jacob on 2014/5/6.
 */
public class BinaryTreePreorderTraversal {

    public static void main(String[] args) {
        BinaryTreePreorderTraversal solution = new BinaryTreePreorderTraversal();
        System.out.println(solution.preorderTraversal(Tool.stringToTree("1 # 2 3")));
    }

    /**
     * Given a binary tree, return the preorder traversal of its nodes' values.
     * <p/>
     * For example:
     * Given binary tree {1,#,2,3},
     * 1
     * \
     * 2
     * /
     * 3
     * return [1,2,3].
     * <p/>
     * Note: Recursive solution is trivial, could you do it iteratively?
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        if (root == null) {
            return list;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode cur = stack.pop();
            list.add(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }

        return list;
    }


}
