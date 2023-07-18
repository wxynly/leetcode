package com.wx.leetcode.hot;

public class H79 {
    boolean flag;

    public boolean exist(char[][] board, String word) {
        boolean[][] use = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (flag) {
                    return true;
                }
                if (board[i][j] == word.charAt(0)) {
                    use[i][j] = true;
                    dfs(board, word, i, j, 1, use);
                    use[i][j] = false;
                }
            }
        }
        return flag;
    }

    public void dfs(char[][] board, String word, int i, int j, int index, boolean[][] use) {
        if (index == word.length()) {
            flag = true;
            return;
        }
        //上下左右四个方向寻找，需要未被访问过，且当前位置的字符相等
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] direction : directions) {
            i = i + direction[0];
            j = j + direction[1];
            if (i >= 0 & i < board.length && j >= 0 && j < board[0].length && !use[i][j] && board[i][j] == word.charAt(index)) {
                use[i][j] = true;
                dfs(board, word, i, j, index + 1, use);
                use[i][j] = false;
            }
        }
        //上下左右四个方向寻找，需要未被访问过，且当前位置的字符相等
        if (i > 0 && !use[i - 1][j] && board[i - 1][j] == word.charAt(index)) {
            use[i - 1][j] = true;
            dfs(board, word, i - 1, j, index + 1, use);
            use[i - 1][j] = false;
        }
        if (j < board[0].length - 1 && !use[i][j + 1] && board[i][j + 1] == word.charAt(index)) {
            use[i][j + 1] = true;
            dfs(board, word, i, j + 1, index + 1, use);
            use[i][j + 1] = false;
        }
        if (i < board.length - 1 && !use[i + 1][j] && board[i + 1][j] == word.charAt(index)) {
            use[i + 1][j] = true;
            dfs(board, word, i + 1, j, index + 1, use);
            use[i + 1][j] = false;
        }
        if (j > 0 && !use[i][j - 1] && board[i][j - 1] == word.charAt(index)) {
            use[i][j - 1] = true;
            dfs(board, word, i, j - 1, index + 1, use);
            use[i][j - 1] = false;
        }
    }


}
