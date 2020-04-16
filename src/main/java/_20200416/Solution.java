package _20200416;

import java.util.Arrays;
import java.util.Comparator;

class Solution {

    public int[][] merge(int[][] intervals) {

        // 对区间的起始位置进行排序
        Arrays.sort(intervals, Comparator.comparingInt(ints -> ints[0]));

        int[][] res = new int[intervals.length][2];

        int idx = -1;

        for (int[] interval : intervals) {
            // 如果 == -1 或者 当前区间的开始大于等于上一个区间的结尾，直接放入结果
            if (idx == -1 || interval[0] >= res[idx][1]) {
                res[++idx] = interval;
            } else {
                // 反之将当前区间合并到结果的最后区间
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }
        }

        return Arrays.copyOf(res, idx + 1);
    }
}