package leetcode.editor.cn;
//把字符串 s 看作是“abcdefghijklmnopqrstuvwxyz”的无限环绕字符串，所以 s 看起来是这样的："...zabcdefghijklm
//nopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....". 
//
// 现在我们有了另一个字符串 p 。你需要的是找出 s 中有多少个唯一的 p 的非空子串，尤其是当你的输入是字符串 p ，你需要输出字符串 s 中 p 的不同
//的非空子串的数目。 
//
// 注意: p 仅由小写的英文字母组成，p 的大小可能超过 10000。 
//
// 
//
// 示例 1: 
//
// 
//输入: "a"
//输出: 1
//解释: 字符串 S 中只有一个"a"子字符。
// 
//
// 
//
// 示例 2: 
//
// 
//输入: "cac"
//输出: 2
//解释: 字符串 S 中的字符串“cac”只有两个子串“a”、“c”。.
// 
//
// 
//
// 示例 3: 
//
// 
//输入: "zab"
//输出: 6
//解释: 在字符串 S 中有六个子串“z”、“a”、“b”、“za”、“ab”、“zab”。.
// 
//
// 
// Related Topics 动态规划 
// 👍 148 👎 0

import java.util.HashSet;

public class LC467UniqueSubstringsInWraparoundString {
    public static void main(String[] args) {
        Solution solution = new LC467UniqueSubstringsInWraparoundString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findSubstringInWraproundString(String p) {
            //记录p中以每个字符结尾的最长连续子串的长度,如果一直连续，则必是最后一个对应的字母最长
            //又因为有S的限制，必定按s排列的p子串，才算
            //即当前字母结尾的子串，长度为连续的长度。
            int[] dp = new int[26];
            char[] arrP = p.toCharArray();
            //记录连续长度
            int count = 0;

            int index = 0;
            //遍历p中的所有字符
            for (int i = 0; i < arrP.length; i++) {
                //判断字符是否连续,a-z=-25,-25-1=-26,利用模的特性判断连续
                if (i > 0 && (arrP[i] - arrP[i - 1] - 1) % 26 == 0) {
                    count++;
                } else {
                    //不连续则刷新
                    count = 1;
                }
                //只存储最长的连续长度
                index = arrP[i] - 'a';
                dp[index] = Math.max(dp[index], count);
            }
            int result = 0;
            //统计所有字母的最长连续子串长度，就是唯一相等的子串的个数。
            for (int i : dp) {
                result += i;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}