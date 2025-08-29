package com.company.matrix;

import java.util.ArrayList;
import java.util.List;

public class spiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        List<Integer> list = new ArrayList<>();
        while(list.size() < (matrix.length * matrix[0].length)) {
            for(int i = left; i <= right; i++){
                list.add(matrix[top][i]);
            }
            for(int i = top + 1; i <= bottom; i++){
                list.add(matrix[i][right]);
            }
            if(top != bottom) {
                for (int i = right - 1; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
            }
            if(left != right) {
                for (int i = bottom - 1; i > top; i--) {
                    list.add(matrix[i][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return list;
    }
}
