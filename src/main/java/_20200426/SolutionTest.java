package _20200426;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class SolutionTest {


    @Test
    public void testReversePairs() {

        ListNode root1 = new ListNode(1);
        root1.next = new ListNode(4);
        root1.next.next = new ListNode(5);

        ListNode root2 = new ListNode(1);
        root2.next = new ListNode(3);
        root2.next.next = new ListNode(4);

        ListNode root3 = new ListNode(2);
        root3.next = new ListNode(6);

        ListNode resultNode = new Solution().mergeKLists(
                new ListNode[]{root1, root2, root3}
        );
        assertThat(resultNode.val, equalTo(1));
        assertThat(resultNode.next.val, equalTo(1));
        assertThat(resultNode.next.next.val, equalTo(2));
        assertThat(resultNode.next.next.next.val, equalTo(3));

    }
}
