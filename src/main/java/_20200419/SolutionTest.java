package _20200419;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class SolutionTest {

    @Test
    public void testGetMaxRepetitions() {

        System.out.println("Start at " + LocalDateTime.now());
        assertThat(new Solution().getMaxRepetitions("acb", 4, "ab", 2), equalTo(2));
        System.out.println("End at " + LocalDateTime.now());

        assertThat(new Solution().getMaxRepetitions("baba", 11, "baab", 1), equalTo(7));
        assertThat(new Solution().getMaxRepetitions("lovelive", 100000, "lovelive", 100000), equalTo(1));
        assertThat(new Solution().getMaxRepetitions("lovelive", 0, "lovelive", 100000), equalTo(0));
        System.out.println("Start at " + LocalDateTime.now());
        assertThat(new Solution().getMaxRepetitions(
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", 1000000,
                "a", 1), equalTo("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa".length() * 1000000));
        System.out.println("End at " + LocalDateTime.now());
    }
}
