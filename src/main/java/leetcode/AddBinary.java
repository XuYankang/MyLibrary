package leetcode;

/**
 * Created by Jacob on 2014/5/6.
 */
public class AddBinary {

    public static void main(String[] args) {
        AddBinary solution = new AddBinary();
        System.out.println(solution.addBinary("0", "10"));
    }

    /**
     * Given two binary strings, return their sum (also a binary string).
     * <p/>
     * For example,
     * a = "11"
     * b = "1"
     * Return "100".
     *
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {

        boolean carryOver = false;

        int i = a.length() - 1;
        int j = b.length() - 1;

        String resultString = "";
        while (i >= 0 || j >= 0) {
            char aa = '0', bb = '0';
            if (i >= 0) {
                aa = a.charAt(i);
                i--;
            }
            if (j >= 0) {
                bb = b.charAt(j);
                j--;
            }
            char result = carryOver ? '1' : '0';
            if (aa == '1' && bb == '1') {
                if (carryOver) {
                    result = '1';
                } else {
                    result = '0';
                }
                carryOver = true;
            } else if ((aa == '1' && bb == '0') || (aa == '0' && bb == '1')) {
                if (carryOver) {
                    result = '0';
                    carryOver = true;
                } else {
                    result = '1';
                    carryOver = false;
                }
            } else if (aa == '0' && bb == '0') {
                result = carryOver ? '1' : '0';
                carryOver = false;
            }
            resultString = result + resultString;

        }

        if (carryOver) {
            resultString = '1' + resultString;
        }
        return resultString;

    }


    private void swap(int[] a, int pre, int i) {
        int temp = a[pre];
        a[pre] = a[i];
        a[i] = temp;
    }
}
