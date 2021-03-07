/**
  * 题目Id：98
  * 题目：验证二叉搜索树
  * 日期：2021-03-05 21:22:27
*/
//给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索 递归 
// 👍 945 👎 0

package leetcode.editor.cn;

import com.company.TreeNode;

public class ValidateBinarySearchTree98{
    public static void main(String[] args) {
        Solution solution = new ValidateBinarySearchTree98().new Solution();
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
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
//        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
        return helper(root);
    }
    public boolean isValidBST(TreeNode root ,long lower,long upper){
        if(root == null){
            return true;
        }
        if(root.val<=lower || root.val>= upper){
            return false;
        }
        return isValidBST(root.left,lower,root.val)&&isValidBST(root.right,root.val,upper);
    }

    private boolean helper(TreeNode root){
        if(root == null){
            return true;
        }
        boolean left = helper(root.left);
        //left为fase或者当前节点小于等于前一个节点，直接false
        if(!left || root.val<=pre){
            return false;
        }
        pre = root.val;
        boolean right = helper(root.right);
        return right;
    }
}



//leetcode submit region end(Prohibit modification and deletion)

}
