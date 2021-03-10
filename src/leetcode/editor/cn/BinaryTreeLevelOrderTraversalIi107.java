/**
 * 题目Id：107
 * 题目：二叉树的层序遍历 II
 * 日期：2021-03-09 23:05:11
 */
//给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其自底向上的层序遍历为： 
//
// 
//[
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 414 👎 0

package leetcode.editor.cn;

import com.company.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeLevelOrderTraversalIi107 {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversalIi107().new Solution();
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
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            if (root == null) {
                return new LinkedList<>();
            }
            List<List<Integer>> list = new LinkedList<>();
            Queue<TreeNode> qdepth = new LinkedList<>();
            qdepth.offer(root);
            TreeNode currRoot;
            int size;
            while (!qdepth.isEmpty()) {
                size = qdepth.size();
                List<Integer> currDepthVal = new LinkedList<>();
                for (int i = 0; i < size; i++) {
                    currRoot = qdepth.poll();
                    currDepthVal.add(currRoot.val);
                    if (currRoot.left != null) {
                        qdepth.offer(currRoot.left);
                    }
                    if (currRoot.right != null) {
                        qdepth.offer(currRoot.right);
                    }
                }
                list.add(0, currDepthVal);
            }
            return list;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
