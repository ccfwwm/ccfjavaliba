package leetcode.editor.cn;
//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。 
//
// 返回符合要求的 最少分割次数 。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：1
//解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：s = "ab"
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2000 
// s 仅由小写英文字母组成 
// 
// 
// 
// Related Topics 动态规划 
// 👍 414 👎 0

import java.util.Arrays;

public class LC132PalindromePartitioningIi {
    public static void main(String[] args) {
        Solution solution = new LC132PalindromePartitioningIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCut(String s) {
            int n = s.length();
            boolean[][] jugePalindrome = new boolean[n][n];
            for (int i = n - 1; i >= 0; i--) {
                for (int j = i; j < n; j++) {
                    jugePalindrome[i][j] = (s.charAt(i) == s.charAt(j)) && (j - i < 2 || jugePalindrome[i + 1][j - 1]);
                }
            }
            int[] dp = new int[n];
            for (int i = 0; i < n; i++) {
                dp[i] = i;
            }
            for (int i = 1; i < n; i++) {
                if (jugePalindrome[0][i]) {
                    dp[i] = 0;
                    continue;
                }
                for (int j = 0; j < i; j++) {
                    if (jugePalindrome[j + 1][i]) {
                        dp[i] = dp[i]>(dp[j] + 1)?(dp[j]+1):dp[i];
                    }
                }
            }

            return dp[n - 1];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}