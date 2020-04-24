package _20200424;

import java.util.HashMap;
import java.util.Map;

/**
 * 这两天的题直接给我整自闭了
 *      😭
 */
class Solution_me {
    /**
     * 输入: [7,5,6,4]  -> [3, 1 , 1, 0]      [5, 6, 7, 4] -> [1, 1, 1, 0]
     * 输出: 5
     */
    public int reversePairs(int[] nums) {

        // 最新计算该数值的最小索引
        Map<Integer, Integer> idxMap = new HashMap<>();
        // 最新计算该数值最小索引的逆序对
        Map<Integer, Integer> countMap = new HashMap<>();

        int count = 0;
        for (int i = nums.length - 2; i >= 0 ; i --) {

            int currCount = 0;
            int begin = i + 1;
            int end = nums.length - 1;

            // 如果当前数值已经出现过，取其索引
            Integer idx = idxMap.get(nums[i]);
            if (idx != null) {
                end = idx - 1;
                currCount = countMap.get(nums[i]);
            }

            for ( ; begin <= end ; begin ++) {
                if (nums[i] > nums[begin]) currCount ++;
            }

            // 将该数值索引放入 Map
            idxMap.put(nums[i], i);
            countMap.put(nums[i], currCount);
            count += currCount;
        }

        return count;
    }
}
