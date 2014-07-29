package leetcode;

/**
 * Created by Jacob on 2014/5/6.
 */
public class SearchInsertPosition {

    public static void main(String[] args) {
        SearchInsertPosition solution = new SearchInsertPosition();
        int[] A = {1, 3, 5, 6};
        System.out.println(solution.searchInsert(A, 0));
    }

    /**
     * Given a sorted array and a target value, return the index if the target is found.
     * If not, return the index where it would be if it were inserted in order.
     * <p/>
     * You may assume no duplicates in the array.
     * <p/>
     * Here are few examples.
     * [1,3,5,6], 5 → 2
     * [1,3,5,6], 2 → 1
     * [1,3,5,6], 7 → 4
     * [1,3,5,6], 0 → 0
     *
     * @param A
     * @param target
     * @return
     */
    public int searchInsert(int[] A, int target) {

        if (A == null || A.length == 0) {
            return 0;
        }
        return search(A, target, 0, A.length);

    }

    public int search(int[] A, int target, int start, int end) {
        if (start >= end) {
            return start;
        }
        int mid = (start + end) / 2;
        if (target == A[mid]) {
            return mid;
        } else if (target > A[mid]) {
            return search(A, target, mid + 1, end);
        } else {
            return search(A, target, start, mid);
        }
    }


}
