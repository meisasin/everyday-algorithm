package _20200429;

/**
 * 今天的题有点难，没找到思路
 */
class Solution_me {

    public int findInMountainArray(int target, MountainArray mountainArr) {

        return findInMountainArray(target, 0, mountainArr.length() - 1, mountainArr);

    }

    public int findInMountainArray(int target, int left, int right, MountainArray mountainArr) {
        int mid = (left + right) / 2;
        if (mountainArr.get(mid) == target) return mid;
        if (left == right) return -1;

        int leftP = findInMountainArray(target, left, mid, mountainArr);  // 向左找
        if (leftP != -1) return leftP;
        int rightP = findInMountainArray(target, mid + 1, right, mountainArr); // 向右找
        if (rightP != -1) return rightP;
        return -1;
    }

}

interface MountainArray {
    int get(int index);
    int length();
}