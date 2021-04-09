package leetcode.editor.cn;

import com.company.TreeNode;

public class LC968BinaryTreeCameras {
    public static void main(String[] args) {
     Solution solution = new LC968BinaryTreeCameras().new Solution();
    }
/**
  * 题目Id：968
  * 题目：监控二叉树
  * 日期：2021-04-07 16:52:37
*/
//给定一个二叉树，我们在树的节点上安装摄像头。 
//
// 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。 
//
// 计算监控树的所有节点所需的最小摄像头数量。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：[0,0,null,0,0]
//输出：1
//解释：如图所示，一台摄像头足以监控所有节点。
// 
//
// 示例 2： 
//
// 
//
// 输入：[0,0,null,0,null,0,null,null,0]
//输出：2
//解释：需要至少两个摄像头来监视树的所有节点。 上图显示了摄像头放置的有效位置之一。
// 
//
// 
//提示： 
//
// 
// 给定树的节点数的范围是 [1, 1000]。 
// 每个节点的值都是 0。 
// 
// Related Topics 树 深度优先搜索 动态规划 
// 👍 273 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int res=0;
    public int minCameraCover(TreeNode root) {
        if(dfs(root)==0){
            res++;
        }
        return res;


    }
    /*
    dfs返回节点的状态
    0:未被摄像头照到（覆盖）
    1：被摄像头照到（覆盖）
    2：放置了摄像头

    */
    public int dfs(TreeNode root){
        /*为了保证摄像头数目最小，叶子节点不能放置摄像头。
        所以root是null时，设置其状态是已覆盖。*/
        if(root==null){
            return 1;
        }

        int left=dfs(root.left);
        int right=dfs(root.right);
        // 左右孩子一共有 00,01,02,11,12,22 这些状态


        // 包含了 00 01 02 状态，左右孩子只要有一个未被覆盖，root就需要放置摄像头
        if(left==0||right==0){
            res++;
            return 2;
        }

        // 11状态  root需要被父节点的摄像头覆盖，设置root的状态是0
        if(left==1&&right==1){
            return 0;
        }

        //12 22状态，root被儿子覆盖 设置root的状态是1
        if(left+right>=3){
            return  1;
        }
        // 所有的状态都已经被包含，这里随便返回一个值
        return 0;

    }
}


//leetcode submit region end(Prohibit modification and deletion)

}