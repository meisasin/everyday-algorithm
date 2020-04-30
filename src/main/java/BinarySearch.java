/**
 * 二分查找
 * @date 2020/4/30 Í 11:02 上午
 */
public class BinarySearch {

    /**
     * 山脉数组中查找目标值
     *
     * （这是一个 交互式问题 ）
     *
     * 给你一个 山脉数组 `mountainArr`，请你返回能够使得 `mountainArr.get(index)` 等于 `target` 最小 的下标 index 值。
     * 如果不存在这样的下标 `index`，就请返回 `-1`。
     *
     * 何为山脉数组？如果数组 `A` 是一个山脉数组的话，那它满足如下条件：
     * 首先，`A.length >= 3`
     * 其次，在 `0 < i < A.length - 1` 条件下，存在 `i` 使得：
     * - `A[0] < A[1] < ... A[i-1] < A[i]`
     * - `A[i] > A[i+1] > ... > A[A.length - 1]`
     *  
     * 你将 *不能直接访问该山脉数组*，必须通过 `MountainArray` 接口来获取数据：
     * - `MountainArray.get(k)` - 会返回数组中索引为`k` 的元素（下标从 `0` 开始）
     * - `MountainArray.length()` - 会返回该数组的长度
     *  
     * 注意：
     * 对 `MountainArray.get` 发起超过 `100` 次调用的提交将被视为错误答案。此外，任何试图规避判题系统的解决方案都将会导致比赛资格被取消。
     * 为了帮助大家更好地理解交互式问题，我们准备了一个样例 “答案”：[https://leetcode-cn.com/playground/RKhe3ave](https://leetcode-cn.com/playground/RKhe3ave)，*请注意这 不是一个正确答案*。
     *
     *
     * 示例 1:
     * ```
     * 输入：array = [1,2,3,4,5,3,1], target = 3
     * 输出：2
     * 解释：3 在数组中出现了两次，下标分别为 2 和 5，我们返回最小的下标 2。
     * ```
     *
     * 示例 2:
     * ```
     * 输入：array = [0,1,2,4,2,1], target = 3
     * 输出：-1
     * 解释：3 在数组中没有出现，返回 -1。
     * ```
     * @param targer
     * @param arr
     */
    public static int findInMountainArray(int targer, int[] arr) {

        // 首先二分查询山顶
        int topIdx = findMountainTop(arr, 0, arr.length - 1);

        // 二分查询山左边是否存在 targer
        int tIdx = findSortedArray(arr, 0, arr.length - 1, targer);
        if (tIdx != -1) return tIdx;
        return findReverseArr(arr, 0, arr.length - 1, targer);
    }

    /**
     * 在 [left ... right] 区间查询 targer
     * @param arr
     * @param left
     * @param right
     * @param targer
     * @return
     */
    private static int findReverseArr(int[] arr, int left, int right, int targer) {

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == targer) return mid;
            if (arr[mid] > targer) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 在 [left ... right] 区间查询 targer
     * @param arr
     * @param left
     * @param right
     * @param targer
     * @return
     */
    private static int findSortedArray(int[] arr, int left, int right, int targer) {

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == targer) return mid;

            if (arr[mid] > targer) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查询 [left ... right] 山顶索引
     * @param arr
     */
    private static int findMountainTop(int[] arr, int left, int right) {

        // [1, 3, 5, 7, 9, 4, 3, 1]
        // [5, 6]
        // [4, 5, 6]
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }

        }
        return left;
    }

    public static void main(String[] args) {
        int[] ints = {1, 3, 5, 7, 9, 4, 3, 2, 1};
        int mountainTop = BinarySearch.findMountainTop(ints, 0, ints.length);
        System.out.println(mountainTop);

        int tSIdx = BinarySearch.findSortedArray(ints, 0, 4, 7);
        System.out.println(tSIdx);

        int tRIdx = BinarySearch.findReverseArr(ints, 4, ints.length - 1, 3);
        System.out.println(tRIdx);

        int inMountainIdx = BinarySearch.findInMountainArray(5, ints);
        System.out.println(inMountainIdx);
    }
}
