package leetcode;

/**
 * Created by Administrator on 2014/5/6.
 */
public class SingleNumber {

    public static void main(String[] args) {
        int[] x = {1, 2, 4, 3, 2, 1, 3};
        new SingleNumber().singleNumber(x);
    }

    /**
     * Given an array of integers, every element appears twice except for one. Find that single one.
     * <p/>
     * Note:
     * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
     *
     * @param A
     * @return
     */
    public int singleNumber(int[] A) {

        int num = 0;
        for (int i : A) {
            num ^= i;
        }
        return num;
    }

}
