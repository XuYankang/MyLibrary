package leetcode;

/**
 * Created by Administrator on 2014/5/6.
 */
public class Trap {

    public static void main(String[] args) {
        Trap solution = new Trap();
        int[] A = {};
        solution.trap(A);
        System.out.println();
    }

    /**
     * Given n non-negative integers representing an elevation map where the width of each bar is 1,
     * compute how much water it is able to trap after raining.
     * <p/>
     * For example,
     * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
     *
     * @param A
     * @return
     */
    public int trap(int[] A) {
        if(A.length<1){
            return 0;
        }
        int maxIndex = findMax(A);
        int water = 0;
        int wall = A[0];
        for (int i = 1; i <= maxIndex; i++) {
            if (wall <= A[i]) {
                wall = A[i];
            } else {
                water += (wall - A[i]);
            }
        }
        wall = A[A.length-1];
        for (int j = A.length - 2; j >= maxIndex; j--) {
            if(wall <= A[j]){
                wall = A[j];
            }else{
                water += (wall - A[j]);
            }
        }

        return water;
    }

    private int findMax(int[] a) {
        int max = a[0];
        int maxIndex = 0;
        for (int i = 1; i < a.length; i++) {
            if (max < a[i]) {
                max = a[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }


    private void swap(int[] a, int pre, int i) {
        int temp = a[pre];
        a[pre] = a[i];
        a[i] = temp;
    }
}
