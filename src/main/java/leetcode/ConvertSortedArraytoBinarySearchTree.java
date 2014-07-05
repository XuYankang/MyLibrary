package leetcode;

/**
 * Created by Jacob on 2014/5/6.
 */
public class ConvertSortedArraytoBinarySearchTree {

    public static void main(String[] args) {
        ConvertSortedArraytoBinarySearchTree solution = new ConvertSortedArraytoBinarySearchTree();

        System.out.println(solution.sortedArrayToBST(Tool.generateContinuousNumber(1, 10)));
    }


    /**
     * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
     *
     * @param num
     * @return
     */
    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null || num.length == 0) {
            return null;
        }
        return sortedArrayToBST(num, 0, num.length);
    }

    public TreeNode sortedArrayToBST(int[] num, int start, int end) {
        if (start == end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = sortedArrayToBST(num,start,mid);
        root.right = sortedArrayToBST(num,mid+1,end);
//
//        if (mid - start > 0) {
//            root.left = sortedArrayToBST(num, start, mid);
//        }
//        if (end - mid > 0) {
//            root.right = sortedArrayToBST(num, mid + 1, end);
//        }
        return root;
    }


}
