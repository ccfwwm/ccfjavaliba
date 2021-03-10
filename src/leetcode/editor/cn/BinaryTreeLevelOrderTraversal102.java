/**
  * 题目Id：102
  * 题目：二叉树的层序遍历
  * 日期：2021-03-07 19:16:26
*/
//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层序遍历结果： 
//
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 798 👎 0

package leetcode.editor.cn;

import com.company.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal102{
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversal102().new Solution();
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
    public List<List<Integer>> levelOrder(TreeNode root) {
            if( root == null){
                return new LinkedList<>();
            }
            List<List<Integer>>  allTree = new LinkedList<>();
            List<Integer> currDep;
            Queue<TreeNode> cur = new LinkedList();
            cur.offer(root);
            while (!cur.isEmpty()){
                currDep = new LinkedList<>();
                int size = cur.size();
                for (int i = 0; i < size; i++) {
                   if(cur.element().left !=null){
                       cur.offer(cur.element().left);
                   }
                    if(cur.element().right !=null){
                        cur.offer(cur.element().right);
                    }
                    currDep.add(cur.poll().val);
                }
                allTree.add(currDep);
            }
            return allTree;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
