package leetcode.editor.cn;

import com.company.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC894AllPossibleFullBinaryTrees {
    public static void main(String[] args) {
        Solution solution = new LC894AllPossibleFullBinaryTrees().new Solution();
    }
/**
 * 题目Id：894
 * 题目：所有可能的满二叉树
 * 日期：2021-04-06 16:03:37
 */
//满二叉树是一类二叉树，其中每个结点恰好有 0 或 2 个子结点。 
//
// 返回包含 N 个结点的所有可能满二叉树的列表。 答案的每个元素都是一个可能树的根结点。 
//
// 答案中每个树的每个结点都必须有 node.val=0。 
//
// 你可以按任何顺序返回树的最终列表。 
//
// 
//
// 示例： 
//
// 输入：7
//输出：[[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0
//,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
//解释：
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= N <= 20 
// 
// Related Topics 树 递归 
// 👍 187 👎 0

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
        public List<TreeNode> allPossibleFBT(int n) {
            List<TreeNode> list = new ArrayList<>();
            dfs(list, n);
            return list;
        }

        private void dfs(List<TreeNode> list, int N) {
            if(N%2==0){
                return;
            }
            if(N==1){
                list.add(new TreeNode(0));
                return;
            }else {
                for(int i =1;i<N-1;i+=2){
                    List<TreeNode> l = new ArrayList<>();
                    List<TreeNode> r = new ArrayList<>();
                    dfs(l,i);
                    dfs(r,N-i-1);
                    for(TreeNode left:l){
                        for(TreeNode right:r){
                            TreeNode root = new TreeNode(0);
                            root.left = left;
                            root.right = right;
                            list.add(root);
                        }
                    }
                }
            }


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}