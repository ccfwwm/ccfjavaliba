package leetcode.editor.cn;

import com.company.TreeNode;

import java.util.TreeMap;

public class LC536ConstructBinaryTreeFromString {
    public static void main(String[] args) {
     Solution solution = new LC536ConstructBinaryTreeFromString().new Solution();
    }
/**
  * 题目Id：536
  * 题目：从字符串生成二叉树
  * 日期：2021-03-20 13:19:02
*/
//你需要从一个包括括号和整数的字符串构建一棵二叉树。 
//
// 输入的字符串代表一棵二叉树。它包括整数和随后的 0 ，1 或 2 对括号。整数代表根的值，一对括号内表示同样结构的子树。 
//
// 若存在左子结点，则从左子结点开始构建。 
//
// 
//
// 示例： 
//
// 输入："4(2(3)(1))(6(5))"
//输出：返回代表下列二叉树的根节点:
//
//       4
//     /   \
//    2     6
//   / \   / 
//  3   1 5   
// 
//
// 
//
// 提示： 
//
// 
// 输入字符串中只包含 '(', ')', '-' 和 '0' ~ '9' 
// 空树由 "" 而非"()"表示。 
// 
//
// 
// Related Topics 树 字符串 
// 👍 56 👎 0

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
    //全局变量，控制索引
    int index = 0;
    public TreeNode str2tree(String s) {
        //字符串为空或者长度小于1，则返回null,必须考虑s=“”的情况
        if(s ==null| s.length()<1){
            return null;
        }
        return dfs(s);
    }
    private TreeNode dfs(String str){
        //局部变量，控制索引
        int i = index;
        //积累数字
        while (str.charAt(i)>='0' && str.charAt(i)<='9' || str.charAt(i) == '-'){
            i++;
            if(i>=str.length()){
                break;
            }
        }
        //构造当前树
        TreeNode root = new TreeNode();
        root.val = Integer.parseInt(str.substring(index,i));
        index = i;
        //构造左子树
        if(index<str.length()&& str.charAt(index) == '('){
            index++;
            root.left = dfs(str);
        }
        //构造右子树
        if(index<str.length()&& str.charAt(index) == '('){
            index++;
            root.right = dfs(str);
        }
        //索引+1
        if(index<str.length()&& str.charAt(index) == ')'){
           index++;
        }
        //返回当前root
        return root;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}