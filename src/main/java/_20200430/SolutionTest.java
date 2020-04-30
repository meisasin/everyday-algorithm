package _20200430;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void isHappy() {
        boolean happy = new Solution().isHappy(19);
        System.out.println(happy);
    }

    @Test
    public void isRealHappy() {

        int i = 50;
        int j = 8;
        int z = 11;

        int i1 = i ^ j;

        System.out.println(i1);
        System.out.println(i1 ^= z);
        System.out.println(i1 ^= z);

        int a = 1 + 2 + 3;


    }
}
