package _20200424;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class SolutionTest {


    @Test
    public void testReversePairs() {

        assertThat(new Solution_me().reversePairs(new int[] { 7, 5, 6, 4 }), equalTo(5));
        // 1 + 4 + 2 + 1
        assertThat(new Solution_me().reversePairs(new int[] { 1, 8, 4, 2 , 0, 7}), equalTo(8));
        // 2 + 1
        assertThat(new Solution_me().reversePairs(new int[] { 1, 2, 1, 2, 1 }), equalTo(3));

    }
}
