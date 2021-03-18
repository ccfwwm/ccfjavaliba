package leetcode.editor.cn;

import com.company.TreeNode;

public class SumOfLeftLeaves404 {
    public static void main(String[] args) {
        Solution solution = new SumOfLeftLeaves404().new Solution();
    }
/**
 * 题目Id：404
 * 题目：左叶子之和
 * 日期：2021-03-17 08:48:18
 */
//计算给定二叉树的所有左叶子之和。 
//
// 示例： 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24 
//
// 
// Related Topics 树 
// 👍 296 👎 0

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
//    class Solution {
//        int leftSum;
//
//        public int sumOfLeftLeaves(TreeNode root) {
//            if (root == null) {
//                return 0;
//            }
//            leftSum = 0;
//            dfs(root);
//            return leftSum;
//        }
//
//        private void dfs(TreeNode root) {
//            dfs(root.left, 1);
//            dfs(root.right, 0);
//            return;
//        }
//
//        private void dfs(TreeNode root, int flag) {
//            if (root == null) {
//                return;
//            }
//            if (flag == 1 && root.left == null && root.right == null) {
//                leftSum += root.val;
//                return;
//            }
//            dfs(root.left, 1);
//            dfs(root.right, 0);
//            return;
//        }
//    }
    class Solution {

        public int sumOfLeftLeaves(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return dfs(root);
        }

        private int dfs(TreeNode root) {
            return dfs(root.left, 1)+dfs(root.right, 0);
        }

        private int dfs(TreeNode root, int flag) {
            if (root == null) {
                return 0;
            }
            if (flag == 1 && root.left == null && root.right == null) {
                return root.val;
            }
            return dfs(root.left, 1)+dfs(root.right, 0);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}