package leetcode.editor.cn;
//给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2) 。 
//
// 
//上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。 
//
// 
//
// 示例： 
//
// 
//给定 matrix = [
//  [3, 0, 1, 4, 2],
//  [5, 6, 3, 2, 1],
//  [1, 2, 0, 1, 5],
//  [4, 1, 0, 1, 7],
//  [1, 0, 3, 0, 5]
//]
//
//sumRegion(2, 1, 4, 3) -> 8
//sumRegion(1, 1, 2, 2) -> 11
//sumRegion(1, 2, 2, 4) -> 12
// 
//
// 
//
// 提示： 
//
// 
// 你可以假设矩阵不可变。 
// 会多次调用 sumRegion 方法。 
// 你可以假设 row1 ≤ row2 且 col1 ≤ col2 。 
// 
// Related Topics 动态规划 
// 👍 252 👎 0

public class LC304RangeSumQuery2dImmutable {
    public static void main(String[] args) {
        Solution solution = new LC304RangeSumQuery2dImmutable().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class NumMatrix {
        private int[][] dp;

        public NumMatrix(int[][] matrix) {
            if (matrix.length > 0) {
                int m = matrix.length;
                int n = matrix[0].length;
                dp = new int[m + 1][n + 1];
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        dp[i + 1][j + 1] = matrix[i][j] + dp[i + 1][j] + dp[i][j + 1] - dp[i][j];
//                  System.out.print(" "+dp[i+1][j+1]);
                    }
//               System.out.println();
                }
            }

        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (dp == null) {
                return 0;
            }
            return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
        }
    }

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
//leetcode submit region end(Prohibit modification and deletion)

}