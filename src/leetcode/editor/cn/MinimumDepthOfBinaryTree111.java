/**
 * 题目Id：111
 * 题目：二叉树的最小深度
 * 日期：2021-03-10 09:44:46
 */
//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明：叶子节点是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数的范围在 [0, 105] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 468 👎 0

package leetcode.editor.cn;

import com.company.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree111 {
    public static void main(String[] args) {
        Solution solution = new MinimumDepthOfBinaryTree111().new Solution();
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
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            Queue<TreeNode> que = new LinkedList<>();
            que.offer(root);
            int depth = 1;
            int size;
            TreeNode current, left, right;
            while (!que.isEmpty()) {
                size = que.size();
                for (int i = 0; i < size; i++) {
                    current = que.poll();
                    left = current.left;
                    right = current.right;
                    if (left == null && right == null) {
                        return depth;
                    }
                    if (left != null) {
                        que.add(left);
                    }
                    if (right != null) {
                        que.add(right);
                    }
                }
                depth++;
            }
            return depth;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
