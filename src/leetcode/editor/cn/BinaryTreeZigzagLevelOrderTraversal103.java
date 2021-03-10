/**
 * 题目Id：103
 * 题目：二叉树的锯齿形层序遍历
 * 日期：2021-03-07 22:08:30
 */
//给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
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
// 返回锯齿形层序遍历如下： 
//
// 
//[
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索 
// 👍 403 👎 0

package leetcode.editor.cn;

import com.company.TreeNode;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal103 {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeZigzagLevelOrderTraversal103().new Solution();
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
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            if (root == null) {
                return new LinkedList<>();
            }
            List<List<Integer>> allTree = new LinkedList<>();
            LinkedList<Integer> currDep;
            Queue<TreeNode> cur = new LinkedList();
            cur.offer(root);
            int flag = 1;
            while (!cur.isEmpty()) {
                currDep = new LinkedList<>();
                int size = cur.size();
                for (int i = 0; i < size; i++) {
                    if (cur.element().left != null) {
                        cur.offer(cur.element().left);
                    }
                    if (cur.element().right != null) {
                        cur.offer(cur.element().right);
                    }
                    currDep.add(cur.poll().val);
                }
                if (flag == 0) {
                    Collections.reverse(currDep);
                    flag = 1;
                } else {
                    flag = 0;
                }
                allTree.add(currDep);
            }
            return allTree;

        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
