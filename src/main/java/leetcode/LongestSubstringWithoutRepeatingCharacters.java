package leetcode;

/**
 * Created by Jacob on 2014/5/6.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(solution.lengthOfLongestSubstring(""));
    }

    /**
     * Given a string, find the length of the longest substring without repeating characters.
     * For example, the longest substring without repeating letters for "abcabcbb" is "abc",
     * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int max = 0;


        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            int[] exist = new int[256];
            int cur = 0;
            for (int j = i; j < array.length; j++) {
                char c = array[j];
                if (exist[c] == 1) {
                    break;
                } else {
                    exist[c] = 1;
                    cur++;
                    if (max < cur) {
                        max = cur;
                    }
                }

            }
        }

        return max;
    }


}
