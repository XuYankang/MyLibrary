package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jacob on 14-8-20.
 */
public class WordBreak {
    public static void main(String[] args) {
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        HashSet<String> set = new HashSet<String>(Arrays.asList(new String[]{"a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"}));

        WordBreak wordBreak = new WordBreak();

        String s1 = "leetcode";
        HashSet<String> set1 = new HashSet<String>(Arrays.asList(new String[]{"leet", "code"}));


        boolean result = wordBreak.wordBreak(s, set);
        boolean result1 = wordBreak.wordBreak(s1, set1);
        System.out.println(result);
        System.out.println(result1);
    }

    /**
     * Given a string s and a dictionary of words dict,
     * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
     * <p/>
     * For example, given
     * s = "leetcode",
     * dict = ["leet", "code"].
     * <p/>
     * Return true because "leetcode" can be segmented as "leet code".
     *
     * @param s
     * @param dict
     * @return
     */
    public boolean wordBreak(String s, Set<String> dict) {
        if (s.length() == 0) {
            return false;
        }

        boolean[] possiblity = new boolean[s.length()];

        for (int i = 0; i < s.length(); i++) {
            for (String word : dict) {
                if (i < word.length() - 1) {
                    continue;
                }
                if ((i - word.length() == -1 || possiblity[i - word.length()]) &&
                        s.substring(i + 1 - word.length(), i + 1 - word.length() + word.length()).equals(word)) {
                    possiblity[i] = true;
                }
            }
        }


        return possiblity[s.length() - 1];

    }
}
