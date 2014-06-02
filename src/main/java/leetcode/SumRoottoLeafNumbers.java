package leetcode;

import java.util.ArrayList;

/**
 * Created by Jacob on 2014/5/6.
 */
public class SumRoottoLeafNumbers {

    public static void main(String[] args) {
        SumRoottoLeafNumbers solution = new SumRoottoLeafNumbers();
        System.out.println(solution.sumNumbers(Tool.stringToTree("1")));
    }

    /**
     * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
     * <p/>
     * An example is the root-to-leaf path 1->2->3 which represents the number 123.
     * <p/>
     * Find the total sum of all root-to-leaf numbers.
     * <p/>
     * For example,
     * <p/>
     * 1
     * / \
     * 2   3
     * The root-to-leaf path 1->2 represents the number 12.
     * The root-to-leaf path 1->3 represents the number 13.
     * <p/>
     * Return the sum = 12 + 13 = 25.
     *
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int sum = 0;

        ArrayList<Integer> current = new ArrayList<Integer>();
        sum = findPath(root, current);

        return sum;
    }

    private int findPath(TreeNode root, ArrayList<Integer> current) {
        current.add(root.val);
        int sum = 0;

        if (root.left == null && root.right == null) {
            for (int ii : current) {
                sum = (sum * 10) + ii;
            }
        }
        if (root.left != null) {
            sum += findPath(root.left, current);
        }
        if (root.right != null) {
            sum += findPath(root.right, current);
        }
        current.remove(current.size() - 1);

        return sum;
    }


    private void swap(int[] a, int pre, int i) {
        int temp = a[pre];
        a[pre] = a[i];
        a[i] = temp;
    }
}
