package _20200417;

import java.util.LinkedList;
import java.util.Queue;

class Solution_me {

    public static void main(String[] args) {


    }
    public boolean canJump(int[] nums) {

        if (nums[0] == 0) {
            return nums.length == 1 ? true : false;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0 ; i < nums.length - 1 ; i ++) {
            if (nums[i] == 0) {
                // 将每一个 0 值的索引放入队列
                queue.offer(i);
            }
        }
        // 如果队列里面没有值，说明数组中无 0 值，肯定能走到最后一步
        a:
        while (!queue.isEmpty()) {
            Integer idx = queue.poll();
            int currIdx = 0;
            while (idx - (++currIdx) >= 0) {
                if (nums[idx - currIdx] > currIdx) {
                    continue a;
                }
            }
            return false;
        }
        return true;
    }
}