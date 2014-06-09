package leetcode;

/**
 * Created by Jacob on 2014/5/6.
 */
public class Searcha2DMatrix {

    public static void main(String[] args) {
        Searcha2DMatrix solution = new Searcha2DMatrix();
        //int[][] martrix = {{1}};
        int[][] martrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        System.out.println(solution.searchMatrix(martrix, 3));
        System.out.println(solution.searchMatrix(martrix, 1));
        System.out.println(solution.searchMatrix(martrix, 0));
        System.out.println(solution.searchMatrix(martrix, 8));
        System.out.println(solution.searchMatrix(martrix, 10));
        System.out.println(solution.searchMatrix(martrix, 24));
        System.out.println(solution.searchMatrix(martrix, 66));
    }

    /**
     * Write an efficient algorithm that searches for a value in an m x n matrix.
     * This matrix has the following properties:
     * <p/>
     * Integers in each row are sorted from left to right.
     * The first integer of each row is greater than the last integer of the previous row.
     * For example,
     * <p/>
     * Consider the following matrix:
     * <p/>
     * [
     * [1,   3,  5,  7],
     * [10, 11, 16, 20],
     * [23, 30, 34, 50]
     * ]
     * Given target = 3, return true.
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        //find row
        if (target < matrix[0][0]) {
            return false;
        }

        int startRow = 0;
        int endRow = matrix.length - 1;
        while (startRow <= endRow) {
            int midRow = (startRow + endRow) / 2;
            if (target == matrix[midRow][0]) {
                return true;
            } else if (target < matrix[midRow][0]) {
                endRow = midRow - 1;
            } else {
                startRow = midRow + 1;
            }
        }
        int currentRow = startRow;
        if (startRow == matrix.length || matrix[currentRow][0] > target) {
            currentRow -= 1;
        }
        //currentRow = (startRow == matrix.length ? startRow - 1 : startRow);
//        System.out.println(currentRow);
        int startCol = 0;
        int endCol = matrix[currentRow].length-1;
        while (startCol <= endCol) {
            int midCol = (startCol + endCol) / 2;
            if (target < matrix[currentRow][midCol]) {
                endCol = midCol-1;
            } else if (target > matrix[currentRow][midCol]) {
                startCol = midCol + 1;
            } else {
                return true;
            }
        }

        return false;

    }


}
