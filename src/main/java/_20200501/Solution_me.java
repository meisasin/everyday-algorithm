package _20200501;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * 一道简单的题，写了这么长
 */
public class Solution_me {


    public ListNode mergeTwoLists_(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode next = new ListNode(-1);
        ListNode top = next;
        while (true) {

            if (l1 == null) {
                next.next = l2;
                break;
            }
            if (l2 == null) {
                next.next = l1;
                break;
            }

            if (l1.val > l2.val) {
                next.next = new ListNode(l2.val);
                l2 = l2.next;
            } else {
                next.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            next = next.next;
        }
        return top.next;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) {
            return null;
        }
        List<Integer> nList = new ArrayList<>();
        while (l1 != null) {
            nList.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            nList.add(l2.val);
            l2 = l2.next;
        }

        Collections.sort(nList);
        ListNode next = new ListNode(nList.get(0));
        ListNode top = next;
        for (int i = 1 ; i < nList.size() ; i ++) {
            next.next = new ListNode(nList.get(i));
            next = next.next;
        }
        return top;
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}