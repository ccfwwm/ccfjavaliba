package leetcode.editor.cn;
//给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。 
//
// 
//
// 示例 1: 
//输入: 
//
// "bbbab"
// 
//
// 输出: 
//
// 4
// 
//
// 一个可能的最长回文子序列为 "bbbb"。 
//
// 示例 2: 
//输入: 
//
// "cbbd"
// 
//
// 输出: 
//
// 2
// 
//
// 一个可能的最长回文子序列为 "bb"。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 只包含小写英文字母 
// 
// Related Topics 动态规划 
// 👍 437 👎 0

import java.util.Arrays;

public class LC516LongestPalindromicSubsequence {
    public static void main(String[] args) {
        Solution solution = new LC516LongestPalindromicSubsequence().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] memo;

        public int longestPalindromeSubseq(String s) {
            int n = s.length();
            memo = new int[n][n];
            for (int i = n - 1; i >= 0; i--) {
                memo[i][i] = 1;
                for (int j = i + 1; j < n; j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        memo[i][j] = 2 + memo[i + 1][j - 1];
                    } else {
                        memo[i][j] = Math.max(memo[i + 1][j], memo[i][j - 1]);
                    }
                }
            }
            return memo[0][n - 1];
//             return dfs(s, 0, n - 1);
        }

        private int dfs(String s, int start, int end) {
            if (start > end) {
                return 0;
            }
            if (memo[start][end] != 0) {
                return memo[start][end];
            }
            if (start == end) {
                memo[start][end] = 1;
            } else if (s.charAt(start) == s.charAt(end)) {
                memo[start][end] = 2 + dfs(s, start + 1, end - 1);
            } else {
                memo[start][end] = Math.max(dfs(s, start, end - 1), dfs(s, start + 1, end));
            }
            return memo[start][end];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}