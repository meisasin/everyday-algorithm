package _20200422;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
 * 题不太难，没看太明白，官网理解了一下大概意思，参照着写了一下
 */
class Solution_me {
    public List<Integer> rightSideView(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0 ; i < size ; i ++) {
                TreeNode treeNode = queue.poll();
                if (treeNode.left != null) queue.offer(treeNode.left);
                if (treeNode.right != null) queue.offer(treeNode.right);

                if (i == size -1) {
                    result.add(treeNode.val);
                }
            }
        }
        return result;
    }
}
