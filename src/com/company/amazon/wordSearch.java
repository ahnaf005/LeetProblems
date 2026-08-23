package com.company.amazon;

public class wordSearch {
    String word;
    char[][] board;
    int ROWS;
    int COLS;
    int wordLen;
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;
        visited = new boolean[ROWS][COLS];
        this.board = board;
        this.word = word;
        wordLen = word.length();
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    int[][] dirs = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };

    private boolean dfs(int i, int j, int wordIndex) {
        if (wordIndex == wordLen) {
            return true;
        }
        if (!isBound(i, j, wordIndex) || board[i][j] != word.charAt(wordIndex) || visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        boolean res = false;
        for (int[] dir : dirs) {
            res = res || dfs(i + dir[0], j + dir[1], wordIndex + 1);
        }
        visited[i][j] = false;
        return res;
    }

    private boolean isBound(int i, int j, int wordIndex) {
        return i >= 0 && i < ROWS && j >= 0 && j < COLS && wordIndex < wordLen;
    }
}
