package leetcode.editor.cn;
//给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10n 。 
//
// 示例: 
//
// 输入: 2
//输出: 91 
//解释: 答案应为除去 11,22,33,44,55,66,77,88,99 外，在 [0,100) 区间内的所有数字。
// 
// Related Topics 数学 动态规划 回溯算法 
// 👍 132 👎 0

public class LC357CountNumbersWithUniqueDigits {
    public static void main(String[] args) {
        Solution solution = new LC357CountNumbersWithUniqueDigits().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countNumbersWithUniqueDigits(int n) {
            if (n < 1) {
                return 1;
            }
            int[] dp = new int[n + 1];

            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1] * 10 + (9 * (int) Math.pow(10, i - 2) - dp[i - 1]) * (i - 1);
            }
            int sum = 0;
            for (int i = 0; i < n + 1; i++) {
                sum += dp[i];
            }

            return (int) Math.pow(10, n) - sum;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
















