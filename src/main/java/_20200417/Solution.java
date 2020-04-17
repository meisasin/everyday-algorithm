package _20200417;

class Solution {

    public static void main(String[] args) {


    }
    public boolean canJump(int[] nums) {

        int maxStep = nums[0];
        for (int i = 0;i <= maxStep && maxStep < nums.length - 1;i++) {
            maxStep = Math.max(maxStep, nums[i] + i);
        }
        return maxStep > nums.length - 2;
    }
}