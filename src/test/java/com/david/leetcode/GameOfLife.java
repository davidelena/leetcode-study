package com.david.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 * <p>
 * Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
 * <p>
 * Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population..
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * Write a function to compute the next state (after one update) of the board given its current state. The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.
 * <p>
 * Issue 189
 */
public class GameOfLife {

    @Test
    public void testGameOfLife() {
        int[][] board = new int[][]{
                {0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        gameOfLife(board);
        for (int[] item : board) {
            System.out.println(Arrays.toString(item));
        }
    }

    /**
     * init cell board
     *
     * @param board
     */
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        int MAX_ROW = board.length;
        int MAX_COL = board[0].length;

        int[][] copyBoard = new int[MAX_ROW][MAX_COL];
        for (int i = 0; i < MAX_ROW; i++) {
            for (int j = 0; j < MAX_COL; j++) {
                copyBoard[i][j] = board[i][j];
            }
        }

        for (int row = 0; row < MAX_ROW; row++) {
            for (int col = 0; col < MAX_COL; col++) {
                switch (calculateNeighbors(copyBoard, row, col, MAX_ROW, MAX_COL)) {
                    case 0:
                    case 1:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        board[row][col] = 0;
                        break;
                    case 2:
                        board[row][col] = copyBoard[row][col];
                        break;
                    case 3:
                        if (copyBoard[row][col] == 0) {
                            board[row][col] = 1;
                        }
                        break;
                }

            }
        }
    }

    /**
     * Calculate the neighbors of current cellular(row, col)
     *
     * @param row
     * @param col
     * @param maxRow
     * @param maxCol
     * @return
     */
    public int calculateNeighbors(int[][] board, int row, int col, int maxRow, int maxCol) {
        int count = 0;
        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = col - 1; c <= col + 1; c++) {
                if (r < 0 || r >= maxRow || c < 0 || c >= maxCol) {
                    continue;
                }
                if (board[r][c] == 1) {
                    count++;
                }
            }
        }
        // We calculate the count of duplicates when the current cellular is alive
        if (board[row][col] == 1) {
            count--;
        }
        return count;
    }
}
