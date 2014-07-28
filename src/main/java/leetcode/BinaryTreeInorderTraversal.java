package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Jacob on 2014/5/6.
 */
public class BinaryTreeInorderTraversal {

    public static void main(String[] args) {
        BinaryTreeInorderTraversal solution = new BinaryTreeInorderTraversal();
        System.out.println(solution.inorderTraversal1(Tool.stringToTree("1 2 3 4 5 6 7")));
    }


    /**
     * Given a binary tree, return the inorder traversal of its nodes' values.
     * <p/>
     * For example:
     * Given binary tree {1,#,2,3},
     * 1
     * \
     * 2
     * /
     * 3
     * return [1,3,2].
     * <p/>
     * Note: Recursive solution is trivial, could you do it iteratively?
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }

        list.addAll(inorderTraversal(root.left));
        list.add(root.val);
        list.addAll(inorderTraversal(root.right));

        return list;
    }

    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode x = root;
        while (x != null) {
            stack.push(x);
            x = x.left;
        }

        while (!stack.empty()) {
            x = stack.pop();
            list.add(x.val);
            if (x.right != null) {
                TreeNode t = x.right;
                while (t != null) {
                    stack.push(t);
                    t = t.left;
                }
            }
        }
        return list;
    }

}
