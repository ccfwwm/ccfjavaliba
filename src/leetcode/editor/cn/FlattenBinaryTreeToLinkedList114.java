/**
  * 题目Id：114
  * 题目：二叉树展开为链表
  * 日期：2021-03-10 11:18:31
*/
//给你二叉树的根结点 root ，请你将它展开为一个单链表： 
//
// 
// 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。 
// 展开后的单链表应该与二叉树 先序遍历 顺序相同。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,5,3,4,null,6]
//输出：[1,null,2,null,3,null,4,null,5,null,6]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 树中结点数在范围 [0, 2000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？ 
// Related Topics 树 深度优先搜索 
// 👍 745 👎 0

package leetcode.editor.cn;

import com.company.TreeNode;

public class FlattenBinaryTreeToLinkedList114{
    public static void main(String[] args) {
        Solution solution = new FlattenBinaryTreeToLinkedList114().new Solution();
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
    public void flatten(TreeNode root) {
         dfs(root);
    }
    private TreeNode dfs(TreeNode root){
        //节点为空返回null
        if( root == null){
            return null;
        }
        //左节点,先序遍历
        TreeNode left = dfs(root.left);
        //右节点
        TreeNode right = dfs(root.right);
        //右节点接左节点
        root.right = left;
        TreeNode maxRight = root;
        while (maxRight.right != null){
           maxRight = maxRight.right;
        }
        //原本的右节点接到末尾，
        maxRight.right = right;
        //左节点置为null
        root.left = null;
        //返回根节点
        return root;
        //如此反复即可
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
