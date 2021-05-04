package leetcode.editor.cn;
//给定一个非负整数数组 nums 和一个整数 m ，你需要将这个数组分成 m 个非空的连续子数组。 
//
// 设计一个算法使得这 m 个子数组各自和的最大值最小。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [7,2,5,10,8], m = 2
//输出：18
//解释：
//一共有四种方法将 nums 分割为 2 个子数组。 其中最好的方式是将其分为 [7,2,5] 和 [10,8] 。
//因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4,5], m = 2
//输出：9
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,4,4], m = 3
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] <= 106 
// 1 <= m <= min(50, nums.length) 
// 
// Related Topics 二分查找 动态规划 
// 👍 473 👎 0

import java.util.Arrays;

public class LC410SplitArrayLargestSum {
    public static void main(String[] args) {
        Solution solution = new LC410SplitArrayLargestSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int splitArray(int[] nums, int m) {
            int len = nums.length;
            //计算前缀和
            int[] preSum = new int[len + 1];
            preSum[0] = 0;
            for (int i = 0; i < len; i++) {
                preSum[i + 1] = nums[i] + preSum[i];
            }
            int[][] dp = new int[len][m + 1];
            //初始化，先初始化一个最大值
            for (int i = 0; i < len; i++) {
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }
            //i结束分为1段的，即为前缀和
            for (int i = 0; i < len; i++) {
                dp[i][1] = preSum[i + 1];
            }
            //枚举分段
            for (int k = 2; k <= m; k++) {
                //枚举i结束，分为k段,i为下标,因此要-1
                for (int i = k - 1; i < len; i++) {
                    //枚举k-1段的j的位置，j至少要拥有k-1个元素，0开头，到k-2,即为k-1个元素。
                    for (int j = k - 2; j < i; j++) {
                        dp[i][k] = Math.min(dp[i][k], Math.max(dp[j][k - 1], preSum[i + 1] - preSum[j + 1]));
                    }
                }
            }
            return dp[len - 1][m];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}