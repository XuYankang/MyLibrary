package algorithm;

import java.util.Arrays;

/**
 * Created by Jacob on 14-7-26.
 */
public class QuickSortInt {


    public static void main(String[] args) {
        Integer[] A = {1, 17, 6, 8, 4, 20, 7};
        QuickSortInt q = new QuickSortInt();
        q.quicksort(A, 0, A.length);
        System.out.println(Arrays.toString(A));
    }

    public <T extends Comparable<T>> void quicksort(T[] A, int start, int end) {
        if (start < end) {
            int mid = partition(A, start, end);
            quicksort(A, start, mid);
            quicksort(A, mid + 1, end);
        }
    }

    private <T extends Comparable<T>> int partition(T[] A, int start, int end) {

        swap(A, (start + end) / 2, end - 1);

        int i = start - 1;
        for (int j = start; j < end - 1; j++) {
            if (A[j].compareTo(A[end - 1]) < 0) {
                i++;
                swap(A, i, j);
            }
        }
        swap(A, i + 1, end - 1);

        return i + 1;
    }

    private <T> void swap(T[] A, int a, int b) {
        if (a == b) {
            return;
        }
        T temp = A[a];
        A[a] = A[b];
        A[b] = temp;

    }


}
