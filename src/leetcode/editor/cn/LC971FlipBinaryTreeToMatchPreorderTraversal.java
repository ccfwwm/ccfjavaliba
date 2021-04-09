package leetcode.editor.cn;

import com.company.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC971FlipBinaryTreeToMatchPreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new LC971FlipBinaryTreeToMatchPreorderTraversal().new Solution();
    }
/**
 * 题目Id：971
 * 题目：翻转二叉树以匹配先序遍历
 * 日期：2021-04-07 22:08:19
 */
//给你一棵二叉树的根节点 root ，树中有 n 个节点，每个节点都有一个不同于其他节点且处于 1 到 n 之间的值。 
//
// 另给你一个由 n 个值组成的行程序列 voyage ，表示 预期 的二叉树 先序遍历 结果。 
//
// 通过交换节点的左右子树，可以 翻转 该二叉树中的任意节点。例，翻转节点 1 的效果如下： 
//
// 请翻转 最少 的树中节点，使二叉树的 先序遍历 与预期的遍历行程 voyage 相匹配 。 
//
// 如果可以，则返回 翻转的 所有节点的值的列表。你可以按任何顺序返回答案。如果不能，则返回列表 [-1]。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2], voyage = [2,1]
//输出：[-1]
//解释：翻转节点无法令先序遍历匹配预期行程。
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,3], voyage = [1,3,2]
//输出：[1]
//解释：交换节点 2 和 3 来翻转节点 1 ，先序遍历可以匹配预期行程。 
//
// 示例 3： 
//
// 
//输入：root = [1,2,3], voyage = [1,2,3]
//输出：[]
//解释：先序遍历已经匹配预期行程，所以不需要翻转节点。
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数目为 n 
// n == voyage.length 
// 1 <= n <= 100 
// 1 <= Node.val, voyage[i] <= n 
// 树中的所有值 互不相同 
// voyage 中的所有值 互不相同 
// 
// Related Topics 树 深度优先搜索 
// 👍 57 👎 0

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
        private int index = 0;
        private List<Integer> list = new LinkedList<>();

        public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
            if (dfs(root, voyage)) {
                return list;
            }
            return Arrays.asList(-1);
        }

        private boolean dfs(TreeNode root, int[] voyage) {
//        System.out.println("root="+root.val+" index="+index+" voyage[index]="+voyage[index]);
            if (root == null) {
                return true;
            }
            if (root.val != voyage[index]) {
                return false;
            }
            index++;
            if (root.left != null && root.right != null && root.left.val != voyage[index]) {
                list.add(root.val);
                return dfs(root.right, voyage) && dfs(root.left, voyage);
            } else {
                return dfs(root.left, voyage) && dfs(root.right, voyage);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}