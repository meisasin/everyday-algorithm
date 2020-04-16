package _20200416;

import org.junit.Test;

public class SolutionTest {
    
    @Test
    public void testMerge() {

        System.out.println("First .");
        // First 初始化测试数据
        int[][] firstArr = { {1, 3}, {2, 6}, {8, 10}, {15, 18} };
        int[][] firstMerge = new Solution().merge(firstArr);
        printArr(firstMerge);

        System.out.println("Senond .");
        // 初始化测试数据
        int[][] secondArr = { {1, 4}, {4, 5} };
        int[][] secondMerge = new Solution().merge(secondArr);
        printArr(secondMerge);

        System.out.println("Third .");
        // 初始化测试数据
        int[][] thirdArr = { {1, 4}, {2, 3} };
        int[][] thirdMerge = new Solution().merge(thirdArr);
        printArr(thirdMerge);

        System.out.println("Four .");
        // 初始化测试数据
        int[][] fourArr = { {1, 4}, {5, 6} };
        int[][] fourMerge = new Solution().merge(fourArr);
        printArr(fourMerge);

    }

    private void printArr(int[][] arr) {
        for (int i = 0 ; i < arr.length ; i ++) {
            for (int j = 0 ; j < arr[0].length ; j ++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
