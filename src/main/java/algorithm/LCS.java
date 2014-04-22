package algorithm;

import other.Matrix;
import print.Print;

/**
 * Created by Jacob on 2014/4/21.
 * LCS算法，计算字符串的相似度。使用动态规划
 */
public class LCS {

    public static int calculateTimes = 0;

    public static void main(String[] args) {
        String b = "仅售238元，市场价418元的瑞康体检基础A套组，不限男女，具体项目详见体检项目列表！请带上本人身份证前往！体检时间8:00-10:00！关爱中老年人！送父母、长辈、好友、自己的首选！瑞康体检，方便、快捷、优惠、优质！";
        String a = "仅售510元，市场价908元的瑞康女性专用体检套组，仅限女士使用，具体项目详见体检项目列表！请带上本人身份证前往！体检时间8:00-10:00！关爱中老年人！送父母、长辈、好友、自己的首选！瑞康体检，方便、快捷、优惠、优质！";
        System.out.println(similarity(a, b));
    }

    public static int levenshteinDistance(String s, String t) {
        int[][] matrix = new int[s.length() + 1][t.length() + 1];
        initMatrix(matrix);
        levenshteinDistance(matrix, s, s.length(), t, t.length());
        Print.print(matrix);

        return matrix[s.length()][t.length()];
    }

    private static void levenshteinDistance(int[][] matrix, String s, int slength, String t, int tlength) {
        for (int i = 1; i < slength + 1; i++) {
            for (int j = 1; j < tlength + 1; j++) {
                calculateTimes++;
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    matrix[i][j] = matrix[i - 1][j - 1];
                } else {
                    matrix[i][j] = Math.min(Math.min(matrix[i - 1][j], matrix[i][j - 1]), matrix[i - 1][j - 1]) + 1;
                }
            }
        }
    }

    private static void initMatrix(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = 0;
            }
        }
        //行
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][0] = i;
        }
        //列
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[0][j] = j;
        }

    }


    public static int levenshteinDistance(String s, int sLength, String t, int tLength) {
        calculateTimes++;
        if (sLength == 0) return tLength;
        if (tLength == 0) return sLength;
        int cost = 1;
        if (s.charAt(sLength - 1) == t.charAt(tLength - 1)) {
            cost = 0;
        }
        return Math.min(
                Math.min(levenshteinDistance(s, sLength - 1, t, tLength) + 1,
                        levenshteinDistance(s, sLength, t, tLength - 1) + 1),
                levenshteinDistance(s, sLength - 1, t, tLength - 1) + cost
        );
    }

    private static double similarity(String a, String b) {
        if (a == null || a.isEmpty() || b == null || b.isEmpty())
            return 0;
        int common = lcs(a, b);
        return common * 2.0 / (a.length() + b.length());
    }

    public static int lcs(String a, String b) {
        int lenA = a.length(), lenB = b.length();
        int[] x = new int[lenB + 1];
        int[] y = new int[lenB + 1];
        int[] w = new int[lenA];
        for (int i = 0; i <= lenA; i++) {
            for (int j = 0; j <= lenB; j++) {
                if (i == 0 || j == 0)
                    x[j] = 0;
                else if (a.charAt(i - 1) == b.charAt(j - 1))
                    x[j] = y[j - 1] + 1;
                else
                    x[j] = Math.max(y[j], x[j - 1]);
            }
            if (i > 0)
                w[i - 1] = x[lenB];
            for (int j = 0; j <= lenB; j++)
                y[j] = x[j];
        }
        return w[lenA - 1];
    }
}
