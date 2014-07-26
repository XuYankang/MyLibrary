package algorithm;

/**
 * Created by Jacob on 14-7-26.
 */
public class QuickSortInt {


    public static void main(String[] args) {
        int[] A = {1, 17, 6, 8, 4, 20, 7};
        QuickSortInt q = new QuickSortInt();
        q.quicksort(A, 0, A.length);
    }

    public void quicksort(int[] A, int start, int end) {
        int mid = partition(A, start, end);
        quicksort(A, start, mid);
        quicksort(A, mid + 1, end);
    }

    private int partition(int[] A, int start, int end) {

        int x = (start + end) / 2;
        swap(A, x, end - 1);

        int i = start - 1;
        for (int j = start; j < end - 1; j++) {
            if (A[j] < A[x]) {
                i++;
                swap(A, i, j);
            }
        }
        swap(A, i + 1, end - 1);

        return i + 1;
    }

    private void swap(int[] A, int a, int b) {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;

    }


}
