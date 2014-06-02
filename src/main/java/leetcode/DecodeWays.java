package leetcode;

/**
 * Created by Jacob on 2014/5/6.
 */
public class DecodeWays {

    public static void main(String[] args) {
        DecodeWays solution = new DecodeWays();
        System.out.println(solution.numDecodings("1"));
    }

    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int[] store = new int[s.length() + 1];
        store[0] = 1;
        store[1] = 1;
        if (s.charAt(s.length() - 1) == '0') {
            store[1] = 0;
        }
        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(s.length() - i) == '0') {
                store[i] = 0;
            } else if (s.charAt(s.length() - i) == '1') {
                store[i] = store[i - 1] + store[i - 2];
            } else if (s.charAt(s.length() - i) == '2') {
                if (s.charAt(s.length() - i + 1) <= '6') {
                    store[i] = store[i - 1] + store[i - 2];
                } else {
                    store[i] = store[i - 1];
                }
            } else {
                store[i] = store[i - 1];
            }
        }
        return store[store.length - 1];
    }

    /**
     * A message containing letters from A-Z is being encoded to numbers using the following mapping:
     * <p/>
     * 'A' -> 1
     * 'B' -> 2
     * ...
     * 'Z' -> 26
     * Given an encoded message containing digits, determine the total number of ways to decode it.
     * <p/>
     * For example,
     * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
     * <p/>
     * The number of ways decoding "12" is 2.
     *
     * @param s
     * @return
     */
    public int numDecodings1(String s) {
        if (s.length() == 0) {
            return 1;
        }
        if (s.length() == 1) {
            return 1;
        }
        if (s.charAt(0) == '1') {
            if (s.charAt(1) == '0') {
                return numDecodings(s.substring(2));
            } else {
                return (numDecodings(s.substring(1))) + (numDecodings(s.substring(2)));
            }
        }
        if (s.charAt(0) == '2') {
            if (s.charAt(1) == '0') {
                return numDecodings(s.substring(2));
            } else if (s.charAt(1) >= '7' && s.charAt(1) <= 9) {
                return numDecodings(s.substring(1));
            } else {
                return (numDecodings(s.substring(1))) + (numDecodings(s.substring(2)));
            }
        }
        return (numDecodings(s.substring(1)));
    }

    private void swap(int[] a, int pre, int i) {
        int temp = a[pre];
        a[pre] = a[i];
        a[i] = temp;
    }
}
