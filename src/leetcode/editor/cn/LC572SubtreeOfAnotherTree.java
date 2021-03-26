package leetcode.editor.cn;

import com.company.TreeNode;

import java.util.TreeMap;

public class LC572SubtreeOfAnotherTree {
    public static void main(String[] args) {
        Solution solution = new LC572SubtreeOfAnotherTree().new Solution();
    }
/**
 * 题目Id：572
 * 题目：另一个树的子树
 * 日期：2021-03-22 21:55:15
 */
//给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看
//做它自身的一棵子树。 
//
// 示例 1: 
//给定的树 s: 
//
// 
//     3
//    / \
//   4   5
//  / \
// 1   2
// 
//
// 给定的树 t： 
//
// 
//   4 
//  / \
// 1   2
// 
//
// 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。 
//
// 示例 2: 
//给定的树 s： 
//
// 
//     3
//    / \
//   4   5
//  / \
// 1   2
//    /
//   0
// 
//
// 给定的树 t： 
//
// 
//   4
//  / \
// 1   2
// 
//
// 返回 false。 
// Related Topics 树 
// 👍 461 👎 0

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
        public boolean isSubtree(TreeNode s, TreeNode t) {
            if (s == null) {
                return false;
            }
            if (findSubtree(s, t)) {
                return true;
            }
            return isSubtree(s.left, t) || isSubtree(s.right, t);
        }
        private boolean findSubtree(TreeNode s, TreeNode t) {
            if (s == null && t == null) {
                return true;
            }
            if (s == null || t == null) {
                return false;
            }
            if (s.val != t.val) {
                return false;
            }
            return findSubtree(s.left, t.left) && findSubtree(s.right, t.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}