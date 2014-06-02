package leetcode;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Stack;

=======
>>>>>>> 7825f4d78cae10101d0dcbca57990544a144f7d7
/**
 * Created by Jacob on 2014/5/6.
 */
public class WordSearch {

    public static void main(String[] args) {
        WordSearch solution = new WordSearch();
<<<<<<< HEAD
        char[][] board = new char[3][4];
        board[0] = "ABCD".toCharArray();
        board[1] = "SFCS".toCharArray();
        board[2] = "ADEE".toCharArray();

        System.out.println(solution.exist(board, "ABCCED"));
    }

    class Position {
        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int x;
        int y;
=======
        System.out.println(solution.exist(
                new char[][]{"BA".toCharArray()}, "AB"));
>>>>>>> 7825f4d78cae10101d0dcbca57990544a144f7d7
    }

    /**
     * Given a 2D board and a word, find if the word exists in the grid.
     * <p/>
<<<<<<< HEAD
     * The word can be constructed from letters of sequentially adjacent cell,
     * where "adjacent" cells are those horizontally or vertically neighboring.
     * The same letter cell may not be used more than once.
=======
     * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
>>>>>>> 7825f4d78cae10101d0dcbca57990544a144f7d7
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
<<<<<<< HEAD

        if (board.length == 0) {
            return false;
        }
        if (word.length() == 0) {
            return true;
        }
        int xSize = board.length;
        int ySize = board[0].length;
        Stack<Position> stack = new Stack<Position>();
        for (int i = 0; i < xSize; i++) {
            for (int j = 0; j < ySize; j++) {
                if (board[i][j] == word.charAt(0)) {
                    stack.push(new Position(i, j));
                }
            }
        }
        int wordIndex = 1;
        while (!stack.isEmpty() && wordIndex < word.length()) {
            Position pp = stack.pop();
            ArrayList<Position> neighbor = inNeighboring(board, pp, word.charAt(wordIndex), xSize, ySize);
            if (neighbor.size() == 0) {
                wordIndex--;
            } else {
                for (Position p : neighbor) {
                    stack.push(p);
                }
                wordIndex++;
            }
        }

        return stack.isEmpty() ? false : true;
    }


    public ArrayList<Position> inNeighboring(char[][] board, Position p, char x, int xSize, int ySize) {
        ArrayList<Position> neighbor = new ArrayList<Position>();
        if (p.x + 1 < xSize && board[p.x + 1][p.y] == x) {
            neighbor.add(new Position(p.x + 1, p.y));
        }
        if (p.x - 1 >= 0 && board[p.x - 1][p.y] == x) {
            neighbor.add(new Position(p.x - 1, p.y));
        }
        if (p.y + 1 < ySize && board[p.x][p.y + 1] == x) {
            neighbor.add(new Position(p.x, p.y + 1));
        }
        if (p.y - 1 >= 0 && board[p.x][p.y - 1] == x) {
            neighbor.add(new Position(p.x, p.y - 1));
        }
        return neighbor;

=======
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
>>>>>>> 7825f4d78cae10101d0dcbca57990544a144f7d7
    }


    private void swap(int[] a, int pre, int i) {
        int temp = a[pre];
        a[pre] = a[i];
        a[i] = temp;
    }
}
