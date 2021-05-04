package leetcode.editor.cn;
//给你一个 m x n 的矩阵 matrix 和一个整数 k ，找出并返回矩阵内部矩形区域的不超过 k 的最大数值和。 
//
// 题目数据保证总会存在一个数值和不超过 k 的矩形区域。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,0,1],[0,-2,3]], k = 2
//输出：2
//解释：蓝色边框圈出来的矩形区域 [[0, 1], [-2, 3]] 的数值和是 2，且 2 是不超过 k 的最大数字（k = 2）。
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[2,2,-1]], k = 3
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -100 <= matrix[i][j] <= 100 
// -105 <= k <= 105 
// 
//
// 
//
// 进阶：如果行数远大于列数，该如何设计解决方案？ 
// Related Topics 队列 二分查找 动态规划 
// 👍 315 👎 0

import java.util.TreeSet;

public class LC363MaxSumOfRectangleNoLargerThanK {
    public static void main(String[] args) {
        Solution solution = new LC363MaxSumOfRectangleNoLargerThanK().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSumSubmatrix(int[][] matrix, int k) {
            int m = matrix.length;
            int n = matrix[0].length;
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i - 1][j - 1];
                }
            }
            int ans = -1000;
            for (int top = 1; top <= m; top++) {
                for (int bottom = top; bottom <= m; bottom++) {
                    TreeSet<Integer> treeSet = new TreeSet<>();
                    treeSet.add(0);
                    for (int r = 1; r <= n; r++) {
                        int right = dp[bottom][r] - dp[top - 1][r];
                        Integer left = treeSet.ceiling(right - k);
                        if (left != null) {
                            //即前面的都大于k，那么left为Null;
                            ans = Math.max(ans, right - left);
                        }
                        treeSet.add(right);
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}




