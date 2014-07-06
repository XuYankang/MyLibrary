package leetcode;

import leetcode.base.TreeLinkNode;

import java.util.LinkedList;

/**
 * Created by Jacob on 2014/5/6.
 */
public class PopulatingNextRightPointersinEachNode {

    public static void main(String[] args) {
        PopulatingNextRightPointersinEachNode solution = new PopulatingNextRightPointersinEachNode();

    }

    /**
     * Given a binary tree
     * <p/>
     * struct TreeLinkNode {
     * TreeLinkNode *left;
     * TreeLinkNode *right;
     * TreeLinkNode *next;
     * }
     * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
     * <p/>
     * Initially, all next pointers are set to NULL.
     * <p/>
     * Note:
     * <p/>
     * You may only use constant extra space.
     * You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
     * For example,
     * Given the following perfect binary tree,
     * 1
     * /  \
     * 2    3
     * / \  / \
     * 4  5  6  7
     * After calling your function, the tree should look like:
     * 1 -> NULL
     * /  \
     * 2 -> 3 -> NULL
     * / \  / \
     * 4->5->6->7 -> NULL
     *
     * @param root
     */
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeLinkNode temp = queue.removeFirst();
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            //connect
            for (int i = 0; i < queue.size() - 1; i++) {
                queue.get(i).next = queue.get(i + 1);
            }
        }
    }

    public void connect1(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            root.left.next = root.right;
        }
        if (root.right != null) {
            root.right.next = root.next == null ? null : root.next.left;
        }
        connect1(root.left);
        connect1(root.right);
    }
}
