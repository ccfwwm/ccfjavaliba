package leetcode.editor.cn;

import javax.print.DocFlavor;
import java.util.Stack;

public class LC85MaximalRectangle {
    public static void main(String[] args) {
        Solution solution = new LC85MaximalRectangle().new Solution();
    }

    /**
     * 题目Id：85
     * 题目：最大矩形
     * 日期：2021-04-13 14:27:36
     */
//给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：6
//解释：最大矩形如上图所示。
// 
//
// 示例 2： 
//
// 
//输入：matrix = []
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：matrix = [["1"]]
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：matrix = [["0","0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// rows == matrix.length 
// cols == matrix[0].length 
// 0 <= row, cols <= 200 
// matrix[i][j] 为 '0' 或 '1' 
// 
// Related Topics 栈 数组 哈希表 动态规划 
// 👍 876 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximalRectangle(char[][] matrix) {
            int rows = matrix.length;
            if (rows == 0) {
                return 0;
            }
            int cols = matrix[0].length;
            if (cols == 0) {
                return 0;
            }
            int[][] dp = new int[rows][cols];
            for (int i = 0; i < cols; i++) {
                dp[0][i] = matrix[0][i] - 48;
            }
            int max = 0;
            int curMax = findMaxtrix(dp[0]);
            max = max < curMax ? curMax : max;
            for (int i = 1; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (matrix[i][j] != '0') {
                        dp[i][j] = dp[i - 1][j] + 1;
                    }
                }
                curMax = findMaxtrix(dp[i]);
                max = max < curMax ? curMax : max;
            }
            return max;
        }

        private int findMaxtrix(int[] nums) {
            int len = nums.length;
            Stack<Integer> stack = new Stack<>();
            stack.push(-1);
            int max = 0;
            for (int i = 0; i < len; i++) {
                while ((stack.peek() != -1 && nums[i] < nums[stack.peek()])) {
                    int curH = nums[stack.pop()];
                    int curW = i - stack.peek() - 1;
                    max = Math.max(max, curH * curW);
                }
                stack.push(i);
            }
            while (stack.peek() != -1) {
                int curH = nums[stack.pop()];
                int curW = len - stack.peek() - 1;
                max = Math.max(max, curH * curW);

            }

            return max;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}