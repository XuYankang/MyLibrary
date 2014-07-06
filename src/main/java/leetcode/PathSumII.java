package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jacob on 14-7-5.
 */
public class PathSumII {


    public static void main(String[] args) {
        TreeNode treeNode = Tool.stringToTree("5 4 8 11 # 13 4 7 2 # # 5 1");
        PathSumII pathSum = new PathSumII();
        List<List<Integer>> result = pathSum.pathSum(treeNode, 22);
        System.out.println(result);
    }


    /**
     * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
     * <p/>
     * For example:
     * Given the below binary tree and sum = 22,
     * 5
     * / \
     * 4   8
     * /   / \
     * 11  13  4
     * /  \    / \
     * 7    2  5   1
     * return
     * [
     * [5,4,11,2],
     * [5,8,4,5]
     * ]
     *
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        List<Integer> current = new ArrayList<Integer>();
        pathSum(root, result, current, sum);
        return result;
    }

    private void pathSum(TreeNode root, List<List<Integer>> result, List<Integer> current, int sum) {

        if (root.val == sum && root.left == null && root.right == null) {
            current.add(root.val);
            result.add(new ArrayList<Integer>(current));
            current.remove(current.size() - 1);
        }

        if (root.left != null) {
            current.add(root.val);
            pathSum(root.left, result, current, sum - root.val);
            current.remove(current.size() - 1);
        }
        if (root.right != null) {
            current.add(root.val);
            pathSum(root.right, result, current, sum - root.val);
            current.remove(current.size() - 1);
        }


    }

}