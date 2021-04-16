package leetcode.editor.cn;
//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
// Related Topics 深度优先搜索 动态规划 回溯算法 
// 👍 692 👎 0

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC131PalindromePartitioning {
    public static void main(String[] args) {
        Solution solution = new LC131PalindromePartitioning().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean[][] dp;
        List<List<String>> list = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        int n;

        public List<List<String>> partition(String s) {
            n = s.length();
            dp = new boolean[n][n];
//            for (int i = 0; i <= n - 1; i++) {
//                Arrays.fill(dp[i], true);
//            }
            //dp[i][j] 第j个字母,长度为i的字符串（包含j),是否为字符串
            for (int i = n - 1; i >= 0; i--) {
                for (int j = i; j < n; j++) {
                    dp[i][j] = (i == j) || (s.charAt(j) == s.charAt(i)) && (j - i == 1 || dp[i + 1][j - 1]);
                }
            }
            dfs(s, 0);
            return list;
        }

        private void dfs(String s, int index) {
            if (index == n) {
                list.add(new ArrayList<String>(ans));
                return;
            }
            for (int j = index; j < n; j++) {
                if (dp[index][j]) {
                    ans.add(s.substring(index, j + 1));
                    dfs(s, j + 1);
                    ans.remove(ans.size() - 1);
                }
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}