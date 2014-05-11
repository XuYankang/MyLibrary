package leetcode;

/**
 * Created by Jacob on 2014/5/6.
 */
public class SameTree {

    public static void main(String[] args) {
        SameTree solution = new SameTree();
        System.out.println();
    }

    /**
     * Given two binary trees, write a function to check if they are equal or not.
     * <p/>
     * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        } else if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }

        if (p.left == null && p.right == null && q.left == null && q.right == null && p.val == q.val) {
            return true;
        }
        if (p.val != q.val) {
            return false;
        }
        boolean result1 = true;
        boolean result2 = true;
        result1 = isSameTree(p.left, q.left);
        result2 = isSameTree(p.right, q.right);
        return result1 && result2;
    }


    private void swap(int[] a, int pre, int i) {
        int temp = a[pre];
        a[pre] = a[i];
        a[i] = temp;
    }
}
