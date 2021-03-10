/**
  * 题目Id：101
  * 题目：对称二叉树
  * 日期：2021-03-07 19:01:06
*/
//给定一个二叉树，检查它是否是镜像对称的。 
//
// 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// 进阶： 
//
// 你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 1273 👎 0

package leetcode.editor.cn;

import com.company.TreeNode;

public class SymmetricTree101{
    public static void main(String[] args) {
        Solution solution = new SymmetricTree101().new Solution();
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
    public boolean isSymmetric(TreeNode root) {
       return isSymmetric(root,root);
    }
    public boolean isSymmetric(TreeNode left,TreeNode right){
       if(left == null && right == null){
           return true;
       }
       if(left == null || right == null){
           return false;
       }
       if(left.val != right.val){
           return false;
        }
       return isSymmetric(left.right,right.left)&&isSymmetric(left.left,right.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
