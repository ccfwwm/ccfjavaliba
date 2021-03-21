package leetcode.editor.cn;

import com.company.TreeNode;

public class LC543DiameterOfBinaryTree {
    public static void main(String[] args) {
     Solution solution = new LC543DiameterOfBinaryTree().new Solution();
    }
/**
  * 题目Id：543
  * 题目：二叉树的直径
  * 日期：2021-03-21 10:54:11
*/
//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。 
//
// 
//
// 示例 : 
//给定二叉树 
//
//           1
//         / \
//        2   3
//       / \     
//      4   5    
// 
//
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。 
//
// 
//
// 注意：两结点之间的路径长度是以它们之间边的数目表示。 
// Related Topics 树 
// 👍 648 👎 0

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
    int maxLen = 0;
    public int diameterOfBinaryTree(TreeNode root) {
       inorder(root);
       return maxLen-1;
    }
    private int inorder(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = inorder(root.left);
        int right = inorder(root.right);
        maxLen = Math.max(maxLen,left+right+1);
        return Math.max(left,right)+1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

















