package leetcode.editor.cn;
//给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的
//句子。 
//
// 说明： 
//
// 
// 分隔时可以重复使用字典中的单词。 
// 你可以假设字典中没有重复的单词。 
// 
//
// 示例 1： 
//
// 输入:
//s = "catsanddog"
//wordDict = ["cat", "cats", "and", "sand", "dog"]
//输出:
//[
//  "cats and dog",
//  "cat sand dog"
//]
// 
//
// 示例 2： 
//
// 输入:
//s = "pineapplepenapple"
//wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
//输出:
//[
//  "pine apple pen apple",
//  "pineapple pen apple",
//  "pine applepen apple"
//]
//解释: 注意你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 输入:
//s = "catsandog"
//wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出:
//[]
// 
// Related Topics 动态规划 回溯算法 
// 👍 443 👎 0

import java.util.*;
import java.util.function.Supplier;

public class LC140WordBreakIi {
    public static void main(String[] args) {
        Solution solution = new LC140WordBreakIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> list = new LinkedList<>();
        StringBuilder ans = new StringBuilder();
        HashSet<String> hash;
        int n;
        boolean[] dp;

        public List<String> wordBreak(String s, List<String> wordDict) {
            if (s.length() == 0) {
                return new ArrayList<>();
            }
            n = s.length();
            dp = new boolean[n + 1];
            hash = new HashSet<>(wordDict);

            dp[n] = true;
            //倒序遍历，表示s的当前index 到s.length是否可以分割
            for (int i = n - 1; i >= 0; i--) {
                for (int j = i + 1; j <= n; j++) {
                    if (dp[j] && hash.contains(s.substring(i, j))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            dfs(s, 0, 1);
            return list;
        }

        private void dfs(String s, int start, int index) {
            if (index > n) {
                return;
            }

            if (dp[index] == true) {
                String cur = s.substring(start, index);
                if (hash.contains(cur)) {
                    ans.append(cur);
                    if (index == n) {
                        list.add(ans.toString());
                    }
                    ans.append(" ");
                    dfs(s, index, index + 1);
                    ans.delete(ans.length() - cur.length() - 1, ans.length());
                }
            }
            dfs(s, start, index + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}