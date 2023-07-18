package com.wx.leetcode.hot;

import java.util.Deque;
import java.util.LinkedList;

public class H200 {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, col - 1, row - 1, j, i);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int col, int row, int c, int r) {
        if (c < 0 || c > col || r < 0 || r > row || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        dfs(grid, col, row, c - 1, r);
        dfs(grid, col, row, c + 1, r);
        dfs(grid, col, row, c, r - 1);
        dfs(grid, col, row, c, r + 1);
    }

    public int numIslands2(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        int r, c;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    deque.add(i * col + j);
                    grid[i][j] = '0';
                    while (!deque.isEmpty()) {
                        Integer temp = deque.remove();
                        r = temp / col;
                        c = temp % col;
                        if (r - 1 >= 0 && grid[r - 1][c] == '1') {
                            deque.add((r - 1) * col + c);
                            grid[r - 1][c] = '0';
                        }
                        if (r + 1 < row && grid[r + 1][c] == '1') {
                            deque.add((r + 1) * col + c);
                            grid[r + 1][c] = '0';
                        }
                        if (c - 1 >= 0 && grid[r][c - 1] == '1') {
                            deque.add(r * col + c - 1);
                            grid[r][c - 1] = '0';
                        }
                        if (c + 1 < col && grid[r][c + 1] == '1') {
                            deque.add(r * col + c + 1);
                            grid[r][c + 1] = '0';
                        }
                    }
                }
            }
        }
        return count;
    }
}
