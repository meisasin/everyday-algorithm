package _20200428;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class SolutionTest {


    @Test
    public void singleNumbers() {

        System.out.println(1 & 7);
        assertThat(new Solution().singleNumbers(new int[] { 4, 1, 4, 6 }), equalTo(new int[] { 6, 1 }));
        assertThat(new Solution().singleNumbers(new int[] { 1, 2, 10, 4, 1, 4, 3, 3 }), equalTo(new int[] { 2, 10 }));

    }

    @Test
    public void singleNumber() {

        assertThat(new Solution_me().singleNumber(new int[] { 4, 1, 4, 6, 1 }), equalTo(6));
        assertThat(new Solution_me().singleNumber(new int[] { 1, 2, 10, 4, 1, 4, 3, 3 , 2}), equalTo(10));
    }
}
