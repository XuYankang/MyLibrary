package leetcode;

/**
 * Created by Jacob on 2014/5/6.
 */
public class RemoveElement {

    public static void main(String[] args) {
        RemoveElement solution = new RemoveElement();
        System.out.println(solution.removeElement(new int[]{4, 4}, 4));
    }

    /**
     * Given an array and a value, remove all instances of that value in place and return the new length.
     * <p/>
     * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
     *
     * @param A
     * @param elem
     * @return
     */
    public int removeElement(int[] A, int elem) {
        int len = 0;

        int size = A.length;
        for (int i = 0; i < size; i++) {

            if (A[i] == elem) {
                while (A[size - 1] == elem && size - 1 > i) {
                    size--;
                }
                swap(A, size - 1, i);
                size--;
                i--;
            } else {
                len++;
            }
        }
        return len;
    }


    private void swap(int[] a, int pre, int i) {
        int temp = a[pre];
        a[pre] = a[i];
        a[i] = temp;
    }
}
