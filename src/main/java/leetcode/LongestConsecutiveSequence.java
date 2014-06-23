package leetcode;

import java.util.HashMap;

/**
 * Created by Jacob on 2014/5/6.
 */
public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        LongestConsecutiveSequence solution = new LongestConsecutiveSequence();
        System.out.println(solution.longestConsecutive(new int[]{100}));
    }


    /**
     * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
     * <p/>
     * For example,
     * Given [100, 4, 200, 1, 3, 2],
     * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
     * <p/>
     * Your algorithm should run in O(n) complexity.
     *
     * @return
     */
    public int longestConsecutive(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }

        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        for (int i : num) {
            map.put(i, false);
        }

        int longest = 1;
        for (int i : num) {
            //increase
            int size = 0;
            int cur = i;
            while (map.get(cur) != null && map.get(cur) == false && map.containsKey(cur)) {
                map.put(cur, true);
                cur++;
                size++;
            }
            //decrease
            cur = i - 1;
            while (map.get(cur) != null && map.get(cur) == false && map.containsKey(cur)) {
                map.put(cur, true);
                cur--;
                size++;
            }
            longest = longest < size ? size : longest;
        }

        return longest;
    }


}
