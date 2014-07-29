package leetcode;

import java.util.Arrays;

/**
 * Created by Jacob Xu on 2014/7/29.
 */
public class PlusOne {
    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        int[] digits = {1,9,9};
        System.out.println(Arrays.asList(plusOne.plusOne(digits)));
    }

    /**
     * Given a non-negative number represented as an array of digits, plus one to the number.
     * <p/>
     * The digits are stored such that the most significant digit is at the head of the list.
     *
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {

        if (digits == null || digits.length == 0) {
            return digits;
        }

        boolean hasBItCarray = false;
        int bitCarray = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int digitalResult = digits[i] + 1;
            if (digitalResult > 9) {
                bitCarray = 1;
                digits[i] = 0;
            } else {
                bitCarray = 0;
                digits[i] = digitalResult;
                return digits;
            }
        }

        if (bitCarray == 1) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                newDigits[i + 1] = digits[i];
            }
            return newDigits;
        }

        return digits;
    }
}
