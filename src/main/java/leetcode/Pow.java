package leetcode;

/**
 * Created by Jacob on 2014/5/6.
 */
public class Pow {

    public static void main(String[] args) {
        Pow solution = new Pow();
        System.out.println(solution.pow(1.00000, -2147483648));
    }

    /**
     * Implement pow(x, n).
     *
     * @param x
     * @param n
     * @return
     */

    public double pow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        if (x == -1) {
            return (n & 1) == 0 ? 1 : -1;
        }

        if (n < 0) {
            n = -n;
            return 1.0 / pow1(x, n);
        }
        return pow1(x, n);
    }

    public double pow1(double x, int n) {

        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }

        if ((n & 1) == 1) {
            return x * pow1(x, n - 1);
        } else {
            double temp = pow1(x, n >> 1);
            return temp * temp;
        }
    }


    private void swap(int[] a, int pre, int i) {
        int temp = a[pre];
        a[pre] = a[i];
        a[i] = temp;
    }
}
