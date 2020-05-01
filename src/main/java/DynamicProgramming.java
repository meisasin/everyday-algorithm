import java.util.HashMap;
import java.util.Map;

/**
 * 动态规划
 * @date 2020/4/29 Í 2:00 下午
 */
public class DynamicProgramming {

    /**
     * 计算数组不相邻值相加起来的最大值
     * 要求：所选数字不能相隔
     *
     * 例：[1, 2, 3, 4, 5] 如果选择 2，那么 1 和3 不能再选择
     *
     * 注意： 3 <= arr.length <= 10000
     * @param arr
     * @return
     */
    public static int findNonadjacentMax(int[] arr) {

        int[] temp = new int[arr.length];
        temp[0] = arr[0];
        temp[1] = arr[1];

        for (int i = 2 ; i < arr.length ; i ++) {
            temp[i] = Math.max(arr[i] + temp[i - 2], temp[i - 1]);
        }
        return temp[temp.length - 1];
    }

    /**
     *
     * 计算数组 arr 中是否有两个值相累加等于 n
     *
     * 例：arr = [3, 34, 4, 12, 5, 2], n = 9
     *     4 + 5 = 9 返回 true
     *
     * 注意：0 <= arr.length <= 10000
     *      0 <= n <= 10000
     *
     * @return
     */
    public static boolean addTwo(int[] arr, int n) {

        Map<Integer, Integer> nMap = new HashMap<>();
        for (int i = 0 ; i < arr.length ; i ++) {
            if (nMap.containsKey(n - arr[i])) {
                return true;
            }
            nMap.put(arr[i], 1);
        }
        return false;
    }


    /**
     * 计算数组 arr 中是否有多个值累加等于 n (递归算法)
     * @return
     */
    public static boolean rec_subset(int[] arr, int n, int targer) {
//        System.out.println("arr[n] is " + arr[n] + ", targer is " + targer);
        if (n == 0)
            return arr[0] == targer;
        if (arr[n] > targer)
            return rec_subset(arr, n - 1, targer);
        return targer == arr[n] ||
                rec_subset(arr, n - 1, targer - arr[n]) ||  // 选
                rec_subset(arr, n - 1, targer); // 不选
    }


    /**
     * 计算数组 arr 中是否有多个值累加等于 n (DP)
     * @return
     */
    public static boolean dp_subset(int[] arr, int targer) {

        boolean[][] subset = new boolean[arr.length][targer + 1];
        for (int i = 0 ; i < subset[0].length ; i ++) {
            if (arr[0] == i) subset[0][i] = true;
            else subset[0][i] = false;
        }
        for (int i = 0 ; i < subset.length ; i ++) {
            subset[i][0] = true;
        }

        for (int i = 1 ; i < subset.length ; i ++) {
            for (int j = 1 ; j < subset[i].length ; j ++) {
                subset[i][j] = subset[i - 1][j];
                if (j > arr[i])
                    subset[i][j] = subset[i - 1][j] || subset[i - 1][j - arr[i]];
            }
        }
        return subset[subset.length - 1][subset[0].length - 1];
    }

    /**
     * 计算数组 arr 中是否有多个值累加等于 n (DP) 优化成一维数组
     * @return
     */
    public static boolean dp_subset_(int[] arr, int targer) {

        boolean[] subset = new boolean[targer + 1];
        for (int i = 0 ; i < subset.length ; i ++) {
            if (arr[0] == i) subset[i] = true;
            else subset[i] = false;
        }

        for (int i = 1 ; i < subset.length ; i ++) {
            for (int j = subset.length - 1 ; j < arr[i] ; j --) {
                    subset[j] = subset[j] || subset[j - arr[i]];
            }
        }
        return subset[subset.length - 1];
    }

    public static void main(String[] args) {

        int nonadjacentMax = DynamicProgramming.findNonadjacentMax(new int[]{1, 2, 4, 1, 7, 8, 3});
        System.out.println(nonadjacentMax);

        boolean hasSubset = DynamicProgramming.addTwo(new int[] { 3, 34, 4, 12, 5, 2 }, 9);
        System.out.println(hasSubset);

        System.out.println("-----------");
        // rec
        boolean subset = DynamicProgramming.rec_subset(new int[]{3, 34, 4, 12, 5, 2}, 5, 9);
        System.out.println(subset);
        subset = DynamicProgramming.rec_subset(new int[]{3, 34, 4, 12, 5, 2}, 5, 10);
        System.out.println(subset);
        subset = DynamicProgramming.rec_subset(new int[]{3, 34, 4, 12, 5, 2}, 5, 11);
        System.out.println(subset);
        subset = DynamicProgramming.rec_subset(new int[]{3, 34, 4, 12, 5, 2}, 5, 12);
        System.out.println(subset);
        subset = DynamicProgramming.rec_subset(new int[]{3, 34, 4, 12, 5, 2}, 5, 13);
        System.out.println(subset);

        System.out.println("-----------");
        // dp
        subset = DynamicProgramming.dp_subset(new int[]{3, 34, 4, 12, 5, 2},  9);
        System.out.println(subset);
        subset = DynamicProgramming.dp_subset(new int[]{3, 34, 4, 12, 5, 2},  10);
        System.out.println(subset);
        subset = DynamicProgramming.dp_subset(new int[]{3, 34, 4, 12, 5, 2}, 11);
        System.out.println(subset);
        subset = DynamicProgramming.dp_subset(new int[]{3, 34, 4, 12, 5, 2}, 12);
        System.out.println(subset);
        subset = DynamicProgramming.dp_subset(new int[]{3, 34, 4, 12, 5, 2}, 13);
        System.out.println(subset);

        System.out.println("-----------");
        // dp 优化
        subset = DynamicProgramming.dp_subset_(new int[]{3, 34, 4, 12, 5, 2},  9);
        System.out.println(subset);
        subset = DynamicProgramming.dp_subset_(new int[]{3, 34, 4, 12, 5, 2},  10);
        System.out.println(subset);
        subset = DynamicProgramming.dp_subset_(new int[]{3, 34, 4, 12, 5, 2}, 11);
        System.out.println(subset);
        subset = DynamicProgramming.dp_subset_(new int[]{3, 34, 4, 12, 5, 2}, 12);
        System.out.println(subset);
        subset = DynamicProgramming.dp_subset_(new int[]{3, 34, 4, 12, 5, 2}, 13);
        System.out.println(subset);

    }
}
