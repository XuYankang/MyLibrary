package algorithm;

import java.util.Arrays;

/**
 * Created by Jacob on 14-7-27.
 */
public class Heap {

    public static void main(String[] args) {
        int[] A = new int[100];
        int[] B = {0, 16, 14, 10, 8, 7, 9, 3, 2, 4, 1};

        for (int i = 0; i < 20; i++) {
            A[i] = i;
        }
        Heap heap = new Heap();
        //heap.insert(A, B.length - 1, 9);
        heap.buildMaxHeap(A, 20);
        System.out.println(Arrays.toString(A));
    }

    public int extractMax(int[] A, int len) {
        int max = A[1];
        swap(A, 1, len);
        maxHeapify(A, len - 1, 1);
        return max;
    }

    public void buildMaxHeap(int[] A, int len) {
        int x = len / 2;
        while (x > 0) {
            maxHeapify(A, len, x);
            x--;
        }
    }

    public void maxHeapify(int[] A, int len, int n) {
        while (n <= len / 2) {
            int max = n;
            int left = n << 1;
            if (left <= len && A[max] < A[left]) {
                max = left;
            }
            int right = (n << 1) + 1;
            if (right <= len && A[max] < A[right]) {
                max = right;
            }
            if (n == max) {
                return;
            }
            swap(A, max, n);
            n = max;
        }
    }

    public void insert(int[] A, int len, int key) {
        len++;
        A[len] = key;
        while (len > 1 && A[len >> 1] < A[len]) {
            swap(A, len >> 1, len);
            len = len >> 1;
        }

    }

    private void swap(int[] A, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }


}
