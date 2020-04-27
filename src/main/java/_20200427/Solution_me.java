package _20200427;

/**
 * 哈哈，思路有点绕，本来都要放弃了，看了官网题解中的图片，思路大开
 */
class Solution_me {

    public int search(int[] nums, int target) {

        if (nums.length == 0) {
            return -1;
        }

        if (target == nums[0]) return 0;

        return search(nums, target, 0, nums.length - 1);

    }

    public int search(int[] nums, int targer, int begin, int end) {

        if (begin == end) {
            return nums[begin] == targer ? begin : -1;
        }
        int mid = begin + (end - begin) / 2;

        if (nums[mid] == targer) return mid;
        // 左边有序
        if (nums[mid] > nums[begin]) {
            if (targer >= nums[begin] && targer <= nums[mid])
                return search(nums, targer, begin, mid);
            else
                return search(nums, targer, mid + 1, end);
        } else {

            if (targer >= nums[mid + 1] && targer <= nums[end])
                return search(nums, targer, mid + 1, end);
            else
                return search(nums, targer, begin, mid);
        }
    }

}