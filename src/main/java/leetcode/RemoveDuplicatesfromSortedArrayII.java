package leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by Jacob on 2014/5/6.
 */
public class RemoveDuplicatesfromSortedArrayII {

    public static void main(String[] args) {
        RemoveDuplicatesfromSortedArrayII solution = new RemoveDuplicatesfromSortedArrayII();
        int[] A = {1, 1, 1, 1, 3, 3};
        System.out.println(solution.removeDuplicates(A));
        System.out.println(Arrays.toString(A));
    }

    int removeDuplicates1(int A[]) {
        if (A.length <= 2) {
            return A.length;
        }
        int len = 2;
        int itor = 2;
        while (itor < A.length) {
            if (A[itor] != A[len - 2]) {
                A[len++] = A[itor];
            }
            itor++;
        }
        return len;
    }

    /**
     * Follow up for "Remove Duplicates":
     * What if duplicates are allowed at most twice?
     * <p/>
     * For example,
     * Given sorted array A = [1,1,1,2,2,3],
     * <p/>
     * Your function should return length = 5, and A is now [1,1,2,2,3].
     *
     * @param A
     * @return
     */
    public int removeDuplicates(int[] A) {
        int count = 1;
        int countAll = 0;
        int pre = Integer.MIN_VALUE;
        int removed = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < A.length; i++) {
            int a = A[i];
            if (a == pre) {
                count++;
            } else {
                count = 1;
            }
            pre = a;
            if (count <= 2) {
                countAll++;
            } else {
                set.add(i);
                removed++;
            }
        }
        int index = 0;
        int[] B = new int[A.length - removed];
        for (int i = 0; i < A.length; i++) {
            if (!set.contains(i)) {
                B[index++] = A[i];
            }
        }

        for (int i = 0; i < B.length; i++) {
            A[i] = B[i];
        }
        return countAll;
    }


    private void swap(int[] a, int pre, int i) {
        int temp = a[pre];
        a[pre] = a[i];
        a[i] = temp;
    }
}
