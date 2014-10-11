package interview.amazon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by jacob on 14-10-9.
 */
public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line1 = bufferedReader.readLine();
        String line2 = bufferedReader.readLine();
        int[] cards1 = parseLine(line1);
        int[] cards2 = parseLine(line2);
        if (cards1 == null || cards2 == null) {
            System.out.println(-2);
            return;
        }
        int value1 = judgeType(cards1);
        int value2 = judgeType(cards2);
        System.out.println(value1 > value2 ? 1 : (value1 == value2 ? 0 : -1));

    }

    private static int judgeType(int[] cards) {
        int level1 = 0, level2 = 0, level3 = 0;
        boolean getType = false;
        //type1
        for (int i = 1; i < cards.length; i++) {
            if (cards[i] == 4) {
                level1 = 6;
                level2 = i;
                return 6 * 100000000 + level2 * 100;
            }
        }
        //type3
        for (int i = 1; i < cards.length; i++) {
            if (cards[i] == 3) {
                level1 = 4;
                level2 = i;
                getType = true;
            }
            if (cards[i] == 1) {
                level3 = i;
            }
        }
        if (getType) {
            return level1 * 100000000 + level2 * 100 + level3;
        }

        ArrayList<Integer> count2 = new ArrayList<Integer>();
        ArrayList<Integer> count1 = new ArrayList<Integer>();
        for (int i = 1; i < cards.length; i++) {
            if (cards[i] == 2) {
                count2.add(i);
            }
            if (cards[i] == 1) {
                count1.add(i);
            }
        }
        //type4
        if (count2.size() == 2) {
            level1 = 3;
            level2 = Math.max(count2.get(0), count2.get(1));
            level3 = Math.min(count2.get(0), count2.get(1));
            return level1 * 100000000 + level2 * 100 + level3;
        }
        //type2
        if (count2.size() == 1 && count1.size() == 2) {
            level1 = 2;
            level2 = count2.get(0);
            level3 = Math.min(count1.get(0), count1.get(1));
            return level1 * 100000000 + level2 * 100 + level3;
        }
        //type1 or type 5
        if (count1.size() == 4) {
            Collections.sort(count1);
            //type5
            if (count1.contains(2) && count1.contains(3) && count1.contains(4) && count1.contains(14)) {
                count1.remove(new Integer(14));
                count1.add(0, 1);
            }

            if (count1.get(3) - count1.get(0) == 3) {
                level1 = 5;
                level2 = count1.get(0);
                level3 = 0;
                return level1 * 100000000 + level2 * 100 + level3;
            }
            //type1
            level1 = 1;
            level2 = count1.get(3);
            level3 = count1.get(2);

            return level1 * 100000000 + count1.get(3) * 1000000 + count1.get(2) * 10000 + count1.get(1) * 100 + count1.get(0);

        }

        return 0;
    }

    public static int[] parseLine(String line) {
        if (line == null) {
            return null;
        }
        String[] split = line.split(",");
        int[] cards = new int[15];
        for (String s : split) {
            int i = 0;
            if (s.equals("J")) {
                i = 11;
            } else if (s.equals("Q")) {
                i = 12;
            } else if (s.equals("K")) {
                i = 13;
            } else if (s.equals("A")) {
                i = 14;
            } else {
                i = Integer.valueOf(s);
                if (!(i >= 2 && i <= 10)) {
                    return null;
                }
            }

            cards[i]++;
        }
        //judge valid
        for (int i : cards) {
            if (i > 4) {
                return null;
            }
        }
        return cards;
    }

}
