package _20200427;


/**
 * 采用 人工制能 大佬写的。 可怕，不敢说，也不敢问
 *  {@link <a href="https://leetcode-cn.com/u/lukelee/">https://leetcode-cn.com/u/lukelee/</a>}
 *  {@link <a href="https://leetcode-cn.com/problems/search-in-rotated-sorted-array/solution/ji-jian-solution-by-lukelee/">https://leetcode-cn.com/problems/search-in-rotated-sorted-array/solution/ji-jian-solution-by-lukelee/</a>}
 */
class Solution {
    public int search(int[] nums, int target) {

        int lo = 0, hi = nums.length - 1;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if ( (nums[0] > target) ^ (nums[0] > nums[mid]) ^ (target > nums[mid]))
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo == hi && nums[lo] == target ? lo : -1;
    }
}