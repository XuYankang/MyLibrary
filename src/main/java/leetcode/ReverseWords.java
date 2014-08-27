package leetcode;

/**
 * Created by Jacob on 2014/5/4.
 */
public class ReverseWords {


    /**
     * http://oj.leetcode.com/problems/reverse-words-in-a-string/
     * Given an input string, reverse the string word by word.
     * <p/>
     * For example,
     * Given s = "the sky is blue",
     * return "blue is sky the".
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        String[] array = s.trim().split(" +");
        reverse(array);
        String result = "";
        for (String ss : array) {
            result += ss + " ";
        }

        return result.substring(0, result.length() - 1);
    }

    private <T> void reverse(T[] array) {
        if (array.length > 0) {
            for (int i = 0, j = array.length - 1; i < j; i++, j--) {
                swap(array, i, j);
            }
        }
    }

    private <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


}

