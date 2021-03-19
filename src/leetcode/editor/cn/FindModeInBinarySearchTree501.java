package leetcode.editor.cn;

import com.company.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class FindModeInBinarySearchTree501 {
    public static void main(String[] args) {
        Solution solution = new FindModeInBinarySearchTree501().new Solution();
    }
/**
 * 题目Id：501
 * 题目：二叉搜索树中的众数
 * 日期：2021-03-19 10:34:35
 */
//给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。 
//
// 假定 BST 有如下定义： 
//
// 
// 结点左子树中所含结点的值小于等于当前结点的值 
// 结点右子树中所含结点的值大于等于当前结点的值 
// 左子树和右子树都是二叉搜索树 
// 
//
// 例如： 
//给定 BST [1,null,2,2], 
//
//    1
//    \
//     2
//    /
//   2
// 
//
// 返回[2]. 
//
// 提示：如果众数超过1个，不需考虑输出顺序 
//
// 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内） 
// Related Topics 树 
// 👍 282 👎 0

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        int countMax;
        int currentCount;
        int pre;
        public int[] findMode(TreeNode root) {
            if (root == null) {
                return new int[]{};
            }
            //第一次遍历
            countMax = 0;
            currentCount = 0;
            pre = root.val;
            inorder(root);
            //第二次遍历
            LinkedList<Integer> ans = new LinkedList<>();
            currentCount = 0;
            pre = root.val;
            inorder(root, ans);
            return listToArray(ans);
        }

        private int[] listToArray(List<Integer> list){
           int size = list.size();
           int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
               arr[i] = list.remove(0);
            }
            return arr;
        }
        private void inorder(TreeNode root) {
            if (root == null) {
                return;
            }
            inorder(root.left);
            if (root.val != pre) {
                currentCount = 0;
            }
            currentCount++;
            if(currentCount>countMax){
                countMax = currentCount;
            }
            pre = root.val;
            inorder(root.right);
        }

        private void inorder(TreeNode root, LinkedList<Integer> list) {
            if (root == null) {
                return;
            }
            inorder(root.left, list);
            if (root.val != pre) {
                currentCount = 0;
            }
            currentCount++;
            //    System.out.println("currentCount="+currentCount);
            //    System.out.println("root1="+root.val);
            if (currentCount >= countMax) {
                //       System.out.println("root="+root.val);
                list.add(root.val);
            }
            pre = root.val;
            inorder(root.right, list);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}