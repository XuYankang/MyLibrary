package leetcode;

/**
 * Created by Jacob on 2014/5/6.
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        LongestCommonPrefix solution = new LongestCommonPrefix();
        String[] strs = {"aca", "cba"};
        System.out.println(solution.longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String common = "";
        for (int j = 0; j < strs[0].length(); j++) {
            char c = strs[0].charAt(j);
            boolean isCommon = true;
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].length() <= j || strs[i].charAt(j) != c) {
                    isCommon = false;
                    break;
                }
            }
            if (isCommon) {
                common += c;
            } else {
                break;
            }
        }
        return common;
    }


    private void swap(int[] a, int pre, int i) {
        int temp = a[pre];
        a[pre] = a[i];
        a[i] = temp;
    }
}
