package leetcode.editor.cn;

import com.company.TreeNode;

public class LC549BinaryTreeLongestConsecutiveSequenceIi {
    public static void main(String[] args) {
     Solution solution = new LC549BinaryTreeLongestConsecutiveSequenceIi().new Solution();
    }
/**
  * 题目Id：549
  * 题目：二叉树中最长的连续序列
  * 日期：2021-03-22 15:54:20
*/
//给定一个二叉树，你需要找出二叉树中最长的连续序列路径的长度。 
//
// 请注意，该路径可以是递增的或者是递减。例如，[1,2,3,4] 和 [4,3,2,1] 都被认为是合法的，而路径 [1,2,4,3] 则不合法。另一方面，
//路径可以是 子-父-子 顺序，并不一定是 父-子 顺序。 
//
// 示例 1: 
//
// 输入:
//        1
//       / \
//      2   3
//输出: 2
//解释: 最长的连续路径是 [1, 2] 或者 [2, 1]。
// 
//
// 
//
// 示例 2: 
//
// 输入:
//        2
//       / \
//      1   3
//输出: 3
//解释: 最长的连续路径是 [1, 2, 3] 或者 [3, 2, 1]。
// 
//
// 
//
// 注意: 树上所有节点的值都在 [-1e7, 1e7] 范围内。 
// Related Topics 树 
// 👍 70 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    private int max;

    public int longestConsecutive(TreeNode root) {
        max = 0;
        dfs(root, 0);
        return max;
    }

    //返回值表示的是父亲节点的最长递增序列和最长递减序列
    private int[] dfs(TreeNode node, int pre){
        if(node == null){
            return new int[]{1, 1};
        }
        int[] left = dfs(node.left, node.val);
        int[] right = dfs(node.right, node.val);
        max = Math.max(left[0] + right[1] - 1, max);
        max = Math.max(left[1] + right[0] - 1, max);
        int incre = 1, decre = 1;
        if(node.val + 1 == pre){
            //更新递增序列长度
            incre = Math.max(left[0], right[0]) + 1;
        }
        if(node.val - 1 == pre){
            //更新递减序列长度
            decre = Math.max(left[1], right[1]) + 1;
        }
        return new int[]{incre, decre};
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}t