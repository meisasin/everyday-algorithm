package _20200415;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    /**
     * 采用广度优先算法
     * @param matrix
     * @return
     */
    public int[][] updateMatrix(int[][] matrix) {

        Queue<int[]> queue = new LinkedList<int[]>();
        int m = matrix.length;
        int n = matrix[0].length;

        // 如果值为 0 放入列表，等循环，如果值不是 0 ，改为 -1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    matrix[i][j] = -1;
                }
            }
        }

        int[] xPoint = new int[]{ -1, 0, 1, 0 };
        int[] yPoint = new int[]{ 0, -1, 0, 1 };
        while (!queue.isEmpty()) {

            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + xPoint[i];
                int ny = y + yPoint[i];
                if (nx >= 0 && ny >= 0 && nx < m && ny < n && matrix[nx][ny] == -1) {
                    matrix[nx][ny] = matrix[x][y] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        return matrix;
    }
}