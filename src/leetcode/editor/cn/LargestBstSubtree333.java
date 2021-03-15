package leetcode.editor.cn;

import com.company.TreeNode;

import java.util.Map;
import java.util.Stack;

public class LargestBstSubtree333 {
    public static void main(String[] args) {
        Solution solution = new LargestBstSubtree333().new Solution();
    }
/**
 * 题目Id：333
 * 题目：最大 BST 子树
 * 日期：2021-03-15 14:14:38
 */
//给定一个二叉树，找到其中最大的二叉搜索树（BST）子树，并返回该子树的大小。其中，最大指的是子树节点数最多的。 
//
// 二叉搜索树（BST）中的所有节点都具备以下属性： 
//
// 
// 
// 左子树的值小于其父（根）节点的值。 
// 
// 
// 右子树的值大于其父（根）节点的值。 
// 
// 
//
// 注意: 
//
// 
// 子树必须包含其所有后代。 
// 
//
// 进阶: 
//
// 
// 你能想出 O(n) 时间复杂度的解法吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [10,5,15,1,8,null,7]
//输出：3
//解释：本例中最大的 BST 子树是高亮显示的子树。返回值是子树的大小，即 3 。 
//
// 示例 2： 
//
// 
//输入：root = [4,2,7,2,3,5,null,2,null,null,null,null,null,1]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 树上节点数目的范围是 [0, 104] 
// -104 <= Node.val <= 104 
// 
// Related Topics 树 
// 👍 84 👎 0

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
        public int largestBSTSubtree(TreeNode root) {
            if(root ==null){
                return 0;
            }
            if(isBST(root)){
                return getCount(root);
            }
            int leftCount = largestBSTSubtree(root.left);
            int rightCount = largestBSTSubtree(root.right);
            return Math.max(leftCount,rightCount);
        }
        private boolean isBST(TreeNode root){
            return isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
        }
        private boolean isBST(TreeNode root,int min,int max){
            if(root ==null) {
                return true;
            }
            return min<root.val && root.val<max&&isBST(root.left,min,root.val)&&isBST(root.right,root.val,max);
        }
        private int getCount(TreeNode root){
            if(root ==null){
                return 0;
            }
            return getCount(root.left)+getCount(root.right)+1;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}