package leetcode;

/**
 * Created by Jacob on 2014/5/6.
 */
public class PalindromeNumber {

    public static void main(String[] args) {
        PalindromeNumber solution = new PalindromeNumber();
        System.out.println(solution.isPalindrome(10));
    }

    /**
     * Determine whether an integer is a palindrome. Do this without extra space.
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int xTemp = x;
        int t = 1;
        while (xTemp > 9) {
            t *= 10;
            xTemp /= 10;
        }
        int first = x / t;
        int last = x % 10;
        boolean valid = false;
        while (first == last) {
            x = (x - first * t) / 10;

            if (x == 0) {
                valid = true;
                break;
            } else {
                t /= 100;
                first = x / t;
                last = x % 10;
            }

        }

        return valid;
    }


    private void swap(int[] a, int pre, int i) {
        int temp = a[pre];
        a[pre] = a[i];
        a[i] = temp;
    }
}
