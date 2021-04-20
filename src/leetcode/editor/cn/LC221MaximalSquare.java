package leetcode.editor.cn;
//在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：matrix = [["0","1"],["1","0"]]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 300 
// matrix[i][j] 为 '0' 或 '1' 
// 
// Related Topics 动态规划 
// 👍 741 👎 0

public class LC221MaximalSquare {
    public static void main(String[] args) {
        Solution solution = new LC221MaximalSquare().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximalSquare(char[][] matrix) {
            if (matrix.length < 1) {
                return 0;
            }
            int m = matrix.length;
            int n = matrix[0].length;
            int[][] dp = new int[m][n];
            int max = 0;
            for (int i = 0; i < m; i++) {
                dp[i][0] = matrix[i][0] == '0' ? 0 : 1;
                max = max > dp[i][0] ? max : dp[i][0];
            }
            for (int i = 1; i < n; i++) {
                dp[0][i] = matrix[0][i] == '0' ? 0 : 1;
                max = max > dp[0][i] ? max : dp[0][i];
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = matrix[i][j] == '0' ? 0 : 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                    max = max > dp[i][j] ? max : dp[i][j];
                }
            }
            return max * max;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}