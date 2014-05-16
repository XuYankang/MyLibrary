package leetcode;

/**
 * Created by Jacob on 2014/5/6.
 */
public class MedianofTwoSortedArrays {

    public static void main(String[] args) {
        MedianofTwoSortedArrays solution = new MedianofTwoSortedArrays();
        int[] A = {3,4};
        int[] B = { };
        System.out.println(solution.findMedianSortedArrays(A, B));
    }

    /**
     * There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays.
     * The overall run time complexity should be O(log (m+n)).
     *
     * @param A
     * @param B
     * @return
     */
    public double findMedianSortedArrays(int A[], int B[]) {
        int totalLength = A.length + B.length;

        if (totalLength % 2 == 1) {
            int middle = totalLength / 2;
            if (middle < A.length) {
                return A[middle];
            } else {
                return B[middle - A.length];
            }
        } else {
            int middle2 = totalLength / 2;
            int middle1 = middle2 - 1;
            int total = 0;
            if (middle1 < A.length) {
                total += A[middle1];
            } else {
                total += B[middle1 - A.length];
            }
            if (middle2 < A.length) {
                total += A[middle2];
            } else {
                total += B[middle2 - A.length];
            }
            return total / 2.0;
        }
    }


    private void swap(int[] a, int pre, int i) {
        int temp = a[pre];
        a[pre] = a[i];
        a[i] = temp;
    }
}
