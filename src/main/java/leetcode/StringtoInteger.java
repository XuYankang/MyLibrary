package leetcode;

/**
 * Created by Jacob on 2014/5/6.
 */
public class StringtoInteger {

    public static void main(String[] args) {
        StringtoInteger solution = new StringtoInteger();
        System.out.println(solution.atoi(" +b211228552307"));
    }

    /**
     * Implement atoi to convert a string to an integer.
     * <p/>
     * Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
     * <p/>
     * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
     * <p/>
     * spoilers alert... click to show requirements for atoi.
     * <p/>
     * Requirements for atoi:
     * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
     * <p/>
     * The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
     * <p/>
     * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
     * <p/>
     * If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
     *
     * @param str
     * @return
     */
    public int atoi(String str) {
        if (str.length() == 0) {
            return 0;
        }
        char[] array = str.toCharArray();
        int result = 0;
        boolean negative = false;
        int start = 0;
        for (int i = 0; i < array.length; i++) {
            char c = array[i];
            if (c >= '0' && c <= '9') {
                break;
            } else {
                if (c == ' ') {
                    start++;
                    continue;
                } else if (c == '-') {
                    negative = true;
                    start++;
                    break;
                } else if (c == '+') {
                    negative = false;
                    start++;
                    break;
                } else {
                    break;
                }
            }
        }

        int length = 0;
        char last = 'c';
        for (int i = start; i < str.length(); i++) {
            char c = array[i];
            if (c >= '0' && c <= '9') {
                length++;
                last = c;
            } else {
                break;
            }
        }
        int count = 0;
        if (length > 10) {
            return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        for (int i = start; i < str.length(); i++) {
            char c = array[i];
            if (c >= '0' && c <= '9') {
                result = result * 10 + c - '0';
                count++;

                if (count == 9 && (result > 214748364 ||
                        (result == 214748364 && ((negative && last >= '8') || (!negative && last >= '7'))))) {
                    return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
            } else {
                break;
            }
        }


        return negative ? -result : result;
    }


    private void swap(int[] a, int pre, int i) {
        int temp = a[pre];
        a[pre] = a[i];
        a[i] = temp;
    }
}
