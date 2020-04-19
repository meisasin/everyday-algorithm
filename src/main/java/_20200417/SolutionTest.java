package _20200417;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class SolutionTest {

    @Test
    public void testCanJump() {
        assertThat(new Solution().canJump(new int[]{ 2, 3, 1, 1, 4 }), equalTo(true));
        assertThat(new Solution().canJump(new int[]{ 3, 2, 1, 0, 4 }), equalTo(false));
        assertThat(new Solution().canJump(new int[]{ 2, 0 }), equalTo(true));
        assertThat(new Solution().canJump(new int[]{ 2, 1, 0, 0 }), equalTo(false));
        assertThat(new Solution().canJump(new int[]{ 2, 5, 0, 3 }), equalTo(true));
    }
}
