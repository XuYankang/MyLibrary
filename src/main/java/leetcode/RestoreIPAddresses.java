package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jacob on 2014/5/6.
 */
public class RestoreIPAddresses {

    public static void main(String[] args) {
        RestoreIPAddresses solution = new RestoreIPAddresses();
        System.out.println(solution.restoreIpAddresses("010010"));
    }

    /**
     * Given a string containing only digits,
     * restore it by returning all possible valid IP address combinations.
     * <p/>
     * For example:
     * Given "25525511135",
     * <p/>
     * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
     *
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses(String s) {
        ArrayList<String> result = new ArrayList<String>();

        if (s == null || s.length() < 4 || s.length() > 12) {
            return result;
        }

        ArrayList<String> current = new ArrayList<String>();
        dfs(s, current, result);
        return result;
    }

    private void dfs(String s, ArrayList<String> current, ArrayList<String> result) {
        if (current.size() == 4 && s.length() == 0) {
            result.add(toIpString(current));
            return;
        }
        for (String a : validPossible(s)) {
            current.add(a);
            dfs(s.substring(a.length()), current, result);
            current.remove(current.size() - 1);
        }
    }

    /**
     * 返回可用的ip部分。包括，如果是2位数，首位不能为0. 如果是3位数，首位不能为0,且其值要小于255.
     * @param s
     * @return
     */
    private ArrayList<String> validPossible(String s) {
        ArrayList<String> possible = new ArrayList<String>();
        if (s.length() >= 1) {
            possible.add(s.substring(0, 1));
        }
        if (s.length() >= 2) {
            String xx = s.substring(0, 2);
            if (!xx.startsWith("0")) {
                possible.add(s.substring(0, 2));
            }
        }
        if (s.length() >= 3) {
            String xx = s.substring(0, 3);
            if (Integer.valueOf(xx) <= 255 && !xx.startsWith("0")) {
                possible.add(xx);
            }
        }
        return possible;
    }

    private String toIpString(ArrayList<String> current) {
        String result = "";
        for (String s : current) {
            result += s + ".";
        }
        return result.substring(0, result.length() - 1);
    }


}
