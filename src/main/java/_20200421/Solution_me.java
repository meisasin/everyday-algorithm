package _20200421;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 今天厉害了，自己写的居然和官网的差不离，哈哈
 * 而且时间、占用内存都不错
 */
class Solution_me {
    /**
     *
     * 假如参数是 [2, 2, 1, 2, 6, 2, 1, 8, 1, 4]   k = 3
     *      idx  [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
     *      即值为 1 的全是奇数，一共3个，即角标 2、6、8
     *      这样可以将该数组分成2组，以角标为区间(0 - 7) | （3 - 9）
     *
     */
    public int numberOfSubarrays(int[] nums, int k) {

        // 奇数数组角标集合
        List<Integer> oddIdxList = new ArrayList<>();
        for (int i = 0 ; i < nums.length ; i ++) {
            if (nums[i] % 2 == 1) {
                oddIdxList.add(i);
            }
        }
        // 如果奇数的长度小于 k 直接返回
        if (nums.length < k) return 0;

        int count = 0;

        // k 个才能构成一个「优美子数组」的数目，所以从第 k - 1 角标开始循环
        for (int i = k - 1; i < oddIdxList.size(); i ++) {
            // 当前组中第一个奇数的位置 -> 当前奇数的位置 - k + 1
            int beginOddIdx = oddIdxList.get(i - k + 1);
            // 当前组中最后一个奇数的位置
            int endOddIdx = oddIdxList.get(i);

            // 当前组中最开始时的索引 -> 如果第一次循环 beginIdx = 0， 否则取当前组中第一个奇数的上一个奇数的后一位置索引
            int beginIdx = i == k - 1 ? 0 : oddIdxList.get(i - k) + 1;
            // 当前组中结束时的索引 -> 如果是最后一个奇数，那么结束索引 应该是 nums 的最后一个索引，否则应取，当前组最后一个奇数的下一个奇数在 nums 里的前一个索引
            int endIdx = i == (oddIdxList.size() - 1) ? nums.length - 1 : oddIdxList.get(i + 1) - 1;
            // 计算当前组区间可以构成的「优美子数组」的数目：使用公式  (beginOddIdx - beginIdx + 1) * (endIdx - endOddIdx + 1);
            count += (beginOddIdx - beginIdx + 1) * (endIdx - endOddIdx + 1);
        }

        return count;
    }
}