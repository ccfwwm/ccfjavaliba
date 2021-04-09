package leetcode.editor.cn;

import com.company.TreeNode;

import javax.swing.text.TabableView;
import java.util.*;

public class LC863AllNodesDistanceKInBinaryTree {
    public static void main(String[] args) {
        Solution solution = new LC863AllNodesDistanceKInBinaryTree().new Solution();
    }
/**
 * 题目Id：863
 * 题目：二叉树中所有距离为 K 的结点
 * 日期：2021-03-30 19:38:00
 */
//给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。 
//
// 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
//输出：[7,4,1]
//解释：
//所求结点为与目标结点（值为 5）距离为 2 的结点，
//值分别为 7，4，以及 1
//
//
//
//注意，输入的 "root" 和 "target" 实际上是树上的结点。
//上面的输入仅仅是对这些对象进行了序列化描述。
// 
//
// 
//
// 提示： 
//
// 
// 给定的树是非空的。 
// 树上的每个结点都具有唯一的值 0 <= node.val <= 500 。 
// 目标结点 target 是树上的结点。 
// 0 <= K <= 1000. 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 261 👎 0

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
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> list = new LinkedList<>();
        HashSet<Integer> seen = new HashSet<>();

        public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
            if (K == 0) {
                list.add(target.val);
                return list;
            }
            if (root.left == null && root.right == null) {
                return list;
            }
            initMap(root.left,root);
            initMap(root.right,root);
            seen.add(target.val);
            findK(target.val, K);
            return list;
        }

        private void findK(int rootVal, int depth) {
            if (depth < 0) {
                return;
            }
            if (depth == 0) {
                list.add(rootVal);
                return;
            }
            for (int curVal : map.get(rootVal)) {
                if (!seen.contains(curVal)) {
                    seen.add(curVal);
                    findK(curVal, depth - 1);
                }
            }
        }

        private void initMap(TreeNode root,TreeNode parent) {
            if (root == null) {
                return;
            }
            if (!map.containsKey(root.val)) {
                map.put(root.val, new LinkedList<Integer>());
            }
            if (!map.containsKey(parent.val)) {
                map.put(parent.val, new LinkedList<Integer>());
            }
            map.get(root.val).add(parent.val);
            map.get(parent.val).add(root.val);
            initMap(root.left,root);
            initMap(root.right,root);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}



















