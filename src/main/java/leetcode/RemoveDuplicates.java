package leetcode;

/**
 * Created by Jacob on 2014/5/6.
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] x = {1, 1, 2, 2, 3};
        RemoveDuplicates s = new RemoveDuplicates();
        s.removeDuplicates(x);
    }

    //Remove Duplicates from Sorted Array

    /**
     * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
     * <p/>
     * Do not allocate extra space for another array, you must do this in place with constant memory.
     * <p/>
     * For example,
     * Given input array A = [1,1,2],
     * <p/>
     * Your function should return length = 2, and A is now [1,2].
     *
     * @param A
     * @return
     */
    public int removeDuplicates(int[] A) {

        int length = A.length;
        if (length <= 1) {
            return length;
        }

        int pre = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] == A[pre]) {
                length--;
            } else {
                pre++;
                if (pre != i) {
                    swap(A, pre, i);
                }
            }
        }


        return length;
    }

    private void swap(int[] a, int pre, int i) {
        int temp = a[pre];
        a[pre] = a[i];
        a[i] = temp;
    }
}
