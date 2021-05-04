package leetcode.editor.cn;
//电子游戏“辐射4”中，任务“通向自由”要求玩家到达名为“Freedom Trail Ring”的金属表盘，并使用表盘拼写特定关键词才能开门。 
//
// 给定一个字符串 ring，表示刻在外环上的编码；给定另一个字符串 key，表示需要拼写的关键词。您需要算出能够拼写关键词中所有字符的最少步数。 
//
// 最初，ring 的第一个字符与12:00方向对齐。您需要顺时针或逆时针旋转 ring 以使 key 的一个字符在 12:00 方向对齐，然后按下中心按钮，
//以此逐个拼写完 key 中的所有字符。 
//
// 旋转 ring 拼出 key 字符 key[i] 的阶段中： 
//
// 
// 您可以将 ring 顺时针或逆时针旋转一个位置，计为1步。旋转的最终目的是将字符串 ring 的一个字符与 12:00 方向对齐，并且这个字符必须等于字符
// key[i] 。 
// 如果字符 key[i] 已经对齐到12:00方向，您需要按下中心按钮进行拼写，这也将算作 1 步。按完之后，您可以开始拼写 key 的下一个字符（下一阶段
//）, 直至完成所有拼写。 
// 
//
// 示例： 
//
// 
//
//
// 
//
// 
//输入: ring = "godding", key = "gd"
//输出: 4
//解释:
// 对于 key 的第一个字符 'g'，已经在正确的位置, 我们只需要1步来拼写这个字符。 
// 对于 key 的第二个字符 'd'，我们需要逆时针旋转 ring "godding" 2步使它变成 "ddinggo"。
// 当然, 我们还需要1步进行拼写。
// 因此最终的输出是 4。
// 
//
// 提示： 
//
// 
// ring 和 key 的字符串长度取值范围均为 1 至 100； 
// 两个字符串中都只有小写字符，并且均可能存在重复字符； 
// 字符串 key 一定可以由字符串 ring 旋转拼出。 
// 
// Related Topics 深度优先搜索 分治算法 动态规划 
// 👍 200 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC514FreedomTrail {
    public static void main(String[] args) {
        Solution solution = new LC514FreedomTrail().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<Integer>[] pos = new List[26];
        int memo[][];

        public int findRotateSteps(String ring, String key) {
            memo = new int[ring.length()][key.length()];
            for (int i = 0; i < 26; i++) {
                pos[i] = new ArrayList<Integer>();
            }
            for (int i = 0; i < ring.length(); i++) {
                pos[ring.charAt(i) - 'a'].add(i);
            }
            return dp(ring, 0, key, 0);
        }

        private int dp(String ring, int i, String key, int j) {
            if (j == key.length()) {
                return 0;
            }
            if (memo[i][j] != 0) {
                return memo[i][j];
            }
            int n = ring.length();
            //做选择
            int res = Integer.MAX_VALUE;
            //ring上可能有多个字符key[j]
            for (int k : pos[key.charAt(j) - 'a']) {
                //拨打指针的次数
                int delta = Math.abs(k - i);
                //选择顺时针还是逆时针
                delta = Math.min(delta, n - delta);
                //将指针拨到rink[k],继续输入key[j+1]
                int subProblem = dp(ring, k, key, j + 1);
                //选择整体操作次数最少的
                //加一是因为按动按钮也是一次操作
                res = Math.min(res, 1 + delta + subProblem);
            }
            //结果存入备忘录
            memo[i][j] = res;
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

















