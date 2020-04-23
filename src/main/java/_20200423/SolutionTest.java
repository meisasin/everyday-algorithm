package _20200423;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class SolutionTest {


    /**
     * 5 -> 2
     * 10 -> 4
     * 15 -> 5
     *      15 = 10+5
     *      15 = 10+1+1+1+1+1
     *      15 = 5+5+5
     *      15 = 5+5+1+1+1+1+1
     *      15 = 5+1+1+1+1+1+1+1+1+1+1
     *      15 = 1+1+1+1+1+1+1+1+1+1+1+1+1+1+1
     * 20 -> 7
     * 25 -> 9
     */
    @Test
    public void testWaysToChange() {

        assertThat(new Solution().waysToChange(5), equalTo(2));
        assertThat(new Solution().waysToChange(10), equalTo(4));
        assertThat(new Solution().waysToChange(15), equalTo(6));
        assertThat(new Solution().waysToChange(20), equalTo(9));
        assertThat(new Solution().waysToChange(25), equalTo(13));

    }
}
