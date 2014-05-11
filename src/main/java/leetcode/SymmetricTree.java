package leetcode;

import java.util.ArrayList;

/**
 * Created by Administrator on 2014/5/6.
 */
public class SymmetricTree {

    public static void main(String[] args) {
        SymmetricTree solution = new SymmetricTree();
        TreeNode root = Tool.stringToTree("1,2,3,3,#,2,#");

        System.out.println(solution.isSymmetric(root));
    }

    /**
     * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
     * <p/>
     * For example, this binary tree is symmetric:
     * <p/>
     * 1
     * / \
     * 2   2
     * / \ / \
     * 3  4 4  3
     * But the following is not:
     * 1
     * / \
     * 2   2
     * \   \
     * 3    3
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        reverseTree(root.left);

        ArrayList<Integer> leftOrder = midOrder(root.left);
        ArrayList<Integer> rightOrder = midOrder(root.right);
        boolean isSame = true;
        if (leftOrder.size() != rightOrder.size()) {
            isSame = false;
        } else {
            for (int i = 0; i < leftOrder.size(); i++) {
                if (leftOrder.get(i) != rightOrder.get(i)) {
                    isSame = false;
                    break;
                }
            }
            leftOrder = preOrder(root.left);
            rightOrder = preOrder(root.right);
            for (int i = 0; i < leftOrder.size(); i++) {
                if (leftOrder.get(i) != rightOrder.get(i)) {
                    isSame = false;
                    break;
                }
            }
        }
        return isSame;
    }

    private void reverseTree(TreeNode node) {

        if (node == null || (node.left == null && node.right == null)) {
            return;
        }
        if (node.left != null) {
            reverseTree(node.left);
        }
        if (node.right != null) {
            reverseTree(node.right);
        }
        TreeNode temp = node.right;
        node.right = node.left;
        node.left = temp;
    }

    private ArrayList<Integer> midOrder(TreeNode t) {
        if (t == null) {
            return new ArrayList<Integer>();
        }


        ArrayList<Integer> list = new ArrayList<Integer>();

        list.addAll(midOrder(t.left));
        list.add(t.val);
        list.addAll(midOrder(t.right));

        return list;
    }

    private ArrayList<Integer> preOrder(TreeNode t) {
        if (t == null) {
            return new ArrayList<Integer>();
        }


        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(t.val);
        list.addAll(preOrder(t.left));
        list.addAll(preOrder(t.right));

        return list;
    }
}
