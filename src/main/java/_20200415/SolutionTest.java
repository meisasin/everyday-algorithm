package _20200415;

import org.junit.Test;

public class SolutionTest {
    
    @Test
    public void testUpdateMatrix() {

        // 初始化测试数据
        int[][] arr = new int[10][10];
        for (int i = 0 ; i < 10 ; i ++) {
            for (int j = 0 ; j < 10 ; j ++) {
                arr[i][j] = 1;
            }
        }

        arr[5][6] = 0;
        arr[4][7] = 0;
        arr[2][2] = 0;
        Solution solution = new Solution();
        int[][] result = solution.updateMatrix(arr);

        printArr(result);

    }

    private void printArr(int[][] arr) {
        for (int i = 0 ; i < 10 ; i ++) {
            for (int j = 0 ; j < 10 ; j ++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
