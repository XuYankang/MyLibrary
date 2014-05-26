package leetcode;

/**
 * Created by Jacob on 2014/5/6.
 */
public class WordSearch {

    public static void main(String[] args) {
        WordSearch solution = new WordSearch();
        System.out.println(solution.exist(
                new char[][]{"BA".toCharArray()}, "AB"));
    }

    /**
     * Given a 2D board and a word, find if the word exists in the grid.
     * <p/>
     * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
     * <p/>
     * For example,
     * Given board =
     * <p/>
     * [
     * ["ABCE"],
     * ["SFCS"],
     * ["ADEE"]
     * ]
     * word = "ABCCED", -> returns true,
     * word = "SEE", -> returns true,
     * word = "ABCB", -> returns false.
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board == null || word == null || word.length() == 0) {
            return false;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, 0, visited, i, j)) {
                    return true;
                }
            }
        }
        return false;

    }

    private boolean dfs(char[][] board, String word, int index, boolean[][] visited, int i, int j) {
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 ||
                visited[i][j] == true || word.charAt(index) != board[i][j]) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        boolean result = dfs(board, word, index + 1, visited, i + 1, j) ||
                dfs(board, word, index + 1, visited, i - 1, j) ||
                dfs(board, word, index + 1, visited, i, j + 1) ||
                dfs(board, word, index + 1, visited, i, j - 1);
        visited[i][j] = false;
        return result;
    }


    private void swap(int[] a, int pre, int i) {
        int temp = a[pre];
        a[pre] = a[i];
        a[i] = temp;
    }
}
