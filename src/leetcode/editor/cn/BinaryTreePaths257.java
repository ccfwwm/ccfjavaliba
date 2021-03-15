/**
  * 题目Id：257
  * 题目：二叉树的所有路径
  * 日期：2021-03-14 16:39:37
*/
//给定一个二叉树，返回所有从根节点到叶子节点的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3 
// Related Topics 树 深度优先搜索 
// 👍 464 👎 0

package leetcode.editor.cn;

import com.company.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePaths257{
    public static void main(String[] args) {
        Solution solution = new BinaryTreePaths257().new Solution();
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
        List<String> resAll = new LinkedList<>();
        StringBuffer curStr = new StringBuffer();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null){
            return new LinkedList<>();
        }
         resAll = new LinkedList<>();
         curStr = new StringBuffer();
        findAllPaths(root);
        return  resAll;
    }
    private void findAllPaths(TreeNode root){
        curStr.append(root.val);
          int rootLength= Integer.toString(root.val).length();
     //     System.out.println("rootLength="+rootLength);
        if(root.left ==null && root.right ==null){
           resAll.add(curStr.toString());
           curStr.delete(curStr.length()-rootLength,curStr.length());
           return;
        }
        curStr.append("->");
        if(root.left !=null){
           findAllPaths(root.left);
        }
        if(root.right !=null){
            findAllPaths(root.right);
        }

        curStr.delete(curStr.length()-rootLength-2>0?curStr.length()-rootLength-2:0,curStr.length());
        return;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
