package leetcode.editor.cn;

import com.company.TreeNode;
import org.w3c.dom.Node;

import java.util.TreeMap;

public class DeleteNodeInABst450{
    public static void main(String[] args) {
     Solution solution = new DeleteNodeInABst450().new Solution();
    }
/**
  * 题目Id：450
  * 题目：删除二叉搜索树中的节点
  * 日期：2021-03-19 09:43:19
*/
//给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的
//根节点的引用。 
//
// 一般来说，删除节点可分为两个步骤： 
//
// 
// 首先找到需要删除的节点； 
// 如果找到了，删除它。 
// 
//
// 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。 
//
// 示例: 
//
// 
//root = [5,3,6,2,4,null,7]
//key = 3
//
//    5
//   / \
//  3   6
// / \   \
//2   4   7
//
//给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
//
//一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
//
//    5
//   / \
//  4   6
// /     \
//2       7
//
//另一个正确答案是 [5,2,6,null,4,null,7]。
//
//    5
//   / \
//  2   6
//   \   \
//    4   7
// 
// Related Topics 树 
// 👍 412 👎 0

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
    //分三种情况
    public TreeNode deleteNode(TreeNode root, int key) {
       if(root ==null){
           return null;
       }
       //key小于root,则左子树
       if(root.val>key){
           root.left = deleteNode(root.left,key);
       }else if(root.val<key){
           //key大于root,则右子树
           root.right = deleteNode(root.right,key);
       }else {
           //root == key,分三种情况，无左返右，无右返左，有右有左则左接右最小，返右。
           if(root.left ==null){
               return root.right;
           }
           if(root.right ==null){
               return root.left;
           }

           //左接右最小，返右
           TreeNode pre = root.right;
           while (pre.left!=null){
               pre = pre.left;
           }
           pre.left = root.left;
           return root.right;
       }

       return root;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}