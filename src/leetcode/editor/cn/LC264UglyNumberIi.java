package leetcode.editor.cn;
//给你一个整数 n ，请你找出并返回第 n 个 丑数 。 
//
// 丑数 就是只包含质因数 2、3 和/或 5 的正整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 10
//输出：12
//解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
//解释：1 通常被视为丑数。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 1690 
// 
// Related Topics 堆 数学 动态规划 
// 👍 644 👎 0

import java.util.*;

public class LC264UglyNumberIi {
    public static void main(String[] args) {
        Solution solution = new LC264UglyNumberIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nthUglyNumber(int n) {
            int[] res = new int[n];
            int p2 = 0, p3 = 0, p5 = 0;
            res[0] = 1;
            for (int i = 1; i < n; i++) {
                res[i] = Math.min(Math.min(res[p2] * 2, res[p3] * 3), res[p5] * 5);
                if (res[i] == res[p2] * 2) p2++;
                if (res[i] == res[p3] * 3) p3++;
                if (res[i] == res[p5] * 5) p5++;
            }
            return res[n - 1];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}