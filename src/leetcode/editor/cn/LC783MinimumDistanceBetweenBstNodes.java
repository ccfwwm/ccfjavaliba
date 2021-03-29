package leetcode.editor.cn;

import com.company.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

public class LC783MinimumDistanceBetweenBstNodes {
    public static void main(String[] args) {
        Solution solution = new LC783MinimumDistanceBetweenBstNodes().new Solution();
    }
/**
 * 题目Id：783
 * 题目：二叉搜索树节点最小距离
 * 日期：2021-03-29 20:08:16
 */
//给定一个二叉搜索树的根节点 root，返回树中任意两节点的差的最小值。 
//
// 
//
// 示例： 
//
// 输入: root = [4,2,6,1,3,null,null]
//输出: 1
//解释:
//注意，root是树节点对象(TreeNode object)，而不是数组。
//
//给定的树 [4,2,6,1,3,null,null] 可表示为下图:
//
//          4
//        /   \
//      2      6
//     / \    
//    1   3  
//
//最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。 
//
// 
//
// 注意： 
//
// 
// 二叉树的大小范围在 2 到 100。 
// 二叉树总是有效的，每个节点的值都是整数，且不重复。 
// 本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/ 
//相同 
// 
// Related Topics 树 深度优先搜索 递归 
// 👍 115 👎 0

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
        int minAbs;
        TreeNode pre;
        public int minDiffInBST(TreeNode root) {
            //先赋值，不然无法取到最新。会溢出
            if (root.left != null) {
                minAbs = Math.abs(root.val - root.left.val);
            } else {
                minAbs = Math.abs(root.val - root.right.val);
            }
            pre=root;
            dfs(root);
            return minAbs;
        }

        private void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            dfs(root.left);
            if (pre == null) {
                pre = root;
            } else {
                minAbs = Math.min(minAbs, Math.abs(root.val - pre.val));
                pre = root;
            }
            dfs(root.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}




