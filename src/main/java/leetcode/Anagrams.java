package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Jacob on 2014/5/6.
 */
public class Anagrams {

    public static void main(String[] args) {
        Anagrams solution = new Anagrams();
        System.out.println(solution.anagrams(new String[]{"and","dan"}));
    }


    public ArrayList<String> anagrams(String[] strs) {
        HashSet<String> set = new HashSet<String>();
        HashMap<String, ArrayList<String>> group = new HashMap<String, ArrayList<String>>();
        for (String s : strs) {
            char[] array = s.toCharArray();
            Arrays.sort(array);
            String newS = new String(array);
            if (group.containsKey(newS)) {
                group.get(newS).add(s);
            } else {
                ArrayList<String> g = new ArrayList<String>();
                g.add(s);
                group.put(newS, g);
            }
        }
        ArrayList<String> result = new ArrayList<String>();

        for (String s : group.keySet()) {
            ArrayList<String> g = group.get(s);
            if (g.size() > 1) {
                result.addAll(g);
            }
        }
        return result;
    }


    private void swap(int[] a, int pre, int i) {
        int temp = a[pre];
        a[pre] = a[i];
        a[i] = temp;
    }
}
