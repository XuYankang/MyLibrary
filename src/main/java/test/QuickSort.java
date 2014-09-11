package test;

import java.util.Arrays;

/**
 * Created by jacob on 14-9-11.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] A = {8, 3, 5, 1, 9, 12, 1};
        quicksort(A, 0, A.length);
        System.out.println(Arrays.toString(A));
    }

    public static void quicksort(int[] A, int start, int end) {
        if (start < end) {
            int mid = partition(A, start, end);
            quicksort(A, start, mid);
            quicksort(A, mid + 1, end);
        }
    }

    private static int partition(int[] a, int start, int end) {

        int mid = (start + end) / 2;
        int value = a[mid];
        swap(a, end - 1, mid);
        int i = start - 1;
        for (int j = start; j < end - 1; j++) {
            if (a[j] < value) {
                i++;
                swap(a, i, j);
            }
        }
        swap(a, end - 1, ++i);
        return i;


    }

    private static void swap(int[] A, int a, int b) {
        if (a == b) {
            return;
        }
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }


}
