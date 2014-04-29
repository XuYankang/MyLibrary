package algorithm;

import print.Print;

import java.util.Scanner;

public class MaxPalindrome {


    public static void main(String[] args) {
//babcbabcbaccba
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            int max = 0;
            String s = scan.nextLine();

            if (s.length() == 0) {
                max=-1;
            }
            if (s.length() == 1) {
               max=0;
            }
            boolean[][] dp = new boolean[s.length()][s.length()];
            //init
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < s.length(); j++) {
                    if (i == j) {
                        dp[i][j] = true;
                    }
                }
            }
            int maxi = -1, maxj = -1;
            for (int j = 1; j < s.length(); j++) {
                for (int i = 0; i < j; i++) {
                    if (s.charAt(i) != s.charAt(j)) {
                        dp[i][j] = false;
                    } else {
                        if (dp[i + 1][j - 1] == true || i + 1 >= j - 1) {
                            dp[i][j] = true;
                            if (j - i > max) {
                                max = j - i;
                                maxi = i;
                                maxj = j;
                            }
                        }
                    }
                }
            }

           // Print.print(dp);
            System.out.println(max+1);
            //System.out.println(maxi + "," + maxj);

            // System.out.println(findMax(scan.nextLine()) + 1);
        }
    }

}
