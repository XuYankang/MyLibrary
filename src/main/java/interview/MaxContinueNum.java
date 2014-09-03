package interview;

import java.util.Scanner;

/**
 * Created by jacob on 14-9-3.
 * 输入一串数字，找到其中包含的最大递增数。递增数是指相邻的数位从小到大排列的数字。如： 2895345323，递增数有：289，345，23, 那么最大的递减数为345。
 * <p/>
 * 123526897215
 * 2689
 */

public class MaxContinueNum {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            int max = Integer.valueOf(line.charAt(0) + "");
            int start = 0;
            char cur = line.charAt(0);

            for (int i = 1; i < line.length(); i++) {
                if (line.charAt(i) > line.charAt(i - 1)) {
                    int now = Integer.valueOf("" + line.substring(start, i + 1));
                    max = max < now ? now : max;
                } else {
                    start = i;

                }
            }
            System.out.println(max);

        }
    }
}
