package _20200422;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class SolutionTest {

    @Test
    public void testGetMaxRepetitions() {

        // [1,2,3,null,5,null,4];
        /**
         *
             1            <---
             /   \
             2     3         <---
             \     \
             5     4       <---
         */
        TreeNode root = new TreeNode(1);
        TreeNode _2 = new TreeNode(2);
        TreeNode _3 = new TreeNode(3);
        TreeNode _null = null;
        TreeNode _5 = new TreeNode(5);
        TreeNode _4 = new TreeNode(4);

        root.left = _2;
        root.right = _3;

        _2.left = _null;
        _2.right = _5;

        _3.left = _null;
        _3.right = _4;

        /**
         * 输入：[1,2,3,null,5,null,4];
         * 输出：[1, 3, 4]
         */
        assertThat(new Solution().rightSideView(root).get(0), equalTo(1));
        assertThat(new Solution().rightSideView(root).get(1), equalTo(3));
        assertThat(new Solution().rightSideView(root).get(2), equalTo(4));

    }
}
