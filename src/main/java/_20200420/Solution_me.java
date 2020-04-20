package _20200420;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 哈哈，今天完美做出来了，不过打败的人有点少啊，
 * 效率还是太低了
 */
class Solution_me {

    public int numIslands(char[][] grid) {

        // 上 左 下 右分别对应 x、y走动坐标
        int[] xPoint = { -1, 0, 0, 1 };
        int[] yPoint = { 0, -1, 1, 0 };

        Queue<Point> queue = new LinkedList<>();
        // 记岛屿的数量
        int count = 0;
        for (int i = 0 ; i < grid.length ; i ++) {
            for (int j = 0 ; j < grid[0].length ; j ++)  {
                if (grid[i][j] == '0') {
                    continue;
                }

                // 岛屿数量加1
                count ++;
                // 相连接的岛屿全部设置成 0
                queue.offer(new Point(i, j));
                grid[i][j] = '0';  // 设置为非岛屿

                while (!queue.isEmpty()) {
                    System.out.println("Queue size is " + queue.size());
                    Point point = queue.poll();

                    for (int p = 0 ; p < 4 ; p ++) {
                        if (point.x + xPoint[p] >= 0
                                && point.y + yPoint[p] >= 0
                                && point.x + xPoint[p] < grid.length
                                && point.y + yPoint[p] < grid[0].length
                                && grid[point.x + xPoint[p]][point.y + yPoint[p]] != '0') {
                            // 设置为非岛屿，再放入队列
                            grid[point.x + xPoint[p]][point.y + yPoint[p]] = '0';
                            queue.offer(new Point(point.x + xPoint[p], point.y + yPoint[p]));
                        }
                    }

                }
            }
        }
        return count;
    }

}

class Point {
    int x, y;
    Point(int x, int y) { this.x = x; this.y = y; }
}