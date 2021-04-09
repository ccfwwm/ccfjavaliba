package leetcode.editor.cn;

import com.company.TreeNode;

public class LC965UnivaluedBinaryTree {
    public static void main(String[] args) {
        Solution solution = new LC965UnivaluedBinaryTree().new Solution();
    }
/**
 * 题目Id：965
 * 题目：单值二叉树
 * 日期：2021-04-07 16:35:36
 */
//如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。 
//
// 只有给定的树是单值二叉树时，才返回 true；否则返回 false。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：[1,1,1,1,1,null,1]
//输出：true
// 
//
// 示例 2： 
//
// 
//
// 输入：[2,2,2,5,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 给定树的节点数范围是 [1, 100]。 
// 每个节点的值都是整数，范围为 [0, 99] 。 
// 
// Related Topics 树 
// 👍 74 👎 0

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
    class Solution {
        public boolean isUnivalTree(TreeNode root) {
            return dfs(root, root.val);
        }

        private boolean dfs(TreeNode root, int parent) {
            if (root == null) {
                return true;
            }
            if (root.val != parent) {
                return false;
            }
            if (dfs(root.left,parent)) {
                return dfs(root.right, parent);
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}