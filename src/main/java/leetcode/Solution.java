package leetcode;

/**
 * Created by Administrator on 2014/5/6.
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println();
    }




    private void swap(int[] a, int pre, int i) {
        int temp = a[pre];
        a[pre] = a[i];
        a[i] = temp;
    }
}
