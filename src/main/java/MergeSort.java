import java.util.Arrays;

/**
 * 归并排序
 * @date 2020/4/24 Í 10:47 下午
 */
public class MergeSort {


    public static void main(String[] args) {

        int[] data = {1, 4, 5, 3, 11, 3, 0, 6};
        int[] temp = {1, 4, 5, 3, 11, 3, 0, 6};

        mergeSort(data, 0, data.length - 1, temp);
        System.out.println(Arrays.toString(data));


        data = new int[] {1, 4, 5, 3, 11, 3, 0, 6};   // 1 + 3 + 3 + 1 + 3 + 1 + 0 + 0 = 12
        temp = new int[] {1, 4, 5, 3, 11, 3, 0, 6};
        int count = mergeSort_1(data, 0, data.length - 1, temp);
        System.out.println(Arrays.toString(data));
        System.out.println(count);

    }

    public static void mergeSort(int[] data, int left, int right,int[] temp) {

        if (left == right) {
            return;
        }

        int mid = left + (right - left) / 2;

        mergeSort(data, left, mid, temp);
        mergeSort(data, mid + 1, right, temp);

        // 合并且排序
        mergeAndSort(data, left, mid, right, temp);

    }


    public static void mergeAndSort(int[] data, int left, int mid, int right, int[] temp) {

        // 将排序前的值赋予一个临时数组
        for (int i = left ; i <= right ; i ++) temp[i] = data[i];

        int leftP = left;
        int rightP = mid + 1;

        for (int i = left ; i <= right ; i ++) {

            if (leftP == mid + 1) {
                data[i] = temp[rightP++];
            } else if (rightP == right + 1) {
                data[i] = temp[leftP++];
            } else if (temp[rightP] < temp[leftP]) {
                data[i] = temp[rightP++];
            } else {
                data[i] = temp[leftP++];
            }
        }
    }



    public static int mergeSort_1(int[] data, int left, int right, int[] temp) {

        if (left == right) return 0;

        int mid = left + (right - left) / 2;

        int leftC = mergeSort_1(data, left, mid, temp);
        int rightC = mergeSort_1(data, mid + 1, right, temp);

        int mC = mergeAndSort_1(data, left, mid, right, temp);
        return leftC + rightC + mC;
    }

    private static int mergeAndSort_1(int[] data, int left, int mid, int right, int[] temp) {

        System.out.println("begin left " + data[left] + ", right " + data[right]);
        for (int i = left ; i <= right ; i++) temp[i] = data[i];
        int count = 0;
        int leftP = left;
        int rightP = mid + 1;

        for (int i = left ; i <= right ; i ++) {

            if (leftP == mid + 1) {
                data[i] = temp[rightP++];
            } else if (rightP == right + 1) {
                data[i] = temp[leftP++];
            } else if (temp[leftP] > temp[rightP]) {
                data[i] = temp[leftP++];
                // 计逆序数量
                count += right - rightP + 1;
            } else {
                data[i] = temp[rightP++];
            }
        }
        System.out.println("end left " + data[left] + ", right " + data[right] + ", count " + count);
        return count;
    }
}
