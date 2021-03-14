/**
  * 题目Id：113
  * 题目：路径总和 II
  * 日期：2021-03-10 10:15:12
*/
//给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：[[5,4,11,2],[5,8,4,5]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,3], targetSum = 5
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], targetSum = 0
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点总数在范围 [0, 5000] 内 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
// 
// 
// Related Topics 树 深度优先搜索 
// 👍 438 👎 0

package leetcode.editor.cn;

import com.company.TreeNode;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSumIi113{
    public static void main(String[] args) {
        Solution solution = new PathSumIi113().new Solution();
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
    List<List<Integer>>  allPath = new LinkedList<>();
    LinkedList<Integer> currPath = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return  allPath;
    }
    private void dfs(TreeNode root, int targetSum){
        //如果root为null，返回fasle
        if(root == null){
            return;
        }
        //如果root为叶节点，则判断root.val等于targetSum,则添加list,否则返回;
        if(root.left == null && root.right ==null){
            if(root.val == targetSum){
               currPath.add(root.val);
//               printList(currPath);
               allPath.add((List<Integer>) currPath.clone());
               currPath.removeLast();
            }
            return;
        }
        //做选择
        currPath.add(root.val);
//        printList(currPath);
        dfs(root.left,targetSum-root.val);
        dfs(root.right,targetSum-root.val);
        //撤销选择
        currPath.removeLast();
//        printList(currPath);
    }

//    private void printList(LinkedList<Integer> list){
//        for (int i = 0; i < list.size(); i++) {
//           System.out.print(list.get(i)+" ");
//        }
//        System.out.println();
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
