package leetcode.editor.cn;
//在 "100 game" 这个游戏中，两名玩家轮流选择从 1 到 10 的任意整数，累计整数和，先使得累计整数和达到或超过 100 的玩家，即为胜者。 
//
// 如果我们将游戏规则改为 “玩家不能重复使用整数” 呢？ 
//
// 例如，两个玩家可以轮流从公共整数池中抽取从 1 到 15 的整数（不放回），直到累计整数和 >= 100。 
//
// 给定一个整数 maxChoosableInteger （整数池中可选择的最大数）和另一个整数 desiredTotal（累计和），判断先出手的玩家是否能稳
//赢（假设两位玩家游戏时都表现最佳）？ 
//
// 你可以假设 maxChoosableInteger 不会大于 20， desiredTotal 不会大于 300。 
//
// 示例： 
//
// 输入：
//maxChoosableInteger = 10
//desiredTotal = 11
//
//输出：
//false
//
//解释：
//无论第一个玩家选择哪个整数，他都会失败。
//第一个玩家可以选择从 1 到 10 的整数。
//如果第一个玩家选择 1，那么第二个玩家只能选择从 2 到 10 的整数。
//第二个玩家可以通过选择整数 10（那么累积和为 11 >= desiredTotal），从而取得胜利.
//同样地，第一个玩家选择任意其他整数，第二个玩家都会赢。
// 
// Related Topics 极小化极大 动态规划 
// 👍 226 👎 0

import java.util.Arrays;
import java.util.HashMap;

public class LC464CanIWin {
    public static void main(String[] args) {
        Solution solution = new LC464CanIWin().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
            //数字大于总和，肯定第一次就能赢
            if (maxChoosableInteger >= desiredTotal) {
                return true;
            }
            //数字总和都小于0,无论如何输
            if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) {
                return false;
            }
            Boolean[] dp = new Boolean[(1 << maxChoosableInteger) - 1];

            return dfs(maxChoosableInteger, desiredTotal, 0, dp);
        }

        private boolean dfs(int maxChoosableInteger, int desiredTotal, int state, Boolean[] dp) {
            if (dp[state] != null) {
                return dp[state];
            }
            for (int i = 1; i <= maxChoosableInteger; i++) {
                int tmp = (1 << (i - 1));
                if ((tmp & state) == 0) {
                    if (desiredTotal - i <= 0 || !dfs(maxChoosableInteger, desiredTotal - i, tmp | state, dp)) {
                        dp[state] = true;
                        return true;
                    }
                }
            }
            dp[state] = false;
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
















