package leetcode.editor.cn;
//给定一个不为空的二叉搜索树和一个目标值 target，请在该二叉搜索树中找到最接近目标值 target 的 k 个值。 
//
// 注意： 
//
// 
// 给定的目标值 target 是一个浮点数 
// 你可以默认 k 值永远是有效的，即 k ≤ 总结点数 
// 题目保证该二叉搜索树中只会存在一种 k 个值集合最接近目标值 
// 
//
// 示例： 
//
// 输入: root = [4,2,5,1,3]，目标值 = 3.714286，且 k = 2
//
//    4
//   / \
//  2   5
// / \
//1   3
//
//输出: [4,3] 
//
// 拓展： 
//假设该二叉搜索树是平衡的，请问您是否能在小于 O(n)（n 为总结点数）的时间复杂度内解决该问题呢？ 
// Related Topics 栈 树 
// 👍 76 👎 0

import com.company.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class LC272ClosestBinarySearchTreeValueIi {
    public static void main(String[] args) {
        Solution solution = new LC272ClosestBinarySearchTreeValueIi().new Solution();

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
        LinkedList<Integer> list;

        public List<Integer> closestKValues(TreeNode root, double target, int k) {
            list = new LinkedList<>();
            inorder(root, target, k);
            return list;
        }

        private void inorder(TreeNode root, double target, int k) {
            if (root == null) {
                return;
            }
            inorder(root.left, target, k);
            if (list.size() == k) {
                if (Math.abs(target - list.getFirst()) <= Math.abs(target - root.val)) {
                    return;
                }
                list.offer(root.val);
                list.removeFirst();
            } else {
                list.offer(root.val);
            }
            inorder(root.right, target, k);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}