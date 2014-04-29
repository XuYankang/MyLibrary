package print;

/**
 * Created by Administrator on 2014/4/21.
 */
public class Print {

    public static void print(int[][] x) {
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                System.out.print(x[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void print(boolean[][] x) {
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                System.out.print(x[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static String get(boolean[][] x) {
        String s = "";
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                s += x[i][j] + "\t";
            }
            s += "\n";
        }
        return s;
    }
}
