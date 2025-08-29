package com.company.matrix;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class validSudoku {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < board.length; i++){
            if(!checkRow(board, i)){
                return false;
            }
        }
        for(int i = 0; i < board.length; i++){
            if(!checkCol(board, i)){
                return false;
            }
        }
        for(int i = 0; i < board.length; i++){
            int row = (3 * i) % board.length;
            int col = (i /3) * 3;
            if(!checkBox(board, row , col)){
                return false;
            }
        }
        return true;
    }

    private boolean checkRow(char[][] board, int row) {
        Set<Character> map = new HashSet<>();
        for (int col = 0; col < 9; col++) {
            if (board[row][col] != '.') {
                if (map.contains(board[row][col])) {
                    return false;
                }
                map.add(board[row][col]);
            }
        }
        return true;
    }

    private boolean checkCol(char[][] board, int col) {
        Set<Character> map = new HashSet<>();
        for (int row = 0; row < 9; row++) {
            if (board[row][col] != '.') {
                if (map.contains(board[row][col])) {
                    return false;
                }
                map.add(board[row][col]);
            }
        }
        return true;
    }

    private boolean checkBox(char[][] board, int row, int col) {
        Set<Character> map = new HashSet<>();
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[row+i][col+j] != '.'){
                    if(map.contains(board[row+i][col+j])){
                        return false;
                    }
                    map.add(board[row+i][col+j]);
                }
            }
        }
        return true;
    }
}
