package leetcode;

import java.util.ArrayList;

/**
 * Created by Administrator on 2014/5/6.
 */
public class ValidateBinarySearchTree {

    public static void main(String[] args) {
        ValidateBinarySearchTree solution = new ValidateBinarySearchTree();
        TreeNode root = Tool.stringToTree("1,1");
        System.out.println(solution.isValidBST(root));
    }

    /**
     * Given a binary tree, determine if it is a valid binary search tree (BST).
     * <p/>
     * Assume a BST is defined as follows:
     * <p/>
     * The left subtree of a node contains only nodes with keys less than the node's key.
     * The right subtree of a node contains only nodes with keys greater than the node's key.
     * Both the left and right subtrees must also be binary search trees.
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {

        if (root == null) {
            return true;
        }
        ArrayList<Integer> midOrder = midOrder(root);

        Integer first = midOrder.get(0);
        boolean isValid = true;
        for (int i = 1; i < midOrder.size(); i++) {
            if (first >= midOrder.get(i)) {
                isValid = false;
                break;
            }
            first = midOrder.get(i);
        }
        return isValid;

    }

    ArrayList<Integer> midOrder(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return new ArrayList<Integer>();
        }

        result.addAll(midOrder(root.left));
        result.add(root.val);
        result.addAll(midOrder(root.right));
        return result;

    }


    private void swap(int[] a, int pre, int i) {
        int temp = a[pre];
        a[pre] = a[i];
        a[i] = temp;
    }
}
