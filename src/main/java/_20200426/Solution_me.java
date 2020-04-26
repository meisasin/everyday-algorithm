package _20200426;

import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution_me {

    public ListNode mergeKLists(ListNode[] lists) {

        List<Integer> numList = new ArrayList<>();
        for (int i = 0 ; i < lists.length ; i ++) {
            ListNode node = lists[i];
            while (node != null) {
                numList.add(node.val);
                node = node.next;
            }
        }
        if (numList.size() == 0) {
            return null;
        }
        // 排序
        Collections.sort(numList);

        ListNode ans = new ListNode(numList.get(0));
        ListNode head = ans;

        for (int i = 1 ; i < numList.size() ; i ++) {
            ans.next = new ListNode(numList.get(i));
            ans = ans.next;
        }
        return head;
    }

    public ListNode mergeKLists_bak(ListNode[] lists) {
        Map<Integer, Integer> countMap = new HashMap<>();
        Set set = new TreeSet<>();
        for (int i = 0 ; i < lists.length ; i ++) {

            ListNode node = lists[i];
            while (node != null) {
                boolean noVal = set.add(node.val);
                countMap.put(node.val, noVal ? 1 : countMap.get(node.val) + 1);
                node = node.next;
            }
        }

        // [3, 4, 6, 7, 8, 21, 23]
        // {3=1, 4=2, 21=1, 6=1, 7=1, 23=1, 8=1}
        // System.out.println(set);
        // System.out.println(countMap);

        if (set.size() == 0) {
            return null;
        }

        Iterator<Integer> iterator = set.iterator();

        ListNode ans = new ListNode(0);
        ListNode head = ans;

        boolean isRoot = true;
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            Integer count = countMap.get(next);
            while (0 != count--) {
                if (isRoot) {
                    ans.val = next;
                    isRoot = false;
                } else {
                    ans.next = new ListNode(next);
                    ans = ans.next;
                }
            }
        }

        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}