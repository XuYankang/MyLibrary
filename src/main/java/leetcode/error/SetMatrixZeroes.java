package leetcode.error;

/**
 * Created by Jacob on 2014/5/6.
 */
public class SetMatrixZeroes {

    public static void main(String[] args) {
        SetMatrixZeroes solution = new SetMatrixZeroes();
        System.out.println(3);
    }

    /**
     * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
     * <p/>
     * click to show follow up.
     * <p/>
     * Follow up:
     * Did you use extra space?
     * A straight forward solution using O(mn) space is probably a bad idea.
     * A simple improvement uses O(m + n) space, but still not the best solution.
     * Could you devise a constant space solution?
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {



    }


    private void swap(int[] a, int pre, int i) {
        int temp = a[pre];
        a[pre] = a[i];
        a[i] = temp;
    }
}
