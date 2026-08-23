package com.company.amazon;

class TicTacToe {

    int [][] board;
    int[] playerSign= {0, 1, 2};

    int n;
    public TicTacToe(int n) {
        this.n = n;
        this.board = new int[n][n];
    }

    private boolean checkCol(int col, int player){
        for(int i=0;i<n;i++){
            if(board[i][col]!=playerSign[player]){
                return false;
            }
        }
        return true;
    }

    private boolean checkRow(int row, int player){
        for(int i=0;i<n;i++){
            if(board[row][i]!=playerSign[player]){
                return false;
            }
        }
        return true;
    }

    private boolean checkFirstDiag(int player){
        for (int i = 0; i < n; i++) {
            if(board[i][i]!=playerSign[player]){
                return false;
            }
        }
        return true;
    }
    private boolean checkSecondDiag(int player){
        for (int i = 0; i < n; i++) {
            if(board[i][n-1-i]!=playerSign[player]){
                return false;
            }
        }
        return true;
    }
    public int move(int row, int col, int player) {
        board[row][col] = playerSign[player];
        return checkCol(col,player) || checkRow(row,player) ||checkFirstDiag(player) || checkSecondDiag(player)
                ?playerSign[player]:0;
    }
}
