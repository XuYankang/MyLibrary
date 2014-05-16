package leetcode;

import java.util.ArrayList;

/**
 * Created by Jacob on 2014/5/6.
 */
public class LetterCombinationsofaPhoneNumber {

    public static void main(String[] args) {
        LetterCombinationsofaPhoneNumber solution = new LetterCombinationsofaPhoneNumber();
        System.out.println(solution.letterCombinations(""));
    }

    /**
     * Given a digit string, return all possible letter combinations that the number could represent.
     * <p/>
     * A mapping of digit to letters (just like on the telephone buttons) is given below.
     * <p/>
     * <p/>
     * <p/>
     * Input:Digit string "23"
     * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     * Note:
     * Although the above answer is in lexicographical order, your answer could be in any order you want.
     *
     * @param digits
     * @return
     */
    public ArrayList<String> letterCombinations(String digits) {
        String[] digitalMap = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ArrayList<String> result = new ArrayList<String>();

        if (digits.length() == 0) {
            result.add("");
            return result;
        }
        if (digits.charAt(0) == '0' || digits.charAt(0) == '1') {
            return letterCombinations(digits.substring(1));
        }
        if (digits.length() == 1) {
            for (char c : digitalMap[digits.charAt(0) - '0'].toCharArray()) {
                result.add(c + "");
            }
            return result;
        }


        for (char c : digitalMap[digits.charAt(0) - '0'].toCharArray()) {
            for (String s : letterCombinations(digits.substring(1))) {
                result.add(c + s);
            }
        }
        return result;

    }


    private void swap(int[] a, int pre, int i) {
        int temp = a[pre];
        a[pre] = a[i];
        a[i] = temp;
    }
}
