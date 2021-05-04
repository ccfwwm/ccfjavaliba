package leetcode.editor.cn;
//如果一个数列至少有三个元素，并且任意两个相邻元素之差相同，则称该数列为等差数列。 
//
// 例如，以下数列为等差数列: 
//
// 
//1, 3, 5, 7, 9
//7, 7, 7, 7
//3, -1, -5, -9 
//
// 以下数列不是等差数列。 
//
// 
//1, 1, 2, 5, 7 
//
// 
//
// 数组 A 包含 N 个数，且索引从 0 开始。该数组子序列将划分为整数序列 (P0, P1, ..., Pk)，满足 0 ≤ P0 < P1 < ... 
//< Pk < N。 
//
// 
//
// 如果序列 A[P0]，A[P1]，...，A[Pk-1]，A[Pk] 是等差的，那么数组 A 的子序列 (P0，P1，…，PK) 称为等差序列。值得注意的
//是，这意味着 k ≥ 2。 
//
// 函数要返回数组 A 中所有等差子序列的个数。 
//
// 输入包含 N 个整数。每个整数都在 -231 和 231-1 之间，另外 0 ≤ N ≤ 1000。保证输出小于 231-1。 
//
// 
//
// 示例： 
//
// 
//输入：[2, 4, 6, 8, 10]
//
//输出：7
//
//解释：
//所有的等差子序列为：
//[2,4,6]
//[4,6,8]
//[6,8,10]
//[2,4,6,8]
//[4,6,8,10]
//[2,4,6,8,10]
//[2,6,10]
// 
//
// 
// Related Topics 动态规划 
// 👍 111 👎 0

import java.util.HashMap;
import java.util.Map;

public class LC446ArithmeticSlicesIiSubsequence {
    public static void main(String[] args) {
        Solution solution = new LC446ArithmeticSlicesIiSubsequence().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numberOfArithmeticSlices(int[] nums) {
            int ans = 0, n = nums.length;
            Map<Long, Map<Long, Long>> dp = new HashMap<>();
            for (long i = 1; i < n; i++) {
                for (long k = 0; k < i; k++) {
                    long d = (long) nums[(int) i] - nums[(int) k];
                    dp.putIfAbsent(i, new HashMap<>());
                    long number = dp.get(i).getOrDefault(d, 0L);
                    long kNumber = dp.get(k) == null ? 0L : dp.get(k).getOrDefault(d, 0L);
                    ans += kNumber;
                    dp.get(i).put(d, number + kNumber + 1);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

















