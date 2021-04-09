package leetcode.editor.cn;

import com.company.TreeNode;

import java.util.TreeMap;

public class LC897IncreasingOrderSearchTree {
    public static void main(String[] args) {
        Solution solution = new LC897IncreasingOrderSearchTree().new Solution();
    }
/**
 * 题目Id：897
 * 题目：递增顺序查找树
 * 日期：2021-04-06 16:39:07
 */
//给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。 
//
// 
//
// 示例 ： 
//
// 输入：[5,3,6,2,4,null,8,1,null,null,null,7,9]
//
//       5
//      / \
//    3    6
//   / \    \
//  2   4    8
// /        / \ 
//1        7   9
//
//输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
//
// 1
//  \
//   2
//    \
//     3
//      \
//       4
//        \
//         5
//          \
//           6
//            \
//             7
//              \
//               8
//                \
//                 9  
//
// 
//
// 提示： 
//
// 
// 给定树中的结点数介于 1 和 100 之间。 
// 每个结点都有一个从 0 到 1000 范围内的唯一整数值。 
// 
// Related Topics 树 深度优先搜索 递归 
// 👍 146 👎 0

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
        TreeNode cur;
        public TreeNode increasingBST(TreeNode root) {
            TreeNode result = new TreeNode(0);
            cur = result;
            dfs(root);
            return result.right;
        }
        private void dfs(TreeNode root){
            if(root==null){
                return;
            }
            dfs(root.left);
            root.left = null;
            cur.right = root;
            cur = cur.right;
            dfs(root.right);
        }


    }

//leetcode submit region end(Prohibit modification and deletion)

}