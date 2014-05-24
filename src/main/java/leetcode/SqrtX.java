package leetcode;

/**
 * Created by Jacob on 2014/5/6.
 */
public class SqrtX {

    public static void main(String[] args) {
        SqrtX solution = new SqrtX();
        System.out.println(solution.sqrt(2147395599));
    }

    /**
     * Implement int sqrt(int x).
     * <p/>
     * Compute and return the square root of x.
     *
     * @param x
     * @return
     */
    public int sqrt(int x) {
        if (x <= 0) {
            return 0;
        }
        long i = 1;
        for (; i * i < x; i <<= 1) {

        }
        return (int)find(x, i >> 1, i);
    }

    private long find(long x, long small, long big) {
        if (small == big) {
            if (small * small == x) {
                return small;
            }
            return small - 1;
        }
        long mid = (small + big) / 2;
        if (mid * mid > x) {
            return find(x, small, mid);
        } else {
            return find(x, mid + 1, big);
        }
    }

    private void swap(int[] a, int pre, int i) {
        int temp = a[pre];
        a[pre] = a[i];
        a[i] = temp;
    }
}
