package leetcode;

/**
 * Created by Jacob Xu on 2014/7/29.
 */
public class SingleNumberII {

    public static void main(String[] args) {
        int[] A = {1, 1, 1, 2};
        SingleNumberII singleNumberII = new SingleNumberII();
        System.out.println(singleNumberII.singleNumber(A));
    }

    /**
     * Given an array of integers, every element appears three times except for one. Find that single one.
     * <p/>
     * Note:
     * Your algorithm should have a linear runtime complexity.
     * Could you implement it without using extra memory?
     *
     * @param A
     * @return
     */
    public int singleNumber(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int[] record = new int[32];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < record.length; j++) {
                int cur = A[i] >> j;

                if (cur == 0) {
                    break;
                }

                record[j] += (cur & 1);
            }
        }

        int k = 0;

        for (int j = 0; j < record.length; j++) {
            int c = record[j] % 3;
            if (c != 0) {
                k |= (c << j);
            }
        }
        return k;


    }
}
