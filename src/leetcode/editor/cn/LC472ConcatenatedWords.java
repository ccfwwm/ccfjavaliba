package leetcode.editor.cn;
//给定一个 不含重复 单词的字符串数组 words ，编写一个程序，返回 words 中的所有 连接词 。 
//
// 连接词 的定义为：一个字符串完全是由至少两个给定数组中的单词组成的。 
//
// 
//
// 示例 1： 
//
// 
//输入：words = ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","ra
//t","ratcatdogcat"]
//输出：["catsdogcats","dogcatsdog","ratcatdogcat"]
//解释："catsdogcats"由"cats", "dog" 和 "cats"组成; 
//     "dogcatsdog"由"dog", "cats"和"dog"组成; 
//     "ratcatdogcat"由"rat", "cat", "dog"和"cat"组成。
// 
//
// 示例 2： 
//
// 
//输入：words = ["cat","dog","catdog"]
//输出：["catdog"] 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 104 
// 0 <= words[i].length <= 1000 
// words[i] 仅由小写字母组成 
// 0 <= sum(words[i].length) <= 6 * 105 
// 
// Related Topics 深度优先搜索 字典树 动态规划 
// 👍 102 👎 0

import java.util.*;

public class LC472ConcatenatedWords {
    public static void main(String[] args) {
        Solution solution = new LC472ConcatenatedWords().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> ans;
        HashSet<String> set;

        public List<String> findAllConcatenatedWordsInADict(String[] words) {
            ans = new LinkedList<>();
            int n = words.length;

            //  Arrays.sort(words, (a, b) -> (a.length() - b.length()));
//            System.out.println(Arrays.toString(words));
            set = new HashSet<>();
            for (String s : words) {
                if (!words.equals(""))
                    set.add(s);
            }
            for (String s : words) {
                set.remove(s);
                if (dfs(s)) {
                    ans.add(s);
                }
                set.add(s);
            }
            return ans;
        }

        private boolean dfs(String word) {
            if (set.size() == 0) {
                return false;
            }
            int n = word.length();
            if(n==0){
                return false;
            }
            boolean[] dp = new boolean[n + 1];//表示0开头，长度为i是否能连接,dp已经压缩
            dp[0] = true;

            //i表示长度
            for (int i = 1; i <= n; i++) {
                //j表示index起点
                for (int j = 0; j < i; j++) {
                    //如果0到j无法组成，则直接跳过
                    if (!dp[j]) {
                        continue;
                    }
                    //dp[j]=true,同时j开始,长度为i的字符串，在set内，则dp[i]==true,同时跳过。
                    if (set.contains(word.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}