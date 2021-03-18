package leetcode.editor.cn;

import com.company.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLeavesOfBinaryTree366{
    public static void main(String[] args) {
     Solution solution = new FindLeavesOfBinaryTree366().new Solution();
    }
/**
  * 题目Id：366
  * 题目：寻找二叉树的叶子节点
  * 日期：2021-03-15 17:18:15
*/
//给你一棵二叉树，请按以下要求的顺序收集它的全部节点： 
//
// 
// 依次从左到右，每次收集并删除所有的叶子节点 
// 重复如上过程直到整棵树为空 
// 
//
// 
//
// 示例: 
//
// 输入: [1,2,3,4,5]
//  
//          1
//         / \
//        2   3
//       / \     
//      4   5    
//
//输出: [[4,5,3],[2],[1]]
// 
//
// 
//
// 解释: 
//
// 1. 删除叶子节点 [4,5,3] ，得到如下树结构： 
//
//           1
//         / 
//        2          
// 
//
// 
//
// 2. 现在删去叶子节点 [2] ，得到如下树结构： 
//
//           1          
// 
//
// 
//
// 3. 现在删去叶子节点 [1] ，得到空树： 
//
//           []         
// 
// Related Topics 树 深度优先搜索 
// 👍 103 👎 0

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
    List<List<Integer>> res;
    public List<List<Integer>> findLeaves(TreeNode root) {
        if(root ==null){
            return null;
        }
        res = new LinkedList<>();
        dfs(root);
        return  res;

    }
    private int dfs(TreeNode root){
        if(root ==null){
            return 0;
        }
        int leftDepth = dfs(root.left);
        int rightDepth = dfs(root.right);
        //判断左右深度，叶节点maxDepth=1,根节点最大，从左至右，从下往上，依次遍历添加
        int maxDepth = Math.max(leftDepth,rightDepth)+1;
        if(res.size() == maxDepth-1){
            res.add(new LinkedList<>());
        }
        res.get(maxDepth-1).add(root.val);
        return maxDepth;
    }

}
//    private void levelOrder(TreeNode root,List<Integer> list){
//        if(root == null){
//            return;
//        }
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        while (!queue.isEmpty()){
//            int size = queue.size();
//            TreeNode curNode;
//            for (int i = 0; i < size; i++) {
//                curNode = queue.poll();
//                if(curNode.right!=null && curNode.right.right==null && curNode.right.left==null){
//                 //   System.out.println("curNode = "+curNode.right.val);
//                    list.add(0,curNode.right.val);
//                    curNode.right = null;
//                }
//                if(curNode.left!=null && curNode.left.right==null && curNode.left.left==null){
//             //       System.out.println("curNode = "+curNode.left.val);
//                    list.add(0,curNode.left.val);
//                    curNode.left = null;
//                }
//                if(curNode.right!=null){
//                    queue.offer(curNode.right);
//                }
//                if(curNode.left!=null){
//                    queue.offer(curNode.left);
//                }
//            }
//        }
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)

}