package _20200423;

/**
 * 感觉今天的好难啊，看了题解也没看明白
 *      先补一下背包九讲吧
 */
class Solution_me {
    public int waysToChange(int n) {
        int number = 0;

        if (n == 25) return 9;

        int count_25 = n / 25;
        if (count_25 >= 1) {
            // 25 次数
            number += count_25 * 9 - (count_25 - 1);

            // 去除全是 1 相加时的重复
            number --;
        }

        int remainder = n % 25;

        if (n == 25) {
            number += 9;
        } else if ( remainder >= 20 ) {
            number += 7;
        } else if (remainder >= 15) {
            number += 5;
        } else if (remainder >= 10) {
            number += 4;
        } else if (remainder >= 5){
            number += 2;
        } else {
            number += 1;
        }

        return number;
    }
}
