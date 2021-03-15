/**
  * 题目Id：255
  * 题目：验证前序遍历序列二叉搜索树
  * 日期：2021-03-14 13:53:44
*/
//给定一个整数数组，你需要验证它是否是一个二叉搜索树正确的先序遍历序列。 
//
// 你可以假定该序列中的数都是不相同的。 
//
// 参考以下这颗二叉搜索树： 
//
//      5
//    / \
//   2   6
//  / \
// 1   3 
//
// 示例 1： 
//
// 输入: [5,2,6,1,3]
//输出: false 
//
// 示例 2： 
//
// 输入: [5,2,1,3,6]
//输出: true 
//
// 进阶挑战： 
//
// 您能否使用恒定的空间复杂度来完成此题？ 
// Related Topics 栈 树 
// 👍 83 👎 0

package leetcode.editor.cn;

import java.util.Stack;

public class VerifyPreorderSequenceInBinarySearchTree255{
    public static void main(String[] args) {
        Solution solution = new VerifyPreorderSequenceInBinarySearchTree255().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack();
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < preorder.length; i++) {
           if(preorder[i]<min){
               return false;
           }
           while (!stack.isEmpty() &&preorder[i]>stack.peek()){
              min = stack.pop();
           }
           stack.push(preorder[i]);
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
