/**
  * 题目Id：156
  * 题目：上下翻转二叉树
  * 日期：2021-03-11 08:19:31
*/
//给定一个二叉树，其中所有的右节点要么是具有兄弟节点（拥有相同父节点的左节点）的叶节点，要么为空，将此二叉树上下翻转并将它变成一棵树， 原来的右节点将转换成左
//叶节点。返回新的根。 
//
// 例子: 
//
// 输入: [1,2,3,4,5]
//
//    1
//   / \
//  2   3
// / \
//4   5
//
//输出: 返回二叉树的根 [4,5,2,#,#,3,1]
//
//   4
//  / \
// 5   2
//    / \
//   3   1  
// 
//
// 说明: 
//
// 对 [4,5,2,#,#,3,1] 感到困惑? 下面详细介绍请查看 二叉树是如何被序列化的。 
//
// 二叉树的序列化遵循层次遍历规则，当没有节点存在时，'#' 表示路径终止符。 
//
// 这里有一个例子: 
//
//    1
//  / \
// 2   3
//    /
//   4
//    \
//     5
// 
//
// 上面的二叉树则被序列化为 [1,2,3,#,#,4,#,#,5]. 
// Related Topics 树 
// 👍 62 👎 0

package leetcode.editor.cn;

import com.company.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreeUpsideDown156{
    public static void main(String[] args) {
        Solution solution = new BinaryTreeUpsideDown156().new Solution();
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
//    ArrayList<TreeNode> allTree  = new ArrayList<>();
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null ||(root.left == null && root.right == null)){
           return root;
        }
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;

        //根或子树的root变为右叶节点
        root.left = null;
        root.right =null;

        return newRoot;


    }
//        if(root ==null){
//            return null;
//        }
//        prefs(root);
//
//        int size = allTree.size()-1;
//        for (int i = 0; i <=size; i++) {
//            TreeNode test = allTree.get(i);
//            if(test !=null) {
//                System.out.println("allltree" + i + "=" + allTree.get(i).val);
//            }else {
//
//                System.out.println("allltree" + i + "=null" );
//            }
//        }
//        while (allTree.get(size) == null){
//            size --;
//        }
//        return posfs(0,size);

//    }
//    private TreeNode posfs(int index,int size){
//        if(index>size){
//            return null;
//        }
//        TreeNode root = allTree.get(index);
//        if(root !=null) {
//            root.left = posfs(index + 1, size);
//            root.right = posfs(index + 2, size);
//        }
//        return root;
//    }
//
//
//    private void prefs(TreeNode root){
//        if(root == null){
//           allTree.add(null);
//           return;
//        }
//        prefs(root.left);
//        prefs(root.right);
//        allTree.add(root);
//       return;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
