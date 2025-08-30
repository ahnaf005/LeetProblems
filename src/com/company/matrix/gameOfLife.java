package com.company.matrix;

public class gameOfLife {
//    1-> 0 - -1
//    0-> 1 - 2
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = 0;
                if(i>0 && (board[i-1][j] == 1 || board[i-1][j] == -1)) liveNeighbors++;
                if(j>0 && (board[i][j-1] == 1 || board[i][j-1] == -1)) liveNeighbors++;
                if(i<m-1 && (board[i+1][j] == 1 || board[i+1][j] == -1)) liveNeighbors++;
                if(j<n-1 && (board[i][j+1] == 1 || board[i][j+1] == -1)) liveNeighbors++;
                if((i>0 && j>0) && (board[i-1][j-1] == 1 || board[i-1][j-1] == -1)) liveNeighbors++;
                if((i<m-1 && j<n-1) && (board[i+1][j+1] == 1 || board[i+1][j+1] == -1)) liveNeighbors++;
                if((i<m-1 && j>0) && (board[i+1][j-1] == 1 || board[i+1][j-1] == -1)) liveNeighbors++;
                if((i>0 && j<n-1) && (board[i-1][j+1] == 1 || board[i-1][j+1] == -1)) liveNeighbors++;
                if (board[i][j] == 1) {  //currently alive
                    if(liveNeighbors<2 || liveNeighbors>3) board[i][j] = -1;
                } else{         //currently dead
                    if(liveNeighbors == 3) board[i][j] = 2;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] <=0 )
                    board[i][j] = 0;
                else
                    board[i][j] = 1;
            }
        }
    }
}
