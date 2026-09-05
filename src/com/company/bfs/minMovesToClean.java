package com.company.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

record State(int x, int y, int energy, int mask, int moves) {}

public class minMovesToClean {
    int ROWS;
    int COLS;

    int[][] dirs = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };

    public int minMoves(String[] classroom, int energy) {
        ROWS = classroom.length;
        COLS = classroom[0].length();

        char[][] map = new char[ROWS][COLS];

        for (int i = 0; i < ROWS; i++) {
            map[i] = classroom[i].toCharArray();
        }

        Queue<State> q = new LinkedList<>();

        // Store which bit belongs to each litter cell
        int[][] litterId = new int[ROWS][COLS];

        for (int i = 0; i < ROWS; i++) {
            Arrays.fill(litterId[i], -1);
        }

        int litterCount = 0;

        // Find S and assign consecutive bits to L
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {

                if (map[i][j] == 'S') {
                    q.add(new State(i, j, energy, 0, 0));
                }

                if (map[i][j] == 'L') {
                    litterId[i][j] = litterCount++;
                }
            }
        }

        // If there is no litter
        if (litterCount == 0) {
            return 0;
        }

        // All litter collected
        int litterMask = (1 << litterCount) - 1;

        // bestEnergy[x][y][mask] =
        // maximum energy we've had at (x,y) with this mask
        int[][][] bestEnergy =
                new int[ROWS][COLS][1 << litterCount];

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                Arrays.fill(bestEnergy[i][j], -1);
            }
        }

        while (!q.isEmpty()) {
            State cur = q.poll();

            int x = cur.x();
            int y = cur.y();
            int curEnergy = cur.energy();
            int curMask = cur.mask();
            int moves = cur.moves();

            int newEnergy = curEnergy;
            int newMask = curMask;

            // Recharge
            if (map[x][y] == 'R') {
                newEnergy = energy;
            }

            // Pick up litter
            if (map[x][y] == 'L') {
                int id = litterId[x][y];

                newMask |= (1 << id);
            }

            // We have already reached this state
            // with equal or greater energy
            if (bestEnergy[x][y][newMask] >= newEnergy) {
                continue;
            }

            bestEnergy[x][y][newMask] = newEnergy;

            // All litter collected
            if (newMask == litterMask) {
                return moves;
            }

            // No energy left
            if (newEnergy == 0) {
                continue;
            }

            // Move in 4 directions
            for (int[] dir : dirs) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (!isBounded(newX, newY)) {
                    continue;
                }

                if (map[newX][newY] == 'X') {
                    continue;
                }

                int nextEnergy = newEnergy - 1;

                if (bestEnergy[newX][newY][newMask] < nextEnergy) {
                    q.add(new State(
                            newX,
                            newY,
                            nextEnergy,
                            newMask,
                            moves + 1
                    ));
                }
            }
        }

        return -1;
    }

    private boolean isBounded(int x, int y) {
        return x >= 0 &&
                y >= 0 &&
                x < ROWS &&
                y < COLS;
    }
}