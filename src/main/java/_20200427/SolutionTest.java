package _20200427;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class SolutionTest {


    @Test
    public void testReversePairs() {


        assertThat(new Solution().search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0), equalTo(4));
        assertThat(new Solution().search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 3), equalTo(-1));

        /**
         * a =  0 0 1 1   b = 0 0 1 1
         * ------------------------ a = a ^ b
         *      0 0 1 1
         *   ^  0 1 0 0
         * =    0 1 1 1
         * ------------------------ b = b ^ a
         *      0 0 1 1
         *   ^  0 1 1 1
         * =    0 1 0 0
         * ------------------------ a = a ^ b
         *      0 1 1 1
         *   ^  0 1 0 0
         * =    0 0 1 1
         */
    }
}
