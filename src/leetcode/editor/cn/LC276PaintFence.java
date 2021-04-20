package leetcode.editor.cn;
//有 k 种颜色的涂料和一个包含 n 个栅栏柱的栅栏，请你按下述规则为栅栏设计涂色方案： 
//
// 
// 每个栅栏柱可以用其中 一种 颜色进行上色。 
// 相邻的栅栏柱 最多连续两个 颜色相同。 
// 
//
// 给你两个整数 k 和 n ，返回所有有效的涂色 方案数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3, k = 2
//输出：6
//解释：所有的可能涂色方案如上图所示。注意，全涂红或者全涂绿的方案属于无效方案，因为相邻的栅栏柱 最多连续两个 颜色相同。
// 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：n = 7, k = 2
//输出：42
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 50 
// 1 <= k <= 105 
// 题目数据保证：对于输入的 n 和 k ，其答案在范围 [0, 231 - 1] 内 
// 
// Related Topics 动态规划 
// 👍 108 👎 0

public class LC276PaintFence {
    public static void main(String[] args) {
        Solution solution = new LC276PaintFence().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numWays(int n, int k) {
            if (k == 1 && n > 2) {
                return 0;
            }
            if (k == 1) {
                return 1;
            }
            if (n == 1) {
                return k;
            }
            if (n == 2) {
                return k * k;
            }
            int[] dp = new int[n + 1];
            dp[1] = k;
            dp[2] = k * k;
            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 1] * (k - 1) + dp[i - 2] * (k - 1);
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}