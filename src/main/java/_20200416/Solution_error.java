package _20200416;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 我就是一个弟弟😭
 */
class Solution_error {

    public int[][] merge(int[][] intervals) {

        if (intervals.length == 0) {
            return new int[0][0];
        }
        int[] data = new int[(int)(intervals[0][1] / 0.75) + 1];
        for (int i = 0 ; i < intervals.length ; i ++) {

            int[] interval = intervals[i];
            int begin = interval[0];
            int end = interval[1];

            // 扩容
            if (data.length <= end) {
                data = Arrays.copyOf(data, (int) (end / 0.75) + 1);
            }

            // 对应角标设置值
            for (int j = end ; j >= begin ; j --) {
                data[j] = 1;
            }
        }

        List<Integer[]> resultList = new ArrayList();

        int begin = 0;
        for (int i = 0 ; i < data.length ; i ++) {

            int currVal = data[i];

            if (currVal == 0) {
                if (begin != 0) {
                    resultList.add(new Integer[] { begin, i - 1 });
                    begin = 0;
                }
                continue;
            }

            if (i == data.length - 1) {

                if (begin == 0 && currVal == 0) {
                    break;
                }
                if (begin != 0 && currVal != 0) {
                    resultList.add(new Integer[]{begin, i});
                    break;
                }

                int max = Math.max(begin, currVal);
                resultList.add(new Integer[] { max, max });
                break;
            }

            // 如果没有开始值
            if (begin == 0) {
                begin = i;
                continue;
            }
        }

        int[][] result = new int[resultList.size()][2];
        for (int i = 0 ; i < result.length ; i ++) {
            result[i][0] = resultList.get(i)[0];
            result[i][1] = resultList.get(i)[1];
        }

        return result;
    }
}