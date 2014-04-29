package algorithm;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Administrator on 2014/4/29.
 */
public class QuickSort {
    public static void main(String[] args) {
        Integer[] x = {7, 4, 2, 3, 6, 5, 4, 1};
        String[] y = {"pod", "abc", "eee", "aaa"};
        quicksort(y, 0, y.length);
        System.out.println(Arrays.toString(y))
        ;
    }

    public static <T extends Comparable<T>> void quicksort(T[] x, int start, int end) {
        if (start < end) {
            int mid = partition(x, start, end);
            quicksort(x, start, mid);
            quicksort(x, mid + 1, end);
        }
    }


    public static <T extends Comparable<T>> int partition(T[] x, int start, int end) {
        int mid = (start + end) / 2;
        T t = x[mid];
        swap(x, mid, end - 1);
        int i = start - 1;
        for (int j = start; j < end - 1; j++) {
            if (x[j].compareTo(t) < 0) {
                i++;
                swap(x, i, j);
            }
        }
        swap(x, end - 1, i + 1);
        return i + 1;
    }

    private static <T> void swap(T[] x, int i, int j) {
        T t = x[i];
        x[i] = x[j];
        x[j] = t;
    }

}
