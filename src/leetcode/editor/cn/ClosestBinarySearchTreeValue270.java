/**
  * 题目Id：270
  * 题目：最接近的二叉搜索树值
  * 日期：2021-03-14 18:56:04
*/
//给定一个不为空的二叉搜索树和一个目标值 target，请在该二叉搜索树中找到最接近目标值 target 的数值。 
//
// 注意： 
//
// 
// 给定的目标值 target 是一个浮点数 
// 题目保证在该二叉搜索树中只会存在一个最接近目标值的数 
// 
//
// 示例： 
//
// 输入: root = [4,2,5,1,3]，目标值 target = 3.714286
//
//    4
//   / \
//  2   5
// / \
//1   3
//
//输出: 4
// 
// Related Topics 树 二分查找 
// 👍 73 👎 0

package leetcode.editor.cn;

import com.company.TreeNode;

public class ClosestBinarySearchTreeValue270{
    public static void main(String[] args) {
        Solution solution = new ClosestBinarySearchTreeValue270().new Solution();
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
    public int closestValue(TreeNode root, double target) {
        int curVal,cloest = root.val;
        while (root!=null){
           curVal = root.val;
           cloest= Math.abs(curVal-target)>Math.abs(cloest-target)?cloest:curVal;
           root = target<root.val?root.left:root.right;
        }
        return cloest;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
