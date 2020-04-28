package _20200428;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 俺就知道没有这么简单
 */
class Solution_me {

    public int[] singleNumbers(int[] nums) {
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0 ; i < nums.length ; i ++) {
            if (numMap.containsKey(nums[i]))
                numMap.remove(nums[i]);
            else
                numMap.put(nums[i], 1);
        }
        return new ArrayList<>(numMap.keySet()).stream().mapToInt(__ -> __).toArray();
    }

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0 ; i < nums.length ; i ++) {
            result ^= nums[i];
        }
        return result;
    }

}