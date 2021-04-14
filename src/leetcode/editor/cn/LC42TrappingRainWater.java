package leetcode.editor.cn;

public class LC42TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new LC42TrappingRainWater().new Solution();
    }

    /**
     * 题目Id：42
     * 题目：接雨水
     * 日期：2021-04-12 16:09:56
     */
//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 0 <= n <= 3 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics 栈 数组 双指针 动态规划 
// 👍 2256 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            int left = 0;
            int right = height.length - 1;
            int allSum = 0;
            int i;
            while (left < right) {
                if (height[left] <= height[right]) {
                    i = left + 1;
                    while (i < right && height[i] <= height[left]) {
                        allSum = allSum + height[left] - height[i];
                        i++;
                    }
                    left = i;
                } else {
                    i = right - 1;
                    while (i > left && height[i] <= height[right]) {
                        allSum = allSum + height[right] - height[i];
                        i--;
                    }
                    right = i;
                }
            }
            return allSum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}