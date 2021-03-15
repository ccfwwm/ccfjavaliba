/**
 * 题目Id：199
 * 题目：二叉树的右视图
 * 日期：2021-03-11 14:56:44
 */
//给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 
//
// 示例: 
//
// 输入: [1,2,3,null,5,null,4]
//输出: [1, 3, 4]
//解释:
//
//   1            <---
// /   \
//2     3         <---
// \     \
//  5     4       <---
// 
// Related Topics 树 深度优先搜索 广度优先搜索 递归 队列 
// 👍 421 👎 0

package leetcode.editor.cn;

import com.company.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView199 {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeRightSideView199().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        //层序遍历，最后一个添加列表。
        public List<Integer> rightSideView(TreeNode root) {
            if (root == null) {
                return new LinkedList<>();
            }
            List<Integer> list = new LinkedList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int size;
            TreeNode curNode;
            while (!queue.isEmpty()) {
                size = queue.size();

                for (int i = 0; i < size - 1; i++) {
                    curNode = queue.poll();
                    if (curNode.left != null) {
                        queue.offer(curNode.left);
                    }
                    if (curNode.right != null) {
                        queue.offer(curNode.right);
                    }
                }
                curNode = queue.poll();
                list.add(curNode.val);
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }

            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
