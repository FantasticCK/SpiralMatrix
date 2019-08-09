package com.CK;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here
    }
}

class Solution {

    List<Integer> res = new ArrayList<>();

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return res;
        int r = matrix.length, c = matrix[0].length;
        boolean[][] visited = new boolean[r][c];
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int d = 0, ir = 0, ic = 0;
        res.add(matrix[ir][ic]);
        visited[ir][ic] = true;
        while (true) {
            ir += dir[d][0];
            ic += dir[d][1];
            if (isValid(matrix, ir, ic, visited)) {
                res.add(matrix[ir][ic]);
                visited[ir][ic] = true;
            } else {
                ir -= dir[d][0];
                ic -= dir[d][1];
                d = d == 3 ? 0 : d + 1;
                ir += dir[d][0];
                ic += dir[d][1];
                if (isValid(matrix, ir, ic, visited)) {
                    res.add(matrix[ir][ic]);
                    visited[ir][ic] = true;
                } else break;
            }
        }

        return res;
    }

    private boolean isValid(int[][] matrix, int r, int c, boolean[][] visited) {
        if (r < 0 || c < 0 || r >= matrix.length || c >= matrix[0].length || visited[r][c]) {
            return false;
        }
        return true;
    }
}