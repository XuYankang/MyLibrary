package leetcode;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by Administrator on 2014/7/25.
 */
public class SudokuSolver {


    public static void main(String[] args) {
        SudokuSolver solution = new SudokuSolver();
        String[] lines = {"53..7....",
                "6..195...",
                ".98....6.",
                "8...6...3",
                "4..8.3..1",
                "7...2...6",
                ".6....28.",
                "...419..5",
                "....8..79"};
        char[][] board = new char[9][9];
        for (int i = 0; i < lines.length; i++) {
            board[i] = lines[i].toCharArray();
        }
        solution.solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Write a program to solve a Sudoku puzzle by filling the empty cells.
     * <p/>
     * Empty cells are indicated by the character '.'.
     * <p/>
     * You may assume that there will be only one unique solution.
     *
     * @param board
     */
    public void solveSudoku(char[][] board) {

        int startI = 0, startJ = 0;
        boolean end = false;
        for (int i = 0; i < 9 && !end; i++) {
            for (int j = 0; j < 9 && !end; j++) {
                if (board[i][j] == '.') {
                    startI = i;
                    startJ = j;
                    end = true;
                }
            }
        }
        fill(board, startI, startJ);
    }

    private boolean fill(char[][] board, int i, int j) {


        ArrayList<Character> available = findAvailable(board, i, j);
        int[] nextPosition = nextPossible(board, i, j);
        for (char c : available) {
            board[i][j] = c;
            if (nextPosition[0] == -1) {
                return true;
            }
            if (fill(board, nextPosition[0], nextPosition[1])) {
                return true;
            }
        }
        board[i][j] = '.';
        return false;
    }

    private int[] nextPossible(char[][] board, int i, int j) {

        int[] result = new int[2];
        for (int ii = 0; ii < 9; ii++) {
            for (int jj = 0; jj < 9; jj++) {
                if (board[ii][jj] == '.' && !(ii == i && jj == j)) {
                    result[0] = ii;
                    result[1] = jj;
                    return result;
                }
            }
        }

        return new int[]{-1, -1};

    }

    private ArrayList<Character> findAvailable(char[][] board, int i, int j) {

        ArrayList<Character> available = new ArrayList<Character>();
        HashSet<Character> exist = exist(board, i, j);
        for (char c = '1'; c <= '9'; c++) {
            if (!exist.contains(c)) {
                available.add(c);
            }
        }
        return available;

    }

    private HashSet<Character> exist(char[][] board, int i, int j) {
        //row exist
        HashSet<Character> exist = new HashSet<Character>();
        for (int t = 0; t < 9; t++) {
            if (board[i][t] != '.') {
                exist.add(board[i][t]);
            }
        }
        //column exist
        for (int t = 0; t < 9; t++) {
            if (board[t][j] != '.') {
                exist.add(board[t][j]);
            }
        }
        //region exist
        int ri = 0, rj = 0;
        for (int t = 6; t >= 0; t -= 3) {
            if (i >= t) {
                ri = t;
                break;
            }
        }
        for (int t = 6; t >= 0; t -= 3) {
            if (j >= t) {
                rj = t;
                break;
            }
        }

        for (int ii = ri; ii < ri + 3; ii++) {
            for (int jj = rj; jj < rj + 3; jj++) {
                if (board[ii][jj] != '.') {
                    exist.add(board[ii][jj]);
                }
            }
        }
        return exist;
    }
}
