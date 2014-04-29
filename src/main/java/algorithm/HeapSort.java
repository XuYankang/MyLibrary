package algorithm;

import java.util.Arrays;

/**
 * Created by Administrator on 2014/4/29.
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] x = {0, 1, 2, 3, 4, 5, 6};
        buildMaxHeap(x);
        System.out.println(Arrays.toString(x));
        for (int i = x.length; i > 1; i--) {
            System.out.println(extracMax(x, i));
        }
        System.out.println(Arrays.toString(x));
    }

    private static int extracMax(int[] x, int len) {

        int max = x[1];
        swap(x, 1, len - 1);
        maxHeapify(x, 1, len - 1);
        return max;

    }

    public static void buildMaxHeap(int[] x) {
        for (int i = x.length / 2; i >= 1; i--) {
            maxHeapifyNonRecursive(x, i, x.length);
        }
    }

    public static void maxHeapifyNonRecursive(int[] x, int index, int len) {
        int largest = index;

        while (largest == index) {

            int left = index << 1;
            int right = (index << 1) + 1;
            if (left <= len - 1 && x[index] < x[left]) {
                largest = left;
            }
            if (right <= len - 1 && x[largest] < x[right]) {
                largest = right;
            }
            if (largest != index) {
                swap(x, largest, index);
                index = largest;
            } else {
                break;
            }
        }

    }

    public static void maxHeapify(int[] x, int index, int len) {

        int left = index << 1;
        int right = (index << 1) + 1;
        int largest = index;
        if (left <= len - 1 && x[index] < x[left]) {
            largest = left;
        }
        if (right <= len - 1 && x[largest] < x[right]) {
            largest = right;
        }

        if (largest != index) {
            swap(x, largest, index);
            maxHeapify(x, largest, len);
        }


    }

    public static int left(int[] x, int i) {
        return x[i << 1];
    }

    public static int right(int[] x, int i) {
        return x[(i << 1) + 1];
    }

    private static void swap(int[] x, int i, int j) {
        int t = x[i];
        x[i] = x[j];
        x[j] = t;
    }
}
