package interview.amazon;

/**
 * Created by jacob on 14-10-9.
 */
public class P2 {
    public static void main(String[] args) {
        System.out.println(getNextSymmetricNumber("123"));
    }

    static String getNextSymmetricNumber(String n) {
        if (isSymmetric(n)) {
            //find mid
            return getNextSym(n);
        } else {
            //make n sym
            int start = 0;
            int end = n.length() - 1;
            char[] chars = n.toCharArray();
            while (start < end) {
                chars[end] = chars[start];
                start++;
                end--;
            }
            return getNextSym(String.valueOf(chars));
        }

    }

    //error, should deal with anther situation
    static String getNextSym(String n) {
        if (n.length() % 2 == 1) {
            if (n.charAt(n.length() / 2) < '9') {
                int newChar = n.charAt(n.length() / 2) + 1;
                char[] chars = n.toCharArray();
                chars[n.length() / 2] = (char) newChar;
                return String.valueOf(chars);
            } else {
                char[] chars = n.toCharArray();
                chars[n.length() / 2] = '0';
                int newChar = n.charAt(n.length() / 2) + 1;
                return String.valueOf(chars);
            }
        } else {
            if (n.charAt(n.length() / 2) < '9') {
                int newChar = n.charAt(n.length() / 2) + 1;
                char[] chars = n.toCharArray();
                chars[n.length() / 2] = (char) newChar;
                chars[n.length() / 2 - 1] = (char) newChar;
                return String.valueOf(chars);
            }
        }
        return n;
    }

    static boolean isSymmetric(String n) {
        if (n == null && n.length() <= 1) {
            return true;
        }
        int start = 0;
        int end = n.length() - 1;
        while (start < end) {
            if (n.charAt(start) == n.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }

}
