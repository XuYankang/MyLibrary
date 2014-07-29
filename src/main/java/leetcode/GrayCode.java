package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Jacob Xu on 2014/7/29.
 */
public class GrayCode {

    public static void main(String[] args) {
        GrayCode grayCode = new GrayCode();
        System.out.println(grayCode.grayCode(0));
    }

    /**
     * The gray code is a binary numeral system where two successive values differ in only one bit.
     * <p/>
     * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
     * <p/>
     * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
     * <p/>
     * 00 - 0
     * 01 - 1
     * 11 - 3
     * 10 - 2
     * Note:
     * For a given n, a gray code sequence is not uniquely defined.
     * <p/>
     * For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
     * <p/>
     * For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
     *
     * @param n
     * @return
     */
    public List<Integer> grayCode(int n) {

        List<Integer> list = new ArrayList<Integer>();

        if (n < 0) {
            return list;
        }

        list.add(0);

        for (int i = 0; i < n; i++) {
            List<Integer> temp = new ArrayList<Integer>();
            for (int t : list) {
                temp.add((1 << i) + t);
            }
            Collections.reverse(temp);
            list.addAll(temp);
        }
        return list;


    }
}
