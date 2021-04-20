package leetcode.editor.cn;
//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划 
// 👍 1051 👎 0

import java.util.Map;

public class LC152MaximumProductSubarray {
    public static void main(String[] args) {
        Solution solution = new LC152MaximumProductSubarray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProduct(int[] nums) {
            int n = nums.length;
            int iMax = 1;
            int iMin = 1;
            int max = Integer.MIN_VALUE;
            int tmp;
            for (int i = 0; i < n; i++) {
                if (nums[i] < 0) {
                    tmp = iMax;
                    iMax = iMin;
                    iMin = tmp;
                }
                iMax = Math.max(iMax * nums[i], nums[i]);
                iMin = Math.min(iMin * nums[i], nums[i]);
                max = Math.max(max, iMax);
            }
            return max;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}