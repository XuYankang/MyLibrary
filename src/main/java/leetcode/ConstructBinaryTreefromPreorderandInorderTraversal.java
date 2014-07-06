package leetcode;

/**
 * Created by Jacob on 2014/5/6.
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {

    public static void main(String[] args) {
        ConstructBinaryTreefromPreorderandInorderTraversal solution = new ConstructBinaryTreefromPreorderandInorderTraversal();
        int[] preorder = {7, 10, 4, 3, 1, 2, 8, 11};
        int[] inorder = {4, 10, 3, 1, 7, 11, 8, 2};
        System.out.println(solution.buildTree(preorder, inorder));
    }

    /**
     * Given preorder and inorder traversal of a tree, construct the binary tree.
     * <p/>
     * Note:
     * You may assume that duplicates do not exist in the tree.
     * preorder = {7,10,4,3,1,2,8,11}
     * inorder = {4,10,3,1,7,11,8,2}
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }


    public TreeNode buildTree(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {

        if (ps == pe || is == ie) {
            return null;
        }

        int rootVal = preorder[ps];
        int rootPosInInorder = ps;
        for (int i = is; i < ie; i++) {
            if (inorder[i] == rootVal) {
                rootPosInInorder = i;
                break;
            }
        }
        int leftSize = rootPosInInorder - is;
        TreeNode root = new TreeNode(rootVal);

        root.left = buildTree(preorder, ps + 1, ps + 1 + leftSize, inorder, is, rootPosInInorder);
        root.right = buildTree(preorder, ps + 1 + leftSize, pe, inorder, rootPosInInorder + 1, ie);

        return root;
    }
}
