package leetcode.editor.cn;

import com.company.TreeNode;

import java.util.HashMap;

public class PathSumIii437{
    public static void main(String[] args) {
     Solution solution = new PathSumIii437().new Solution();
    }
/**
  * 题目Id：437
  * 题目：路径总和 III
  * 日期：2021-03-17 09:19:07
*/
//给定一个二叉树，它的每个结点都存放着一个整数值。 
//
// 找出路径和等于给定数值的路径总数。 
//
// 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。 
//
// 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。 
//
// 示例： 
//
// root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
//
//      10
//     /  \
//    5   -3
//   / \    \
//  3   2   11
// / \   \
//3  -2   1
//
//返回 3。和等于 8 的路径有:
//
//1.  5 -> 3
//2.  5 -> 2 -> 1
//3.  -3 -> 11
// 
// Related Topics 树 
// 👍 778 👎 0

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
    HashMap<Integer,Integer> prefixMap;
    int target;
    public int pathSum(TreeNode root, int sum) {
       target = sum;
       prefixMap = new HashMap<>();
       prefixMap.put(0,1);
        return helper(root,0);
    }

    private int helper(TreeNode root,int curSum){
        if(root ==null){
            return 0;
        }
        curSum+=root.val;
        //curSum-target 顺序不能变，掉头就不行,因为curSum是当前和，target是目标，定义是当前节点减去target的节点数
        int res = prefixMap.getOrDefault(curSum-target,0);
        prefixMap.put(curSum,prefixMap.getOrDefault(curSum,0)+1);
        int left =helper(root.left,curSum);
        int right = helper(root.right,curSum);
        res = res+left+right;
        prefixMap.put(curSum, prefixMap.get(curSum)-1);
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}











