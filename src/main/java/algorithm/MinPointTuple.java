package algorithm;

/**
 * Created by Administrator on 2014/4/22.
 */
public class MinPointTuple {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        int x = 1;
        for (int i = -3; i < 20; i++) {
            int result = find(A, i, 0, A.length - 1);
            System.out.println(result);
        }
    }

    static int find = -1;

    private static int find(int[] A, int x, int start, int end) {
        if (start <= end) {
            int mid = (start + end) / 2;
            if (A[mid] == x) {
                return mid;
            } else {
                if (x < A[mid]) {
                    return find(A, x, start, mid - 1);
                } else {
                    return find(A, x, mid + 1, end);
                }
            }
        }

        return -100;
    }


}
