package _20200430;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 效率太低了
 * 执行用时 : 27 ms 在所有 Java 提交中击败了 5.01% 的用户
 * 内存消耗 : 37.9 MB, 在所有 Java 提交中击败了 8.33% 的用户
 *
 * 没改啥代码，效率咋还变快了呢
 * 执行用时 : 1 ms, 在所有 Java 提交中击败了 99.89% 的用户
 * 内存消耗 : 36.8 MB, 在所有 Java 提交中击败了 8.33% 的用户
 *
 */
class Solution_me {

    /**
     * 快乐数
     * @param n
     * @return
     */
    public boolean isHappy(int n) {

        Map<Integer, Integer> nMap = new HashMap<>();

        int temp = 0;
        do {
            if (nMap.containsKey(n)) {
                return false;
            }
            nMap.put(n, 1);
            do {
                temp += Math.pow(n % 10, 2);
            } while ( (n = n / 10) != 0 );

            n = temp;
            temp = 0;
        } while (n != 1);
        return true;
    }

}

