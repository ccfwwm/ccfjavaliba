/**
  * 题目Id：250
  * 题目：统计同值子树
  * 日期：2021-03-14 13:41:46
*/
//给定一个二叉树，统计该二叉树数值相同的子树个数。 
//
// 同值子树是指该子树的所有节点都拥有相同的数值。 
//
// 示例： 
//
// 输入: root = [5,1,5,5,5,null,5]
//
//              5
//             / \
//            1   5
//           / \   \
//          5   5   5
//
//输出: 4
// 
// Related Topics 树 
// 👍 68 👎 0

package leetcode.editor.cn;

import com.company.TreeNode;

public class CountUnivalueSubtrees250{
    public static void main(String[] args) {
        Solution solution = new CountUnivalueSubtrees250().new Solution();
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
    int sumCount = 0;
    public int countUnivalSubtrees(TreeNode root) {
        isTheSame(root);
        return sumCount;
    }
    private boolean isTheSame(TreeNode root){
        if(root == null){
            return true;
        }
        boolean isLeft = false;
        if(root.left == null || (isTheSame(root.left)&&root.val == root.left.val)){
            isLeft=true;
        }
        boolean isRight = false;
        if(root.right == null || (isTheSame(root.right)&&root.val == root.right.val)) {
            isRight = true;
        }
        if (isLeft&&isRight){
            sumCount++;
            return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
