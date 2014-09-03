package interview;

import java.util.Scanner;

/**
 * Created by jacob on 14-9-3.
 * <p/>
 * 5 5
 * SOLO
 * CPUCY
 * EKLQH
 * CRSOL
 * EKLQO
 * PGRBC
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            scanner.nextLine();
            String word = scanner.nextLine();
            char[][] matrix = new char[n][m];
            for (int i = 0; i < n; i++) {
                matrix[i] = scanner.nextLine().toCharArray();
            }
            boolean result = false;

            for (int i = 0; i < n && !result; i++) {
                for (int j = 0; j < m && !result; j++) {
                    boolean[][] visited = new boolean[n][m];
                    result = visit(word, matrix, visited, i, j);

                }
            }
            System.out.println(result ? "YES" : "NO");
        }


    }

    private static boolean visit(String word, char[][] matrix, boolean[][] visited, int i, int j) {
        if (word.length() == 0) {
            return true;
        }
        if (i >= matrix.length || i < 0 || j >= matrix[0].length || j < 0) {
            return false;
        }
        if (matrix[i][j] == word.charAt(0) && !visited[i][j]) {
            visited[i][j] = true;
            return visit(word.substring(1), matrix, visited, i + 1, j) ||
                    visit(word.substring(1), matrix, visited, i - 1, j) ||
                    visit(word.substring(1), matrix, visited, i, j + 1) ||
                    visit(word.substring(1), matrix, visited, i, j - 1);
        } else {
            return false;
        }
    }
}
