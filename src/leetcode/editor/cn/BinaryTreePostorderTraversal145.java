/**
  * 题目Id：145
  * 题目：二叉树的后序遍历
  * 日期：2021-03-10 22:15:55
*/
//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 538 👎 0

package leetcode.editor.cn;

import com.company.TreeNode;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePostorderTraversal145{
    public static void main(String[] args) {
        Solution solution = new BinaryTreePostorderTraversal145().new Solution();
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
    List<Integer> postList = new LinkedList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
            if(root == null){
                return postList;
            }
            dfs(root);
            return postList;
    }
    private void dfs(TreeNode root){
        if(root ==null){
            return;
        }
        dfs(root.left);
        dfs(root.right);
        postList.add(root.val);
        return;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
