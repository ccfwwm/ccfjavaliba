package leetcode.editor.cn;

import com.company.TreeNode;

import java.util.Map;

public class LC687LongestUnivaluePath {
    public static void main(String[] args) {
        Solution solution = new LC687LongestUnivaluePath().new Solution();
    }
/**
 * 题目Id：687
 * 题目：最长同值路径
 * 日期：2021-03-27 17:50:13
 */
//给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。 
//
// 注意：两个节点之间的路径长度由它们之间的边数表示。 
//
// 示例 1: 
//
// 输入: 
//
// 
//              5
//             / \
//            4   5
//           / \   \
//          1   1   5
// 
//
// 输出: 
//
// 
//2
// 
//
// 示例 2: 
//
// 输入: 
//
// 
//              1
//             / \
//            4   5
//           / \   \
//          4   4   5
// 
//
// 输出: 
//
// 
//2
// 
//
// 注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。 
// Related Topics 树 递归 
// 👍 437 👎 0

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
        int maxR = 0;

        public int longestUnivaluePath(TreeNode root) {
            if(root ==null){
                return 0;
            }
            dfs(root);
            return maxR ;
        }

        private int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = dfs(root.left);
            int right = dfs(root.right);
            int sum = 0;
            if (root.left!=null && root.right!=null && root.left.val == root.val && root.val == root.right.val) {
                maxR = Math.max(maxR, left + right + 2);
            }
            if(root.left!=null && root.val == root.left.val) {
                sum += left+1;
            }
            if (root.right!=null && root.val == root.right.val) {
                sum  = Math.max(sum,right+1);
            }
            maxR = Math.max(sum, maxR);
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}












