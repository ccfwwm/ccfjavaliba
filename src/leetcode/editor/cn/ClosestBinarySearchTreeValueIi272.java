/**
  * 题目Id：272
  * 题目：最接近的二叉搜索树值 II
  * 日期：2021-03-14 19:33:55
*/
//给定一个不为空的二叉搜索树和一个目标值 target，请在该二叉搜索树中找到最接近目标值 target 的 k 个值。 
//
// 注意： 
//
// 
// 给定的目标值 target 是一个浮点数 
// 你可以默认 k 值永远是有效的，即 k ≤ 总结点数 
// 题目保证该二叉搜索树中只会存在一种 k 个值集合最接近目标值 
// 
//
// 示例： 
//
// 输入: root = [4,2,5,1,3]，目标值 = 3.714286，且 k = 2
//
//    4
//   / \
//  2   5
// / \
//1   3
//
//输出: [4,3] 
//
// 拓展： 
//假设该二叉搜索树是平衡的，请问您是否能在小于 O(n)（n 为总结点数）的时间复杂度内解决该问题呢？ 
// Related Topics 栈 树 
// 👍 71 👎 0

package leetcode.editor.cn;

import com.company.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class ClosestBinarySearchTreeValueIi272{
    public static void main(String[] args) {
        Solution solution = new ClosestBinarySearchTreeValueIi272().new Solution();
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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        inorder(list,root,target,k);
        return list;
    }
    private void inorder(LinkedList<Integer> list,TreeNode root,double target,int k){
        if(root ==null){
            return;
        }
        inorder(list,root.left,target,k);
        if(list.size() == k){
            if(Math.abs(list.getFirst()-target)>Math.abs(root.val-target)){
               list.offer(root.val);
               list.removeFirst();
            }else {
                return;
            }
        }else{
            list.offer(root.val);
        }
        inorder(list,root.right,target,k);
        return;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
