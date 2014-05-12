package leetcode;

/**
 * Created by Administrator on 2014/5/6.
 */
public class ReverseInteger {

    public static void main(String[] args) {
        ReverseInteger solution = new ReverseInteger();
        System.out.println(solution.reverse(-1110));
    }

    /**
     * Reverse digits of an integer.
     * <p/>
     * Example1: x = 123, return 321
     * Example2: x = -123, return -321
     *
     * @param x
     * @return
     */
    public int reverse(int x) {

        String result = "";
        boolean isNagtive = false;
        if (x < 0) {
            isNagtive = true;
            x = -x;
        }
        char[] xString = String.valueOf(x).toCharArray();
        int i = 0;
        int j = xString.length - 1;
        while (i < j) {
            swap(xString, i++, j--);
        }
        int r = Integer.parseInt(String.valueOf(xString));
        return isNagtive == true ? -r : r;
    }


    private void swap(char[] a, int pre, int i) {
        char temp = a[pre];
        a[pre] = a[i];
        a[i] = temp;
    }
}
