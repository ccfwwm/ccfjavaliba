/**
 * 题目Id：112
 * 题目：路径总和
 * 日期：2021-03-10 10:00:03
 */
//给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和
// targetSum 。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,3], targetSum = 5
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], targetSum = 0
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [0, 5000] 内 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
// Related Topics 树 深度优先搜索 
// 👍 531 👎 0

package leetcode.editor.cn;

import com.company.TreeNode;

public class PathSum112 {
    public static void main(String[] args) {
        Solution solution = new PathSum112().new Solution();
    }
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
        public boolean hasPathSum(TreeNode root, int targetSum) {
            //如果root为null，返回fasle
            if(root == null){
                return false;
            }
            //如果root为叶节点，则判断root.val 是否等于targetSum,否则还是false
            if(root.left == null && root.right ==null){
                if(root.val == targetSum){
                    return true;
                }
                return false;
            }
            //左右子树有一个返回true则有路径，所以用或,每下一层，则目标为减去当前val后的值。
            return hasPathSum(root.left,targetSum-root.val) || hasPathSum(root.right,targetSum-root.val);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
