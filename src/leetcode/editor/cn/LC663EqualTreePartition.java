package leetcode.editor.cn;

import com.company.TreeNode;

import java.util.*;

public class LC663EqualTreePartition {
    public static void main(String[] args) {
     Solution solution = new LC663EqualTreePartition().new Solution();
    }
/**
  * 题目Id：663
  * 题目：均匀树划分
  * 日期：2021-03-25 23:36:40
*/
//给定一棵有 n 个结点的二叉树，你的任务是检查是否可以通过去掉树上的一条边将树分成两棵，且这两棵树结点之和相等。 
//
// 样例 1: 
//
// 输入:     
//    5
//   / \
//  10 10
//    /  \
//   2   3
//
//输出: True
//解释: 
//    5
//   / 
//  10
//      
//和: 15
//
//   10
//  /  \
// 2    3
//
//和: 15
// 
//
// 
//
// 样例 2: 
//
// 输入:     
//    1
//   / \
//  2  10
//    /  \
//   2   20
//
//输出: False
//解释: 无法通过移除一条树边将这棵树划分成结点之和相等的两棵子树。
// 
//
// 
//
// 注释 : 
//
// 
// 树上结点的权值范围 [-100000, 100000]。 
// 1 <= n <= 10000 
// 
//
// 
// Related Topics 树 
// 👍 31 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<Integer> list = new ArrayList<>();
    public boolean checkEqualTree(TreeNode root) {
        if(root==null){
            return false;
        }
      int allSum =  dfs(root);
        if(allSum %2 !=0){
            return false;
        }
        //root在最后，求子树，root不能算
        list.remove(list.size()-1);
        //总和的一半
        return list.contains(allSum/2);
    }
    private int dfs(TreeNode root){
        int sum = root.val;
        if(root.left!=null){
            sum+=dfs(root.left);
        }
        if(root.right!=null){
            sum+=dfs(root.right);
        }
        list.add(sum);
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}