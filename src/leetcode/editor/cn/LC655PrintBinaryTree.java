package leetcode.editor.cn;

import com.company.TreeNode;
import jdk.jshell.spi.SPIResolutionException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC655PrintBinaryTree {
    public static void main(String[] args) {
        Solution solution = new LC655PrintBinaryTree().new Solution();
    }
/**
 * 题目Id：655
 * 题目：输出二叉树
 * 日期：2021-03-25 23:34:23
 */
//在一个 m*n 的二维字符串数组中输出二叉树，并遵守以下规则： 
//
// 
// 行数 m 应当等于给定二叉树的高度。 
// 列数 n 应当总是奇数。 
// 根节点的值（以字符串格式给出）应当放在可放置的第一行正中间。根节点所在的行与列会将剩余空间划分为两部分（左下部分和右下部分）。你应该将左子树输出在左下部分
//，右子树输出在右下部分。左下和右下部分应当有相同的大小。即使一个子树为空而另一个非空，你不需要为空的子树输出任何东西，但仍需要为另一个子树留出足够的空间。然而，
//如果两个子树都为空则不需要为它们留出任何空间。 
// 每个未使用的空间应包含一个空的字符串""。 
// 使用相同的规则输出子树。 
// 
//
// 示例 1: 
//
// 
//输入:
//     1
//    /
//   2
//输出:
//[["", "1", ""],
// ["2", "", ""]]
// 
//
// 示例 2: 
//
// 
//输入:
//     1
//    / \
//   2   3
//    \
//     4
//输出:
//[["", "", "", "1", "", "", ""],
// ["", "2", "", "", "", "3", ""],
// ["", "", "4", "", "", "", ""]]
// 
//
// 示例 3: 
//
// 
//输入:
//      1
//     / \
//    2   5
//   / 
//  3 
// / 
//4 
//输出:
//[["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
// ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
// ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
// ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
// 
//
// 注意: 二叉树的高度在范围 [1, 10] 中。 
// Related Topics 树 
// 👍 97 👎 0

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
        public List<List<String>> printTree(TreeNode root) {
            int height = getDepth(root);
            int width = (1<<height) - 1;
            List<List<String>> res = new ArrayList<>(height);
            List<String> ans = new ArrayList<>();
            for (int i = 0; i < width; i++) {
                ans.add("");
            }
            dfs(root, res, ans, 1, 0, width - 1);
            return res;
        }
        private void dfs(TreeNode root, List<List<String>> res, List<String> ans, int depth, int left, int right) {
            if (root == null) {
                return;
            }
            if (res.size() < depth) {
                res.add(new ArrayList<>(ans));
            }
            int index = (left + right) / 2;
            res.get(depth - 1).set(index, Integer.toString(root.val));
            dfs(root.left, res, ans, depth + 1, left, index - 1);
            dfs(root.right, res, ans, depth + 1, index + 1, right);
        }

        private int getDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return Math.max(getDepth(root.left), getDepth(root.right))+1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}












