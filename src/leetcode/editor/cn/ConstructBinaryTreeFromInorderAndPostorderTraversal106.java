/**
  * 题目Id：106
  * 题目：从中序与后序遍历序列构造二叉树
  * 日期：2021-03-09 22:13:13
*/
//根据一棵树的中序遍历与后序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 深度优先搜索 数组 
// 👍 457 👎 0

package leetcode.editor.cn;

import com.company.TreeNode;

import java.util.HashMap;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal106{
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal106().new Solution();
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
    HashMap inmap = new HashMap<Integer, Integer>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        for (int i = 0; i < inorder.length; i++) {
            inmap.put(inorder[i],i);
        }
        return dfs(postorder,postorder.length-1,0,inorder,0,inorder.length-1);

    }
    private TreeNode dfs(int[] postorder, int p_start, int p_end, int[] inorder, int i_start, int i_end){
        if(p_start<p_end || i_start>i_end){
            return null;
        }
        int root_val = postorder[p_start];
        TreeNode root = new TreeNode(root_val);
        int i_root_index = (int)inmap.get(root_val);
        int rightNum = i_end-i_root_index;
        root.right = dfs(postorder,p_start-1,p_start-rightNum-1,inorder,i_root_index+1,i_end);
        root.left = dfs(postorder,p_start- rightNum-1,p_end,inorder,i_start,i_root_index-1);
        return root;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
