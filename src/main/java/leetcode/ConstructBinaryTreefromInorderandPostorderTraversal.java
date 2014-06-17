package leetcode;

/**
 * Created by Jacob on 2014/5/6.
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {

    public static void main(String[] args) {
        ConstructBinaryTreefromInorderandPostorderTraversal solution = new ConstructBinaryTreefromInorderandPostorderTraversal();
        int[] postorder = {4, 1, 3, 10, 11, 8, 2, 7};
        int[] inorder = {4, 10, 3, 1, 7, 11, 8, 2};
        System.out.println(solution.buildTree(inorder, postorder));
    }

    /**
     * Given inorder and postorder traversal of a tree, construct the binary tree.
     * <p/>
     * Note:
     * You may assume that duplicates do not exist in the tree.
     *
     * @param postorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || inorder == null || postorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return buildTree(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }


    public TreeNode buildTree(int[] inorder, int is, int ie, int[] postorder, int ps, int pe) {

        if (ps == pe || is == ie) {
            return null;
        }

        int rootVal = postorder[pe - 1];
        int rootPosInInorder = pe - 1;
        for (int i = is; i < ie; i++) {
            if (inorder[i] == rootVal) {
                rootPosInInorder = i;
                break;
            }
        }
        int leftSize = rootPosInInorder - is;
        TreeNode root = new TreeNode(rootVal);

        root.left = buildTree(inorder, is, is + leftSize, postorder, ps, ps + leftSize);
        root.right = buildTree(inorder, rootPosInInorder + 1, ie, postorder, ps + leftSize, pe - 1);

        return root;
    }

    private void swap(int[] a, int pre, int i) {
        int temp = a[pre];
        a[pre] = a[i];
        a[i] = temp;
    }
}
