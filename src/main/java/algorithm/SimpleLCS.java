package algorithm;

/**
 * Created by jacob on 14-8-22.
 */
public class SimpleLCS {

    public static void main(String[] args) {
        new SimpleLCS().compare("1102", "0200");
    }


    public int compare(String a, String b) {
        int[][] score = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i <= a.length(); i++) {
            score[0][i] = i;
        }
        for (int j = 0; j <= b.length(); j++) {
            score[j][0] = j;
        }
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                int p = min(score[i - 1][j], score[i - 1][j - 1], score[i][j - 1]);
                score[i][j] = (a.charAt(i - 1) != b.charAt(j - 1) ? p + 1 : p);
            }
        }
        for (int i = 0; i <= a.length(); i++) {
            for (int j = 0; j <= b.length(); j++) {
                System.out.print(score[i][j] + " ");
            }
            System.out.println();
        }
        return score[a.length()][b.length()];
    }

    private int min(int x, int y, int z) {
        return Math.min(Math.min(x, y), z);
    }

}
