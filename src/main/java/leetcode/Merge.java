package leetcode;

import java.util.Arrays;

/**
 * Created by Administrator on 2014/5/6.
 */
public class Merge {

    public static void main(String[] args) {

        Merge merge = new Merge();
        int[] A = new int[5];
        A[0] = 1;
        A[1] = 2;
        A[2] = 6;
        int[] B = new int[2];
        B[0] = -1;
        B[1] = 1;
        merge.merge(A, 3, B, 2);

    }


    public void merge(int A[], int m, int B[], int n) {
        int mm = m - 1;
        int nn = n - 1;
        int i;
        for (i = m + n - 1; i >= 0 && mm >= 0 && nn >= 0; i--) {
            if (A[mm] < B[nn]) {
                A[i] = B[nn];
                nn--;
            } else {
                A[i] = A[mm];
                mm--;
            }
        }
        while (nn >= 0) {
            A[i--] = B[nn--];
        }

    }


    private void swap(int[] a, int pre, int i) {
        int temp = a[pre];
        a[pre] = a[i];
        a[i] = temp;
    }
}
