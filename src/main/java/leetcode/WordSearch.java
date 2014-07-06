package leetcode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Jacob on 2014/5/6.
 */
public class WordSearch {

    public static void main(String[] args) {
        WordSearch solution = new WordSearch();
        char[][] board = new char[30][30];
        board[0] = "ab".toCharArray();
        board[1] = "cd".toCharArray();
        String[] sss = {"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaab"};

        //board[2] = "ADEE".toCharArray();
        for (int i = 0; i < sss.length; i++) {
            board[i] = sss[i].toCharArray();
        }
        System.out.println(solution.exist1(board, "baaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }

    class Position {
        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int x;
        int y;
    }

    /**
     * Given a 2D board and a word, find if the word exists in the grid.
     * <p/>
     * The word can be constructed from letters of sequentially adjacent cell,
     * where "adjacent" cells are those horizontally or vertically neighboring.
     * The same letter cell may not be used more than once.
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

    }


    public boolean exist1(char[][] board, String word) {

        if (board == null || board.length == 0) {
            return false;
        }
        if (word == null || word.length() == 0) {
            return true;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                     if (visit(board, visited, i, j, word, 0)) {
                        return true;
                    }
                 }
            }
        }
        return false;
    }


    private boolean visit(char[][] board, boolean[][] visited, int i, int j, String word, int index) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || word.charAt(index) != board[i][j]) {
            return false;
        }
        if (word.length() == index + 1) {
            return true;
        }
        visited[i][j] = true;
        boolean result = visit(board, visited, i + 1, j, word, index + 1) || visit(board, visited, i - 1, j, word, index + 1) || visit(board, visited, i, j + 1, word, index + 1) || visit(board, visited, i, j - 1, word, index + 1);
        visited[i][j] = false;
        return result;

    }

}
