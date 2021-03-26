package leetcode.editor.cn;

import com.company.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LC652FindDuplicateSubtrees {
    public static void main(String[] args) {
     Solution solution = new LC652FindDuplicateSubtrees().new Solution();
    }
/**
  * 题目Id：652
  * 题目：寻找重复的子树
  * 日期：2021-03-24 22:12:34
*/
//给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。 
//
// 两棵树重复是指它们具有相同的结构以及相同的结点值。 
//
// 示例 1： 
//
//         1
//       / \
//      2   3
//     /   / \
//    4   2   4
//       /
//      4
// 
//
// 下面是两个重复的子树： 
//
//       2
//     /
//    4
// 
//
// 和 
//
//     4
// 
//
// 因此，你需要以列表的形式返回上述重复子树的根结点。 
// Related Topics 树 
// 👍 250 👎 0

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
    HashMap<String,Integer> map = new HashMap<>();
    List<TreeNode> res = new LinkedList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return res;
    }

    private String dfs(TreeNode root){
       if(root ==null){
           return "#";
       }
        StringBuilder sb = new StringBuilder();
       String left = dfs(root.left);
        String right = dfs(root.right);
        sb.append(left).append(",").append(right).append(",").append(root.val);
        int num  = map.getOrDefault(sb.toString(),0);
        if(num ==1){
            res.add(root);
        }
        map.put(sb.toString(),num+1);
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}