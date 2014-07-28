package leetcode;

/**
 * Created by Jacob on 2014/5/6.
 */
public class SearchInsertPosition {

    public static void main(String[] args) {
        SearchInsertPosition solution = new SearchInsertPosition();
        System.out.println(3);
    }




    private void swap(int[] a, int pre, int i) {
        int temp = a[pre];
        a[pre] = a[i];
        a[i] = temp;
    }
}
