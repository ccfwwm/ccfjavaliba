package leetcode.editor.cn;

import com.company.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

public class LC637AverageOfLevelsInBinaryTree {
    public static void main(String[] args) {
     Solution solution = new LC637AverageOfLevelsInBinaryTree().new Solution();
    }
/**
  * 题目Id：637
  * 题目：二叉树的层平均值
  * 日期：2021-03-24 20:11:38
*/
//给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。 
//
// 
//
// 示例 1： 
//
// 输入：
//    3
//   / \
//  9  20
//    /  \
//   15   7
//输出：[3, 14.5, 11]
//解释：
//第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
// 
//
// 
//
// 提示： 
//
// 
// 节点值的范围在32位有符号整数范围内。 
// 
// Related Topics 树 
// 👍 247 👎 0

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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Double sum;
        TreeNode node;
        int size;
        while (!queue.isEmpty()){
            size = queue.size();
            sum = 0.0;
            for (int i = 0; i < size; i++) {
               node = queue.poll();
               if(node.left!=null)
                   queue.add(node.left);
               if(node.right!=null)
                   queue.add(node.right);
               sum+=node.val;
            }
            sum = sum/size;
            list.add(sum);
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}