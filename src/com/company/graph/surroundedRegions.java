package com.company.graph;

import java.util.ArrayList;
import java.util.List;

public class surroundedRegions {
    private List<List<Integer>> visitedIndices;
    private boolean isOnEdge = false;

    public void dfs(char[][] grid, int r, int c) {
        int rows = grid.length;
        int cols = grid[0].length;
        if(r < 0 || r >= rows || c < 0 || c >= cols) {
            isOnEdge = true;
            return;
        }
        if(grid[r][c] != 'O') {
            return;
        }
        List<Integer>index = List.of(r, c);
        visitedIndices.add(index);
        grid[r][c] = '1';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }
    public void solve(char[][] board) {
        visitedIndices = new ArrayList<>();
        int rows = board.length;
        int cols = board[0].length;
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(board[r][c] == 'O') {
                    dfs(board, r, c);
                    if (!isOnEdge) {
                        for(int i=0;i<visitedIndices.size();i++) {
                            List<Integer>index = visitedIndices.get(i);
                            board[index.get(0)][index.get(1)] = 'X';
                        }
                    }
                    isOnEdge = false;
                    visitedIndices.clear();
                }
            }
        }
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(board[r][c] == '1') {
                    board[r][c] = 'O';
                }
            }
        }
    }
}
