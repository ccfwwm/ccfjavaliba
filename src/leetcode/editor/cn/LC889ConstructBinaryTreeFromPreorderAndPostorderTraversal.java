package leetcode.editor.cn;

import com.company.TreeNode;

import java.util.HashMap;

public class LC889ConstructBinaryTreeFromPreorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new LC889ConstructBinaryTreeFromPreorderAndPostorderTraversal().new Solution();
    }
/**
 * 题目Id：889
 * 题目：根据前序和后序遍历构造二叉树
 * 日期：2021-04-01 09:50:46
 */
//返回与给定的前序和后序遍历匹配的任何二叉树。 
//
// pre 和 post 遍历中的值是不同的正整数。 
//
// 
//
// 示例： 
//
// 输入：pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
//输出：[1,2,3,4,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= pre.length == post.length <= 30 
// pre[] 和 post[] 都是 1, 2, ..., pre.length 的排列 
// 每个输入保证至少有一个答案。如果有多个答案，可以返回其中一个。 
// 
// Related Topics 树 
// 👍 149 👎 0

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        private HashMap<Integer, Integer> map;
        public TreeNode constructFromPrePost(int[] pre, int[] post) {
            map = initMap(post);
            return dfs(pre,0,pre.length-1,0);
        }

        private TreeNode dfs(int[] pre,int preStart,int preEnd,int postStart){
           if(preStart>preEnd){
               return null;
           }
           TreeNode root = new TreeNode(pre[preStart]);
           if(preStart+1<=preEnd){
               int index = map.get(pre[preStart+1]);
               root.left= dfs(pre,preStart+1,preStart+index-postStart+1,postStart);
               root.right= dfs(pre,preStart+index-postStart+2,preEnd,index+1);
           }
           return root;
        }
        private HashMap<Integer, Integer> initMap(int[] arr) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                map.put(arr[i], i);
            }
            return map;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}




