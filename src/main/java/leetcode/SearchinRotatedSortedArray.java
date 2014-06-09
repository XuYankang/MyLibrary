package leetcode;

/**
 * Created by Jacob on 2014/5/6.
 */
public class SearchinRotatedSortedArray {

    public static void main(String[] args) {
        SearchinRotatedSortedArray solution = new SearchinRotatedSortedArray();
        int[] A = {1, 2, 3};
        System.out.println(solution.search(A, 3));
    }

    /**
     * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
     * <p/>
     * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
     * <p/>
     * You are given a target value to search. If found in the array return its index, otherwise return -1.
     * <p/>
     * You may assume no duplicate exists in the array.
     *
     * @param A
     * @param target
     * @return
     */
    public int search(int[] A, int target) {
        //find pivot
        int pivot = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] > A[i]) {
                pivot = i;
                break;
            }
        }

        int relativeStart = 0;
        int relativeEnd = A.length - 1;
        while (relativeStart <= relativeEnd) {
            int relativeMid = (relativeStart + relativeEnd) / 2;
            int mid = pivot + relativeMid >= A.length ? pivot + relativeMid - A.length : pivot + relativeMid;

            if (A[mid] == target) {
                return mid;
            } else if (A[mid] > target) {
                relativeEnd = relativeMid - 1;
            } else {
                relativeStart = relativeMid + 1;
            }


        }

        return -1;
    }


    private void swap(int[] a, int pre, int i) {
        int temp = a[pre];
        a[pre] = a[i];
        a[i] = temp;
    }
}
