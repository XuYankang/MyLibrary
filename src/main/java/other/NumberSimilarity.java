package other;

/**
 * Created by Administrator on 2014/4/21.
 */
public class NumberSimilarity {

    public static void main(String[] args) {
        System.out.println(numberSimilarity(0, 0));
    }

    public static boolean numberSimilarity(int a, int b) {
        int big = Math.max(a, b);
        int small = Math.min(a, b);
        if(big==0)
            return true;
        if (((double) small) / ((double) big) >= 0.99) {
            return true;
        }
        return false;
    }

}
