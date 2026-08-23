package com.company.amazon;

import java.util.Arrays;

public class floodColor {
    boolean [][] visited;
    int ROWS;
    int COLS;
    int color;
    int startingColor;
    int [][] image;
    int [][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        this.image = image;
        this.color = color;
        this.visited = new boolean[image.length][image[0].length];
        visited[sr][sc] = true;
        this.startingColor = image[sr][sc];
        this.ROWS = image.length;
        this.COLS = image[0].length;
        dfs(sr, sc);
        return image;
    }

    private boolean isBound(int i, int j) {
        return i >= 0 && i < ROWS && j >= 0 && j < COLS;
    }
    public void dfs(int i, int j) {
        visited[i][j] = true;
        if(image[i][j] == startingColor){
            image[i][j] = color;
        }else{
            return;
        }
        for(int[] dir : dir) {
            int x = i + dir[0];
            int y = j + dir[1];
            if(isBound(x,y) && !visited[x][y]) {
                dfs(x, y);
            }
        }
    }
}
