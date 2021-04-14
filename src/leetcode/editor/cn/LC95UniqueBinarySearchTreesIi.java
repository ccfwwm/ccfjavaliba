package leetcode.editor.cn;

import com.company.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LC95UniqueBinarySearchTreesIi {
    public static void main(String[] args) {
        Solution solution = new LC95UniqueBinarySearchTreesIi().new Solution();
    }
/**
 * 题目Id：95
 * 题目：不同的二叉搜索树 II
 * 日期：2021-04-13 21:37:28
 */
//给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。 
//
// 
//
// 示例： 
//
// 输入：3
//输出：
//[
//  [1,null,3,2],
//  [3,2,null,1],
//  [3,1,null,null,2],
//  [2,1,3],
//  [1,null,2,null,3]
//]
//解释：
//以上的输出对应以下 5 种不同结构的二叉搜索树：
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 8 
// 
// Related Topics 树 动态规划 
// 👍 851 👎 0

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

        public List<TreeNode> generateTrees(int n) {
            return generateTrees(1, n);
        }

        public List<TreeNode> generateTrees(int start, int end) {
            //每次递归都需要新建
            List<TreeNode> allValidaTrees = new LinkedList<>();
            //空节点需要返回
            if (start > end) {
                allValidaTrees.add(null);
                return allValidaTrees;

            }
            //循环分治法，左右遍历，由于是寻找二叉搜索数，节点left<root<right。数的左边为left
            //数的右边为right
            for (int i = start; i <= end; i++) {
                List<TreeNode> allValidaLeft = generateTrees(start, i - 1);
                List<TreeNode> allValidaRight = generateTrees(i + 1, end);
                //最外面一层，遍历最多。不断左右子数组合，变成更上一层树的节点。
                //left 为null，也会进入null遍历
                for (TreeNode left : allValidaLeft) {
                    for (TreeNode right : allValidaRight) {
                        //此步骤可以简化成一步
//                    TreeNode cur = new TreeNode(i);
//                    cur.left = left;
//                    cur.right = right;
//                    allValidaTrees.add(cur);

                        //构建新树并添加
                        allValidaTrees.add(new TreeNode(i, left, right));
                    }

                }
            }
            return allValidaTrees;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}