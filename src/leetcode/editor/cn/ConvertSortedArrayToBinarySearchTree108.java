/**
  * 题目Id：108
  * 题目：将有序数组转换为二叉搜索树
  * 日期：2021-03-10 09:08:15
*/
//给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。 
//
// 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-10,-3,0,5,9]
//输出：[0,-3,9,-10,null,5]
//解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
//
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,3]
//输出：[3,1]
//解释：[1,3] 和 [3,1] 都是高度平衡二叉搜索树。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// nums 按 严格递增 顺序排列 
// 
// Related Topics 树 深度优先搜索 
// 👍 714 👎 0

package leetcode.editor.cn;

import com.company.TreeNode;

public class ConvertSortedArrayToBinarySearchTree108{
    public static void main(String[] args) {
        Solution solution = new ConvertSortedArrayToBinarySearchTree108().new Solution();
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
    public TreeNode sortedArrayToBST(int[] nums) {
        return dichotomyDFS(nums,0,nums.length-1);
    }
    private TreeNode dichotomyDFS(int[] nums,int left,int right){
        //base case
        if(left>right){
            return null;
        }
        TreeNode root = new TreeNode();
        //防止越界
        int mid = left+(right-left)/2;
        root.val = nums[mid];
        //左子树
        root.left = dichotomyDFS(nums,left,mid-1);
        //右子树
        root.right = dichotomyDFS(nums,mid+1,right);
        //返回根
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
