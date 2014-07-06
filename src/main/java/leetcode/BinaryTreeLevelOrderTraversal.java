package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Jacob on 2014/5/6.
 */
public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal solution = new BinaryTreeLevelOrderTraversal();
        System.out.println(solution.levelOrder1(Tool.stringToTree("3,9,20,#,#,15,7")));
    }

    /**
     * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
     * <p/>
     * For example:
     * Given binary tree {3,9,20,#,#,15,7},
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * return its level order traversal as:
     * [
     * [3],
     * [9,20],
     * [15,7]
     * ]
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (root == null) {
            return result;
        }
        ArrayList<TreeNode> levelNode = new ArrayList<TreeNode>();
        levelNode.add(root);
        while (!levelNode.isEmpty()) {
            ArrayList<Integer> rr = new ArrayList<Integer>();
            for (TreeNode t : levelNode) {
                rr.add(t.val);
            }
            result.add(rr);

            int originalSize = levelNode.size();

            for (int i = 0; i < originalSize; i++) {
                if (levelNode.get(i).left != null) {
                    levelNode.add(levelNode.get(i).left);
                }
                if (levelNode.get(i).right != null) {
                    levelNode.add(levelNode.get(i).right);
                }
            }
            for (int i = 0; i < originalSize; i++) {
                levelNode.remove(0);
            }


        }

        return result;

    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                list.add(temp.val);
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            result.add(list);
        }
        return result;

    }


}
