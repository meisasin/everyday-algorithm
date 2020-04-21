package _20200421;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class SolutionTest {

    @Test
    public void testGetMaxRepetitions() {

        /**
         * 输入：nums = [], k = 1
         * 输出：0
         */
        assertThat(new Solution_me().numberOfSubarrays(new int[]
                { 2, 4, 6 }, 1), equalTo(0));

        /**
         * 输入：nums = [1,1,2,1,1], k = 3
         *      idx  = [0,1,2,3,4]
         * 输出：2
         */
        assertThat(new Solution_me().numberOfSubarrays(new int[]
                { 1, 1, 2, 1, 1 }, 3), equalTo(2));

        /**
         * (beginOddIdx - beginIdx + 1) * (endIdx - endOddIdx + 1);
         * 输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
         * 输入：nums = [2,2,2,1,2,2,1,2,1,2], k = 2
         *      idx  = [0,1,2,3,4,5,6,7,8,9]
         * 输出：16
         */
        assertThat(new Solution_me().numberOfSubarrays(new int[]
                { 2, 2, 2, 1, 2, 2, 1, 2, 2, 2}, 2), equalTo(16));

    }
}
