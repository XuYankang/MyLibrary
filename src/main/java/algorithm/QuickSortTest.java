package algorithm;

import java.util.Arrays;

/**
 * Created by Administrator on 2014/5/4.
 */
public class QuickSortTest {

    public static void main(String[] args) {
        int[] x = {4, 5, 2, 6, 8, 1, 5};
        quicksort(x, 0, x.length);
        System.out.println(Arrays.toString(x));
    }

    private static void quicksort(int[] array, int start, int end) {
        if (start < end) {
            int k = partition(array, start, end);
            quicksort(array, start, k);
            quicksort(array, k + 1, end);
        }
    }

    private static int partition(int[] array, int start, int end) {

        int x = array[end - 1];

        int i = start - 1;

        for (int j = start; j < end - 1; j++) {
            if (array[j] < x) {
                i++;
                swap(array, i, j);
            }
        }
        i++;
        swap(array, i, end - 1);

        return i;

    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
